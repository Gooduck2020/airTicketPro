package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.domian.User;

public interface UserDao {

	public User LoginUser(String username, String password);
	public void addUser(User user) throws SQLException;
	public User getUserById(Integer user_id);
	public List<User> getUserByLimit();
	public void deleteUser(String user_name);

}
