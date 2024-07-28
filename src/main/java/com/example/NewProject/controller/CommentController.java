package com.example.NewProject.controller;

import com.example.NewProject.repository.ArticleRepository;
import com.example.NewProject.repository.CommentRepository;
import com.example.NewProject.repository.UserRepository;
import com.example.NewProject.schema.Article;
import com.example.NewProject.schema.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    Article article;
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public CommentController(CommentRepository commentRepository,
                             ArticleRepository articleRepository,
                             UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    private Article getArticleById(int id){
        return articleRepository.getReferenceById(id);
    }
    @GetMapping("api/article/{id}/comment/")
    public List<Comment> getAllComment(
            @PathVariable("id") int id
    ){
        article = getArticleById(id);
        return article.getComments();
    }

    @PostMapping("api/article/{id}/comment/")
    public Comment postComment(
            @PathVariable("id") int id,
            @RequestBody Comment comment
    ){
        article = getArticleById(id);
        comment.setArti(article);
        return commentRepository.save(comment);

    }
    @PutMapping("api/article/{id}/comment/{comment_id}/{username}")
    public Comment editComment(
            @PathVariable("id") int id,
            @PathVariable("comment_id") int commentId,
            @PathVariable("username") String username,
            @RequestBody Comment comment
    ) throws Exception {
        article = getArticleById(id);
        Comment oldComment =article.getComments().get(commentId);
        if (oldComment.getUsername() != null && username.equals(oldComment.getUsername())){
            //the user is the same person that post the original message hence, he/she has
            //the right to edit


            oldComment.setMessage(comment.getMessage());

            return commentRepository.save(oldComment);
        }
        else{
            throw new Exception("user authorization denied");
        }

    }

    @DeleteMapping("api/article/{id}/comment/{comment_id}/{username}")
    public void deleteComment(
            @PathVariable("id") int id,
            @PathVariable("comment_id") int commentId,
            @PathVariable("username") String username
    ) throws Exception {
        article = getArticleById(id);
        Comment oldComment =article.getComments().get(commentId);
        if (username.equals(oldComment.getUsername())){
            //the user is the same person that post the original message hence, he/she has
            //the right to delete it



             commentRepository.delete(oldComment);
        }
        else{
            throw new Exception("user authorization denied");
        }

    }

    @PostMapping("api/article/{article_id}/comment/{comment_id}/{username}")
    public Comment likeComment(
            @PathVariable("article_id") int article_id,
            @PathVariable("commentId") int commentId,
            @PathVariable("username") String username,
            @RequestParam("like") boolean like
    ) throws Exception {


        article = getArticleById(article_id);
        List<String> voteList = article.getComments().get(commentId-1).getVotedUsers();
        boolean voted = false;
        for(String user : voteList){
            if (username.equals(user)){
                voted = true;
                break;
            }
        }
        if (voted){
             throw new Exception("Not authorize to vote twice");
        }
        Comment comment = article.getComments().get(commentId-1);
        comment.getVotedUsers().add(username);
        if(like){
            comment.setLike(comment.getLike()+1);
        }
        else{
            comment.setDisLike(comment.getDisLike()+1);
        }

        comment.setArti(article);
        return commentRepository.save(comment);

    }

}
