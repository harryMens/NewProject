package com.example.NewProject.schema;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "commentInfo")
public class Comment {


    @Id
    @GeneratedValue
    private Integer id;

    private String username;
    private String message;
    private int like;
    private int disLike;
    private List<String> votedUsers;
//
    @ManyToOne
    @JoinColumn(name = "comments_id")
    @JsonBackReference
    private Article arti;

    public Comment(String username, String message, int like, int disLike, List<String> votedUsers, Article arti) {
        this.username = username;
        this.message = message;
        this.like = like;
        this.disLike = disLike;
        this.votedUsers = votedUsers;
        this.arti = arti;
    }

    public Comment() {
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

    public Article getArti() {
        return arti;
    }

    public void setArti(Article arti) {
        this.arti = arti;
    }

    public List<String> getVotedUsers() {
        return votedUsers;
    }

    public void setVotedUsers(List<String> votedUsers) {
        this.votedUsers = votedUsers;
    }
}
