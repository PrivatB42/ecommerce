package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.Article_image;
import com.ecommerce.Repository.Article_imageRepository;

@Controller
@RequestMapping(path = "/articleimage")
public class Article_imageController {
	
	@Autowired
	private Article_imageRepository article_imageRepository;
	

	@PostMapping(path="/add")
	public @ResponseBody String addNewArticleImage (@RequestParam String url) {
		Article_image arti = new Article_image();
		arti.setUrl(url);
		article_imageRepository.save(arti);
		return "saved";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Article_image> getAllUsers(){
		return article_imageRepository.findAll();
	}

}
