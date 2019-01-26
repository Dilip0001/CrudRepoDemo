package com.concretepage.service;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.Article;

@Repository
public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(long articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
	Article findDistinctByCategory(String category);
}
