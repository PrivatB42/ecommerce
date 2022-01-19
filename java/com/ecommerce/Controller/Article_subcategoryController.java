package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.Article_subcategory;
import com.ecommerce.Repository.Article_subcategoryRepository;

@Controller
@RequestMapping(path = "/subcategory")
public class Article_subcategoryController {
	
	
	@Autowired
	private Article_subcategoryRepository article_subcategoryRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewSubcategory (@RequestParam String name) {
		Article_subcategory subc = new Article_subcategory();
		subc.setName(name);
		article_subcategoryRepository.save(subc);
		return "saved";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Article_subcategory> getAllsubCategory(){
		return article_subcategoryRepository.findAll();
	}
}
