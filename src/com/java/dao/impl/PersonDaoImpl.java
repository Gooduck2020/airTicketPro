package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.PersonDao;
import com.java.domian.Person;
import com.java.domian.User;
import com.java.factory.DaoFactory;
import com.java.user.frame.LoginFrame;
import com.java.utils.JDBCUtil;

public class PersonDaoImpl implements PersonDao {
	@Override
	public List<Person> searchPerson() {
		ArrayList<Person> arrayList = new ArrayList<Person>();
		Connection conn = JDBCUtil.getConn();
		String sql = "select * from person where person_user = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			Integer user_id = LoginFrame.loginUser.getUser_id();
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Person person = new Person();
				person.setPerson_id(rs.getInt("person_id"));
				User user = DaoFactory.createUserDao().getUserById(rs.getInt("person_user"));
				person.setPerson_user(user);
				person.setPerson_name(rs.getString("person_name"));
				person.setPerson_num(rs.getString("person_num"));
				arrayList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return arrayList;
	}

	@Override
	public void addPerson(Person person) {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into person(person_user,person_name,person_num) values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, person.getPerson_user().getUser_id());
			pst.setString(2, person.getPerson_name());
			pst.setString(3, person.getPerson_num());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pst, conn);
		}
	}

	@Override
	public void commtiPerson(Person person) {
		Connection conn = JDBCUtil.getConn();
		String sql = "update person set person_user=null where person_user=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, person.getPerson_user().getUser_id());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pst, conn);
		}
		
	}

}
