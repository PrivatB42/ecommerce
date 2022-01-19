package com.ecommerce.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Article")
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	private int price;
	private int quantity;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date created_at;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date updated_at;
	
	@ManyToOne
	@JoinColumn(name= "subcategory_id")
	private Article_subcategory article_subcategory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Article_subcategory getArticle_subcategory() {
		return article_subcategory;
	}

	public void setArticle_subcategory(Article_subcategory article_subcategory) {
		this.article_subcategory = article_subcategory;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
