package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.Article_order;
import com.ecommerce.Repository.Article_orderRepository;

@Controller
@RequestMapping(path = "/articleorder")
public class Article_orderController {
	
	@Autowired
	private Article_orderRepository article_orderReposity;
	

	@PostMapping(path="/add")
	public @ResponseBody String addNewOrder (@RequestParam int price) {
		Article_order artord = new Article_order();
		artord.setPrice(price);
		article_orderReposity.save(artord);
		return "saved";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Article_order> getAllUsers(){
		return article_orderReposity.findAll();
	}

}
