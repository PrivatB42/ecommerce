package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.Comment;
import com.ecommerce.Repository.CommentRepository;

@Controller
public class CommentController {
	
	@Autowired
	private CommentRepository commentReposity;
	

	@PostMapping(path="/add")
	public @ResponseBody String addNewArticleImage (@RequestParam String body) {
		Comment com = new Comment();
		com.setBody(body);
		commentReposity.save(com);
		return "saved";
	}
	
	@GetMapping
	public @ResponseBody Iterable<Comment> getAllUsers(){
		return commentReposity.findAll();
	}

}
