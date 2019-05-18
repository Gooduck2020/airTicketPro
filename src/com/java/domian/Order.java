package com.java.domian;

public class Order {
	private String order_id;
	private User order_user = new User();
	private Integer order_state;
	private Integer order_Ticknum;
	public Order() {
		
	}

	public Order(String order_id, User order_user,Integer order_Ticknum, Integer order_state) {
		super();
		this.order_id = order_id;
		this.order_user = order_user;
		this.order_state = order_state;
		this.order_Ticknum=order_Ticknum;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public User getOrder_user() {
		return order_user;
	}

	public void setOrder_user(User order_user) {
		this.order_user = order_user;
	}

	public Integer getOrder_state() {
		return order_state;
	}

	public void setOrder_state(Integer order_state) {
		this.order_state = order_state;
	}

	public Integer getOrder_Ticknum() {
		return order_Ticknum;
	}

	public void setOrder_Ticknum(Integer order_Ticknum) {
		this.order_Ticknum = order_Ticknum;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_user=" + order_user + ", order_state=" + order_state
				+ ", order_Ticknum=" + order_Ticknum + "]";
	}

	
	
}
