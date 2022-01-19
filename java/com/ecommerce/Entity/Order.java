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
@Table(name = "Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String delivery_adress;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date created_at;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getDelivery_adress() {
		return delivery_adress;
	}

	public void setDelivery_adress(String delivery_adress) {
		this.delivery_adress = delivery_adress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
