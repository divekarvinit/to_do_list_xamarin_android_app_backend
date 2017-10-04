package com.msd.todolist.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msd.todolist.pojo.UserMaster;
import com.msd.todolist.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST, headers={"Content-Type=application/json"})
	public Map<String, Object> registerUser(@RequestBody UserMaster user) throws Exception{
		return loginService.registerUser(user);
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST, headers={"Content-Type=application/json"})
	public Map<String, Object> loginUser(@RequestBody UserMaster user) throws Exception{
		HashMap<String, Object> returnmap = new HashMap<String, Object>();
		returnmap.put("success","Y");
		return loginService.loginUser(user);
	}
}
