package com.java.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.TicketDao;
import com.java.domian.Ticket;
import com.java.domian.User;
import com.java.utils.JDBCUtil;

public class TicketDaoImpl implements TicketDao{
	@Override
	public void buyTicket(Ticket ticket) {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into ticket(ticket_flight,ticket_order,ticket_person) values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ticket.getTicket_flight().getFlight_id());
			pst.setString(2, ticket.getTicket_order().getOrder_id());
			pst.setInt(3, ticket.getTicket_person().getPerson_id());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pst, conn);
		}
		
	}

	@Override
	public List<Ticket> searchUserTicket(User user) {
		Connection conn = JDBCUtil.getConn();
		List<Ticket> list = new ArrayList<Ticket>();
		String sql = "select ordermap.order_id as 'order',flight.flight_name as 'fname',flight.flight_start as 'start',flight.flight_end as 'end',flight.flight_time as 'time',person.person_name as 'person',ordermap.order_state as 'state',ticket.ticket_id as 'ticket_id'"
				+ " from ordermap,ticket,flight,person where"
				+ " ordermap.order_id=ticket.ticket_order and"
				+ " ticket_flight=flight_id and"
				+ " person_id=ticket_person and order_user = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getUser_id());
			rs = pst.executeQuery();
			while(rs.next()){
				Ticket ticket = new Ticket();
				String order = rs.getString("order");
				String fname = rs.getString("fname");
				String start = rs.getString("start");
				String end = rs.getString("end");
				Date date = rs.getDate("time");
				Time time = rs.getTime("time");
				Integer ticket_id = rs.getInt("ticket_id");
				String dates = date+"\n"+time;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\nhh:mm");
				java.util.Date flight_time = sdf.parse(dates);
				String person = rs.getString("person");
				Integer state = rs.getInt("state");
				ticket.getTicket_order().setOrder_id(order);
				ticket.getTicket_flight().setFlight_name(fname);
				ticket.getTicket_person().setPerson_name(person);
				ticket.getTicket_flight().setFlight_start(start);
				ticket.getTicket_flight().setFlight_end(end);
				ticket.getTicket_flight().setFlight_time(flight_time);
				ticket.getTicket_order().setOrder_state(state);
				ticket.setTicket_id(ticket_id);
				list.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return list;
	}

	@Override
	public void deleteTicket(Integer id) {
		Connection conn = JDBCUtil.getConn();
		String sql = "delete from ticket where ticket_id=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pst, conn);
		}
		
		
	}

}
