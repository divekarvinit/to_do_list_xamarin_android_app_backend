package com.msd.todolist.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.msd.todolist.pojo.UserMaster;

public class UserMasterMapper implements RowMapper<UserMaster>{

	@Override
	public UserMaster mapRow(ResultSet rs, int rowNumber) throws SQLException {
		UserMaster userMaster = null;
		if(rs != null) {
			userMaster = new UserMaster();
			userMaster.setFirstName(rs.getString("first_name"));
			userMaster.setLastName(rs.getString("last_name"));
			userMaster.setPassword(rs.getString("password"));
			userMaster.setCreatedBy(rs.getString("created_by"));
			userMaster.setModifiedBy(rs.getString("modified_by"));
			userMaster.setCreatedDate(rs.getTimestamp("created_date"));
			userMaster.setModifiedDate(rs.getTimestamp("modified_date"));
			userMaster.setJoiningDate(rs.getTimestamp("joining_date"));
			userMaster.setUserName(rs.getString("user_name"));
			userMaster.setEmailId(rs.getString("email_id"));	
		}
		return userMaster;
	}

}
