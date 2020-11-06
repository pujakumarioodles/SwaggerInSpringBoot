package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.service.Contact;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(path="/user" , consumes="application/json")
	public List<User> addUser(@RequestBody User user)
	{
	return  this.userService.addUser(user);	
		
	}
	@GetMapping("/user")
	public List<User> getALLUser()
	{
		return this.userService.getUser();
		
	}
	@GetMapping("/user/{userId}")
	@ApiOperation(value="get user by id",notes="provide user id to get a details of specific user",
	response=User.class)
	public User getUser(@PathVariable int userId)
	{
		return this.userService.getUser(userId);
	}
	
	  @PutMapping(path="/user" ,consumes="application/json")
	  public List<User>  updateUserDetails(@RequestBody User user)
	  {
		return this.userService.updateUserDetails(user);  
	  }
	@DeleteMapping("/user/{userId}")
	public List<User> deleteUser(@PathVariable int userId)
	{
		return this.userService.deleteUser(userId);
	}
}
