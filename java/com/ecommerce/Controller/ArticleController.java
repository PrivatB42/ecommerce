package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.Article;
import com.ecommerce.Repository.ArticleRepository;

@Controller
@RequestMapping(path = "/article")
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@PostMapping(name="/add")
	public @ResponseBody String AddNewArticle(@RequestParam String title, @RequestParam String description, 
			@RequestParam int price, @RequestParam int quantity ) {
		Article a= new Article();
		a.setTitle(title);
		a.setDescription(description);
		a.setPrice(price);
		a.setQuantity(quantity);
		articleRepository.save(a);
		return "saved";
		
	}
	
	@GetMapping
	public @ResponseBody Iterable<Article> getAllUsers(){
		return articleRepository.findAll();
	}


}
