package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.Article_category;
import com.ecommerce.Repository.Article_categoryRepository;

@Controller
@RequestMapping(path="/category")
public class Article_categoryController {
	
	@Autowired
	private Article_categoryRepository article_categoryRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewCategory (@RequestParam String name) {
		Article_category art = new Article_category();
		art.setName(name);
		article_categoryRepository.save(art);
		return "saved";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Article_category> getAllCategory(){
		return article_categoryRepository.findAll();
	}


}
