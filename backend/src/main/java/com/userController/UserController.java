package com.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
public class UserController {
	
	UserService loginSerivce; 
	Gson gson = new Gson(); 
	
	//dependency injection of login service 
	@Autowired
	public UserController(UserService loginSerivce) {
		this.loginSerivce = loginSerivce;
	}

	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
	public String getUsers() {
		return gson.toJson(loginSerivce.getAllUser());
	}
}