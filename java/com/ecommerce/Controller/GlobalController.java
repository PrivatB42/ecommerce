package com.ecommerce.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.Entity.Article_order;
import com.ecommerce.Entity.Comment;
import com.ecommerce.Entity.Order;
import com.ecommerce.Repository.Article_orderRepository;
import com.ecommerce.Repository.CommentRepository;
import com.ecommerce.Repository.OrderReposistory;

@Controller
public class GlobalController {
	
	@Autowired
	private Article_orderRepository article_orderRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private OrderReposistory orderRepository;
	
	
	
	@PostMapping(value="/comment/save")
	public ResponseEntity<Comment> ajoutcomment(@RequestBody Comment comment){
		Comment commentadd = commentRepository.save(comment);
		if (commentadd == null) {
			return ResponseEntity.noContent().build();		
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(commentadd.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping(value="/comment/uptade")
	public  void modifcomment( @RequestBody Comment comment ){
		
		commentRepository.save(comment);	
	}
	
	
	@GetMapping("/comment/affiche")
	public @ResponseBody Iterable<Comment> getAllComment(){
		return commentRepository.findAll();
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		
		return "index";
		
	}
	
	 @GetMapping("/mem")
	   public String viewComment(Model model) {

	      List<Comment> list = CommentRepository.getComment();

	      model.addAttribute("mem", list);

	      return "index";
	   }
	
	
	@GetMapping("/order/affiche")
	public @ResponseBody Iterable<Order> getAllOrder(){
		return orderRepository.findAll();
	}
	
	@GetMapping("/article_order/affiche")
	public @ResponseBody Iterable<Article_order> getAllUsers(){
		return article_orderRepository.findAll();
	}
	
	
	
}
