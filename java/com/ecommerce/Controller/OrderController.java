package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.Order;
import com.ecommerce.Repository.OrderReposistory;


@Controller
@RequestMapping(path = "/order")
public class OrderController  {
	
	@Autowired
	private OrderReposistory orderReposity;
	

	@PostMapping(path="/add")
	public @ResponseBody String addNewOrder (@RequestParam String delivery_adress) {
		Order ord = new Order();
		ord.setDelivery_adress(delivery_adress);
		orderReposity.save(ord);
		return "saved";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Order> getAllUsers(){
		return orderReposity.findAll();
	}

}
