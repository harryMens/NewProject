package com.example.NewProject.controller;

import com.example.NewProject.repository.ArticleRepository;
import com.example.NewProject.schema.Article;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    private Article getArticleById(int id){
        return articleRepository.getReferenceById(id);
    }

    @GetMapping("api/article")
    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }

//    @PostMapping("api/article")
//    public Article postArticle(
//            @RequestBody Article article
//    ){
//        return articleRepository.save(article);
//
//    }
//    @PutMapping("api/article/{id}/{username}")
//    public Article editArticle(
//            @PathVariable("id") int id,
//            @PathVariable("username") String username,
//            @RequestBody Article article
//    ) throws Exception {
//
//        //we retrieve the article we want to update from the database
//        Article oldArticle = getArticleById(id);
//
//        if (article.getUsername() != null && username.equals(oldArticle.getUsername())){
//            //the user is the same person that post the original message hence, he/she has
//            //the right to edit
//
//            if (article.getMessage() != null) {
//                oldArticle.setMessage(article.getMessage());
//            }
//            if (article.getTitle() != null) {
//                oldArticle.setTitle(article.getTitle());
//            }
//
//            return articleRepository.save(oldArticle);
//        }
//        else{
//            throw new Exception("user authorization denied");
//        }
//
//    }
//
//    @DeleteMapping("api/article/{id}/{username}")
//    public void deleteArticle(
//            @PathVariable("id") int id,
//            @PathVariable("username") String username
//    ) throws Exception {
//        Article oldArticle = getArticleById(id);
//        if (username.equals(oldArticle.getUsername())) {
//            //the user is the same person that post the original message hence, he/she has
//            //the right to edit
//
//            articleRepository.delete(oldArticle);
//
//        }
//        else {
//            throw new AccessDeniedException("you are not authorise to delete this article");
//        }
//    }
//
//    @PostMapping("api/article/{article_id}/{username}")
//    public Article likeArticle(
//            @PathVariable("article_id") int article_id,
//            @PathVariable("username") String username,
//            @RequestParam("like") boolean like
//    ) throws AccessDeniedException {
//
//
//        Article article = getArticleById(article_id);
//        List<String> voteList = article.getVotedUsers();
//        boolean voted = false;
//        for(String user : voteList){
//            if (username.equals(user)){
//                voted = true;
//                break;
//            }
//        }
//        if (voted){
//            throw new AccessDeniedException("Not authorize to vote twice");
//        }
//        article.getVotedUsers().add(username);
//        if(like){
//            article.setLike(article.getLike()+1);
//        }
//        else{
//            article.setDisLike(article.getDisLike()+1);
//        }
//
//        return articleRepository.save(article);
//
//    }
}
