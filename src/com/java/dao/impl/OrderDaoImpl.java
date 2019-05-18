package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.OrderDao;
import com.java.domian.Order;
import com.java.domian.User;
import com.java.utils.JDBCUtil;

public class OrderDaoImpl implements OrderDao {
	@Override
	public void addOrder(Order order) {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into ordermap(order_id,order_user,order_Ticknum,order_state) values(?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, order.getOrder_id());
			pst.setInt(2, order.getOrder_user().getUser_id());
			pst.setInt(3, order.getOrder_Ticknum());
			pst.setInt(4, order.getOrder_state());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pst, conn);
		}
	}

	@Override
	public List<Order> searchUserOrder(User user) {
		return null;
	}

	@Override
	public ArrayList<Order> SelectAll() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<Order>();
		Connection conn = JDBCUtil.getConn();
		Statement stm = conn.createStatement();
		String sql = "select user.user_name as'user_name',ordermap.order_id as 'order_id',ordermap.order_Ticknum as 'order_Ticknum',ordermap.order_state as 'order_state'from "
				+ "ordermap,user where ordermap.order_user=user.user_id";
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			Order o = new Order();
			o.setOrder_id(rs.getString("order_id"));
			// o.getOrder_user().setUser_id(rs.getInt("order_user"));
			o.getOrder_user().setUser_name(rs.getString("user_name"));
			o.setOrder_Ticknum(rs.getInt("order_Ticknum"));
			o.setOrder_state(rs.getInt("order_state"));
			orders.add(o);
		}
		JDBCUtil.close(rs, stm, conn);
		return orders;
	}

	@Override
	public int update(Order updateOrder, String num) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psm = null;
		conn = JDBCUtil.getConn();
		String sql = "update ordermap set order_state=?  where order_id=?";
		psm = conn.prepareStatement(sql);
		psm.setInt(1, updateOrder.getOrder_state());
		psm.setString(2, num);
		psm.executeUpdate();
		JDBCUtil.close(null, psm, conn);

		return 0;
	}

	@Override
	public ArrayList<Order> Select() throws Exception {

		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<Order>();
		Connection conn = JDBCUtil.getConn();
		Statement stm = conn.createStatement();
		String sql = "select user.user_name as 'user_name',ordermap.order_id as 'order_id',ordermap.order_Ticknum as 'order_Ticknum',ordermap.order_state as 'order_state'"
				+ " from ordermap,user where ordermap.order_user=user.user_id and order_state=0";
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			Order o = new Order();
			o.setOrder_id(rs.getString("order_id"));
			o.getOrder_user().setUser_name(rs.getString("user_name"));
			o.setOrder_Ticknum(rs.getInt("order_Ticknum"));
			o.setOrder_state(rs.getInt("order_state"));
			orders.add(o);
		}
		JDBCUtil.close(rs, stm, conn);
		return orders;

	}

	@Override
	public void updateOrderTickNum(String order_id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psm = null;
		conn = JDBCUtil.getConn();
		String sql = "update ordermap set order_Ticknum=order_Ticknum-1 where order_id = ?";
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, order_id);
			psm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.close(null, psm, conn);

	}

}
