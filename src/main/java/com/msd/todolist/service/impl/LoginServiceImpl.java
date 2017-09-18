package com.msd.todolist.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.msd.todolist.mapper.UserMasterMapper;
import com.msd.todolist.pojo.UserMaster;
import com.msd.todolist.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> registerUser(UserMaster user) {
		boolean isRecordValid = true;
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		
		// Check if user name is already taken.
		UserMaster userWithUsername = getUserFromUsername(user.getUserName()); 
		
		if(userWithUsername != null) {
			isRecordValid = false;
			returnMap.put("success", "N");
			returnMap.put("fieldName", "userName");
			returnMap.put("message", "Username is already taken. Please select a different one");
		}
		
		// Check if email id is already taken
		
		UserMaster userWithEmaiId = getUserFromEmailId(user.getEmailId());
		
		if(userWithEmaiId != null) {
			isRecordValid = false;
			returnMap.put("success", "N");
			returnMap.put("fieldName", "emailId");
			returnMap.put("message", "User with the given email ID is already registered.");
		}
		
		// If username and email id is valid, register the user.
		
		if(isRecordValid) {
			
			String insertUserSQl = "INSERT INTO user_master (user_name, email_id, first_name, last_name, "
					+ "joining_date, created_by, modified_by, created_date, modified_date, password) VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			// Get current time
			Calendar cal = Calendar.getInstance();
			
			// Convert current time into sql date.
			Timestamp currentTimeStamp = new Timestamp(cal.getTimeInMillis());
			
			jdbcTemplate.update(new PreparedStatementCreator(){

				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(insertUserSQl, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, user.getUserName());
					ps.setString(2, user.getEmailId());
					ps.setString(3, user.getFirstName());
					ps.setString(4, user.getLastName());
					ps.setTimestamp(5, currentTimeStamp);
					ps.setString(6, user.getUserName());
					ps.setString(7, user.getUserName());
					ps.setTimestamp(8, currentTimeStamp);
					ps.setTimestamp(9, currentTimeStamp);
					ps.setString(10, user.getPassword());
					
					return ps;
				}
			}, keyHolder);
			
			returnMap.put("success", "Y");
			returnMap.put("userObject", user);
			returnMap.put("message", "user registered successfully");
		}
		return returnMap;
	}

	private UserMaster getUserFromEmailId(String emailId) {
		String queryForUsername = "SELECT * FROM user_master where email_id = ?";
		List<UserMaster> userList = jdbcTemplate.query(queryForUsername,new Object[] {emailId}, new UserMasterMapper());
		if ( userList.isEmpty() ){
			return null;
		}
		return userList.get(0);
	}

	private UserMaster getUserFromUsername(String userName) {
		String queryForUsername = "SELECT * FROM user_master where user_name = ?";
		List<UserMaster> userList = jdbcTemplate.query(queryForUsername,new Object[] {userName}, new UserMasterMapper());
		if ( userList.isEmpty() ){
			return null;
		}
		return userList.get(0);
	}

}
