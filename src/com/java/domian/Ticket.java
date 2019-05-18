package com.java.domian;

public class Ticket {
	private Integer ticket_id;
	private Flight ticket_flight = new Flight();
	private Order ticket_order = new Order();
	private Person ticket_person = new Person();
	
	public Ticket() {
		
	}

	public Ticket(Integer ticket_id, Flight ticket_flight, Order ticket_order, Person ticket_person) {
		this.ticket_id = ticket_id;
		this.ticket_flight = ticket_flight;
		this.ticket_order = ticket_order;
		this.ticket_person = ticket_person;
	}

	public Integer getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}

	public Flight getTicket_flight() {
		return ticket_flight;
	}

	public void setTicket_flight(Flight ticket_flight) {
		this.ticket_flight = ticket_flight;
	}

	public Order getTicket_order() {
		return ticket_order;
	}

	public void setTicket_order(Order ticket_order) {
		this.ticket_order = ticket_order;
	}

	public Person getTicket_person() {
		return ticket_person;
	}

	public void setTicket_person(Person ticket_person) {
		this.ticket_person = ticket_person;
	}
	/*			ticket.getTicket_order().setOrder_id(order);
				ticket.getTicket_flight().setFlight_name(fname);
				ticket.getTicket_person().setPerson_name(person);
				ticket.getTicket_flight().setFlight_start(start);
				ticket.getTicket_flight().setFlight_end(end);
				ticket.getTicket_flight().setFlight_time(flight_time);
	*/
	
	@Override
	public String toString() {
		return "["+getTicket_order().getOrder_id()+","+getTicket_flight().getFlight_name()+","
				+getTicket_flight().getFlight_start()+","+getTicket_flight().getFlight_end()+","
				+getTicket_person().getPerson_name()+ ","+getTicket_flight().getFlight_time()+"]";
	}
	
}
