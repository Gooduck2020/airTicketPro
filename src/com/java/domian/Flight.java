package com.java.domian;

import java.util.Date;

public class Flight {
	private Integer flight_id;
	private String flight_name;
	private String flight_start;
	private String flight_end;
	private Date flight_time;
	
	public Flight() {
		
	}

	public Flight(Integer flight_id, String flight_name, String flight_start, String flight_end, Date flight_time) {
		this.flight_id = flight_id;
		this.flight_name = flight_name;
		this.flight_start = flight_start;
		this.flight_end = flight_end;
		this.flight_time = flight_time;
	}

	public Integer getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(Integer flight_id) {
		this.flight_id = flight_id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getFlight_start() {
		return flight_start;
	}

	public void setFlight_start(String flight_start) {
		this.flight_start = flight_start;
	}

	public String getFlight_end() {
		return flight_end;
	}

	public void setFlight_end(String flight_end) {
		this.flight_end = flight_end;
	}

	public Date getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(Date flight_time) {
		this.flight_time = flight_time;
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flight_name=" + flight_name + ", flight_start=" + flight_start
				+ ", flight_end=" + flight_end + ", flight_time=" + flight_time + "]";
	}
	
}
