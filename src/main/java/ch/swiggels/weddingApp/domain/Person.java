package ch.swiggels.weddingApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	private int id;
	private String name;

}
