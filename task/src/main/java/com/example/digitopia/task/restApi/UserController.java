package com.example.digitopia.task.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitopia.task.Business.IUserService;
import com.example.digitopia.task.Entities.User;

@RestController
@RequestMapping("/")
public class UserController {
	private IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users/{id}")
	public User get(@PathVariable int id){
		return userService.getById(id);
	}
	
	@PostMapping("/users/create")
	public void create(@RequestBody User user){
		userService.add(user);
	}
	
	@GetMapping("/users/name={name}")
	public List<User> getUsersByName(@PathVariable String name){
		
		return  userService.getUsersByNormalizedName(name);
	}
	
	@GetMapping("/users/mail={mail}")
	public User getUserByMail(@PathVariable String mail){
		
		return  userService.getUserByEmail(mail);
	}
}
