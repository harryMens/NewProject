package com.example.NewProject.repository;

import com.example.NewProject.schema.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT votedUsers FROM USERINFO WHERE ID = ?1", nativeQuery = true)
    List<String> getVotedListById(int id);
}
