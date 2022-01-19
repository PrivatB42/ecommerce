package com.ecommerce.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Article_order")
public class Article_order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int price;
	
	@OneToOne
	@JoinColumn(name = "article_id")
	private Article article;
	
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public long getId() {
		return id;
	}

	public Article_order(long id, int price, Article article, Order order) {
		super();
		this.id = id;
		this.price = price;
		this.article = article;
		this.order = order;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Article_order() {
		super();
	}
	

}
