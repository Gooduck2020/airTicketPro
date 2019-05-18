package com.java.dao;

import java.util.List;

import com.java.domian.Ticket;
import com.java.domian.User;

public interface TicketDao {

	public void buyTicket(Ticket ticket);

	public List<Ticket> searchUserTicket(User user);

	public void deleteTicket(Integer id);

}
