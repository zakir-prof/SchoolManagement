package com.accolite.schoolmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.schoolmanagement.model.User;
import com.accolite.schoolmanagement.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	private UserService userService;
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public @ResponseBody String signIn(@RequestBody User user){
		return userService.signIn(user);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public void register(@RequestBody User user){
		userService.register(user);
	}
	
	@RequestMapping(value="/get/email/{email}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody User getUser(@PathVariable("email") String email){
		return userService.getUser(email);
	}
}
