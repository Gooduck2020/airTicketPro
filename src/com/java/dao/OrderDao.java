package com.java.dao;

import java.util.List;

import com.java.domian.Order;
import com.java.domian.User;

public interface OrderDao {

	public void addOrder(Order order);
	public List<Order> searchUserOrder(User user);
	public List<Order> Select() throws Exception;
	public List<Order> SelectAll() throws Exception;
	public int update(Order updateOrder,String num)throws Exception;
	public void updateOrderTickNum(String order_id);
}
