package ch.swiggels.weddingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.swiggels.weddingApp.domain.Article;
import ch.swiggels.weddingApp.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Article> findByName(String name);

}
