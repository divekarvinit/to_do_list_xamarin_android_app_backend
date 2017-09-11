package com.msd.todolist.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.msd.todolist.pojo.UserMaster;

public class UserMasterMapper implements RowMapper<UserMaster>{

	@Override
	public UserMaster mapRow(ResultSet rs, int rowNumber) throws SQLException {
		UserMaster userMaster = new UserMaster();
		userMaster.setUserName(rs.getString("user_name"));
		userMaster.setEmailId(rs.getString("email_id"));
		return userMaster;
	}

}
