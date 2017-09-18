package com.msd.todolist.service;

import java.util.Map;

import com.msd.todolist.pojo.UserMaster;

public interface LoginService {

	public Map<String, Object> registerUser(UserMaster user);
}
