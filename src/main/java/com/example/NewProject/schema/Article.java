package com.example.NewProject.schema;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "articleInfo")

public class Article {


    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String title;
    private String message;
    private int like;
    private int disLike;
    private List<String> votedUsers;
    @OneToMany(mappedBy = "arti")
    @JsonManagedReference
    private List<Comment> comments;


    public Article(String username, String title, String message, int like, int disLike, List<String> votedUsers, List<Comment> comments) {
        this.username = username;
        this.title = title;
        this.message = message;
        this.like = like;
        this.disLike = disLike;
        this.votedUsers = votedUsers;
        this.comments = comments;
    }

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDisLike() {
        return disLike;
    }

    public void setDisLike(int disLike) {
        this.disLike = disLike;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<String> getVotedUsers() {
        return votedUsers;
    }

    public void setVotedUsers(List<String> votedUsers) {
        this.votedUsers = votedUsers;
    }
}
