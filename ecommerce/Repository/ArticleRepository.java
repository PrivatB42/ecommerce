package com.ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.Entity.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
