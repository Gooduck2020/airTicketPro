package com.java.factory;

import com.java.dao.FlightDao;
import com.java.dao.OrderDao;
import com.java.dao.PersonDao;
import com.java.dao.TicketDao;
import com.java.dao.UserDao;
import com.java.dao.impl.FlightDaoImpl;
import com.java.dao.impl.OrderDaoImpl;
import com.java.dao.impl.PersonDaoImpl;
import com.java.dao.impl.TicketDaoImpl;
import com.java.dao.impl.UserDaoImpl;

public class DaoFactory {
	public static UserDao createUserDao() {
		return new UserDaoImpl();
	}
	public static FlightDao createFlightDao() {
		return new FlightDaoImpl();
	}
	public static TicketDao createTicketDao() {
		return new TicketDaoImpl();
	}
	public static PersonDao createPersonDao() {
		return new PersonDaoImpl();
	}
	public static OrderDao createOrderDao() {
		return new OrderDaoImpl();
	}
}
