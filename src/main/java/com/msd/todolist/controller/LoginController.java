package com.msd.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msd.todolist.mapper.UserMasterMapper;
import com.msd.todolist.pojo.UserMaster;

@RestController
public class LoginController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/getLogin")
	public List<UserMaster> getLogin() throws Exception{
		return jdbcTemplate.query("SELECT * FROM user_master", new UserMasterMapper());
	}
}
