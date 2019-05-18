package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.UserDao;
import com.java.domian.User;
import com.java.utils.JDBCUtil;


public class UserDaoImpl implements UserDao{

	@Override
	public User LoginUser(String username,String password) {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs= null;
		String sql = "select * from user where user_name = ? and user_pwd = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_limit(rs.getInt("user_limit"));
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return null;
	}

	@Override
	public void addUser(User user) throws SQLException {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into user(user_name,user_pwd,user_phone,user_limit) values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, user.getUser_name());
		pst.setString(2, user.getUser_pwd());
		pst.setString(3, user.getUser_phone());
		pst.setInt(4, user.getUser_limit());
		pst.executeUpdate();
		JDBCUtil.close(null, pst, conn);
	}

	@Override
	public User getUserById(Integer user_id) {
		Connection conn = JDBCUtil.getConn();
		PreparedStatement pst = null;
		ResultSet rs= null;
		String sql = "select * from user where user_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_limit(rs.getInt("user_limit"));
				return user;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return null;
	}

	@Override
	public List<User> getUserByLimit() {
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = JDBCUtil.getConn();
		String sql = "select user_name,user_phone,user_limit from user where user_limit!=3 ORDER BY user_limit";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUser_name(rs.getString("user_name"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_limit(rs.getInt("user_limit"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return userList;
	}

	
	//删除用户
	@Override
	public void deleteUser(String user_name) {
		Connection conn = JDBCUtil.getConn();
		String sql = "delete from user where user_name=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_name);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pst, conn);
		}
	}
}
