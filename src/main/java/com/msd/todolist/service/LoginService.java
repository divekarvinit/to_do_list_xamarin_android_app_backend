package com.msd.todolist.service;

import java.util.Map;

import com.msd.todolist.pojo.UserMaster;

/* LoginService by VINIT DIVEKAR- 17960822 STARTS*/
public interface LoginService {

	public Map<String, Object> registerUser(UserMaster user);

	public Map<String, Object> loginUser(UserMaster user);
}
/* LoginService by VINIT DIVEKAR- 17960822 ENDS*/
