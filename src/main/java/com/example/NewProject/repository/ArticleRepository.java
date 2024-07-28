package com.example.NewProject.repository;

import com.example.NewProject.schema.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
