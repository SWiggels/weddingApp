package ch.swiggels.weddingApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String url;
	private String description;
	private int amount;
	private String image;
	private int person_id;

	public Boolean isReserved() {
		return person_id > 0 ? false : true;
	}

}
