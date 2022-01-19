package com.ecommerce.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Article_subcategory")
public class Article_subcategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Article_category article_category;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Article_category getArticle_category() {
		return article_category;
	}

	public void setArticle_category(Article_category article_category) {
		this.article_category = article_category;
	}

	public Article_subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
