package ch.swiggels.weddingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.swiggels.weddingApp.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	List<Article> findByName(String name);

}
