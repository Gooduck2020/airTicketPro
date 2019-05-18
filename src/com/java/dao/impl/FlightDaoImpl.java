package com.java.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.FlightDao;
import com.java.domian.Flight;
import com.java.utils.JDBCUtil;

public class FlightDaoImpl implements FlightDao {

	@Override
	public List<Flight> getSearchFlight(Flight flight) {
		Connection conn = JDBCUtil.getConn();
		ArrayList<Flight> flightlist = new ArrayList<Flight>();
		String sql = "select * from flight where flight_start=? and flight_end=? and DATE_FORMAT(flight_time,'%Y-%m-%d')=? order by flight_time";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, flight.getFlight_start());
			pst.setString(2, flight.getFlight_end());
			pst.setDate(3, new java.sql.Date(flight.getFlight_time().getTime()));
			rs = pst.executeQuery();
			while (rs.next()) {
				Flight f = new Flight();
				Integer flight_id = rs.getInt("flight_id");
				String flight_name = rs.getString("flight_name");
				String flight_start = rs.getString("flight_start");
				String flight_end = rs.getString("flight_end");
				Date date = rs.getDate("flight_time");
				Time time = rs.getTime("flight_time");
				String str = date + "\n" + time;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\nHH:mm");
				java.util.Date flight_time = sdf.parse(str);
				f.setFlight_id(flight_id);
				f.setFlight_name(flight_name);
				f.setFlight_start(flight_start);
				f.setFlight_end(flight_end);
				f.setFlight_time(flight_time);
				flightlist.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return flightlist;
	}

	@Override
	public int InsertFlight(Flight flight) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement psm = null;
		Connection conn = JDBCUtil.getConn();
		// Statement stm = conn.createStatement();
		String sql = "insert into flight  (flight_name,flight_start,flight_end,flight_time)values(?,?,?,?)";
		psm = conn.prepareStatement(sql);
		psm.setString(1, flight.getFlight_name());
		psm.setString(2, flight.getFlight_start());
		psm.setString(3, flight.getFlight_end());

//		psm.setDate(4, new java.sql.Date(flight.getFlight_time().getTime()));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatdate = sdf.format(new java.sql.Date(flight.getFlight_time().getTime()));
		psm.setString(4, formatdate);
		psm.executeUpdate();
		JDBCUtil.close(null, psm, conn);

		return 0;
	}

	@Override
	public ArrayList<Flight> SelectAll() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Flight> flights = new ArrayList<Flight>();
		Connection conn = JDBCUtil.getConn();
		Statement stm = conn.createStatement();
		String sql = "select*from flight ";
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			Flight f = new Flight();
			f.setFlight_id(rs.getInt("flight_id"));
			f.setFlight_name(rs.getString("flight_name"));
			f.setFlight_start(rs.getString("flight_start"));
			f.setFlight_end(rs.getString("flight_end"));
			Date date = rs.getDate("flight_time");
			Time time = rs.getTime("flight_time");
			String str = date + "\n" + time;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\nHH:mm");
			java.util.Date flight_time = sdf.parse(str);
			f.setFlight_time(flight_time);
			flights.add(f);
		}
		JDBCUtil.close(rs, stm, conn);

		return flights;
	}

	@Override
	public int deleteBynum(int num) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement psm = null;
		Connection conn = JDBCUtil.getConn();
		// Statement stm = conn.createStatement();
		String sql = "delete from flight where flight_id=?";
		psm = conn.prepareStatement(sql);
		psm.setInt(1, num);
		// int executeUpdate = stm.executeUpdate();
		psm.executeUpdate();
		JDBCUtil.close(null, psm, conn);

		return 0;
	}

	@Override
	public int update(Flight flight, int num) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psm = null;
		conn = JDBCUtil.getConn();
		String sql = "update flight set flight_name=?,flight_start=?,flight_end=?,flight_time=?  where flight_id=?";
		psm = conn.prepareStatement(sql);
		psm.setString(1, flight.getFlight_name());
		psm.setString(2, flight.getFlight_start());
		psm.setString(3, flight.getFlight_end());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(flight.getFlight_time().getTime());
		psm.setString(4, format);
		psm.setInt(5, num);
		psm.executeUpdate();
		JDBCUtil.close(null, psm, conn);

		return 0;
	}

}
