package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.Entity.User;
import com.ecommerce.Repository.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController {
	

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String firstname, @RequestParam String email, @RequestParam String password,@RequestParam String basket) {
		User n = new User();
		n.setFirstname(firstname);
		n.setEmail(email);
		n.setPassword(password);
		n.setBasket(basket);
		userRepository.save(n);
		return "saved";
	}
	
	@GetMapping
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}

}
