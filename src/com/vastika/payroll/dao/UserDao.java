package com.vastika.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.vastika.payroll.model.User;
import com.vastika.payroll.util.DbUtil;

public interface UserDao {
	void saveUserInfo(User user);
	List<User> getAllUserInfo();
	void deleteUser(int id);
	void updateUserInfo(User user);

	User getUserInfoById(int id);
	
}
