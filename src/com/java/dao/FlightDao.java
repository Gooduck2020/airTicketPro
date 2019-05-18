package com.java.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.domian.Flight;

public interface FlightDao {

	public List<Flight> getSearchFlight(Flight flight) throws Exception;
	public int InsertFlight(Flight flight) throws Exception;
	public ArrayList<Flight> SelectAll() throws Exception;
	public int deleteBynum(int num)throws Exception;
	public int update(Flight updateFruit,int num)throws Exception;
}
