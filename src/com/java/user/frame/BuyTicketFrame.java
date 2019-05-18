package com.java.user.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.domian.Flight;
import com.java.domian.Order;
import com.java.domian.Person;
import com.java.domian.Ticket;
import com.java.domian.User;
import com.java.factory.DaoFactory;

public class BuyTicketFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable personTable = new JTable();
	private JScrollPane pane = new JScrollPane();	
	private Flight flight = null;
	public BuyTicketFrame(Flight flight) {
		this.flight = flight;
		setLayout(new FlowLayout());
		setTitle("购买机票");
		JLabel jLabel1 = new JLabel(flight.getFlight_start()+"———— >"+flight.getFlight_end());
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd");
		
		String week = getWeek(flight.getFlight_time());
		JLabel weekLabel = new JLabel(week);
		JLabel dateLabel = new JLabel(sdf2.format(flight.getFlight_time()));
		JButton addPBtn = new JButton("添加乘车人");
		JButton submit = new JButton("提交订单");
		addPBtn.addActionListener(new AddPListener());
		submit.addActionListener(new SubmitListener());
		
		add(jLabel1);
		add(weekLabel);
		add(dateLabel);
		add(addPBtn);
		add(submit);
		reTable();
		getContentPane().setBackground(Color.white);
		setLocation(700, 280);
		setSize(500, 400);
		setVisible(true);
		setResizable(false);
		
		addWindowFocusListener(new WindowListener());
	}
	
	class SubmitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//提交订单
			commit();
		}

		private void commit() {
			Order order = new Order();
			order.setOrder_id(UUID.randomUUID().toString());
			order.setOrder_user(LoginFrame.loginUser);
			int size = DaoFactory.createPersonDao().searchPerson().size();
			order.setOrder_Ticknum(size);
			order.setOrder_state(0);
			if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(null, "确认提交订单","提示",JOptionPane.YES_NO_OPTION))
			{
				DaoFactory.createOrderDao().addOrder(order);
				for(Person person: DaoFactory.createPersonDao().searchPerson()) {
					Ticket ticket = new Ticket();
					ticket.setTicket_order(order);
					ticket.setTicket_person(person);
					ticket.setTicket_flight(flight);
					DaoFactory.createTicketDao().buyTicket(ticket);
					DaoFactory.createPersonDao().commtiPerson(person);
				}
			}else {
				return;
			}
			JOptionPane.showMessageDialog(null, "提交成功,等待出票","提示", JOptionPane.DEFAULT_OPTION);
			setVisible(false);
		}
	}
	
	class AddPListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddPFrame();
		}
		
	}
	
	class WindowListener implements WindowFocusListener{
		@Override
		public void windowGainedFocus(WindowEvent e) {
			reTable();
			
		}

		@Override
		public void windowLostFocus(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	private void reTable() {
		Vector<String> thead = new Vector<String>();
		thead.add("乘车人姓名");
		thead.add("乘车人身份证号");
		Vector<Vector<Object>> tbody = new Vector<Vector<Object>>();
		List<Person> list = DaoFactory.createPersonDao().searchPerson();
		
		for(int i = 0 ; i < list.size() ; i++ ) {
			Vector<Object> temp = new Vector<Object>();
			temp.add(list.get(i).getPerson_name());
			temp.add(list.get(i).getPerson_num());
			tbody.add(temp);
		}
		DefaultTableModel dtm = new DefaultTableModel(tbody,thead);
		personTable.setModel(dtm);
		pane.setViewportView(personTable);
		pane.setPreferredSize(new Dimension(300, 200));
		add(pane);
	}
	
	private String getWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("F");
		String str = sdf.format(date);
		switch(str) {
		case "1": str = "星期日";break;
		case "2": str = "星期一";break;
		case "3": str = "星期二";break;
		case "4": str = "星期三";break;
		case "5": str = "星期四";break;
		case "6": str = "星期五";break;
		case "7": str = "星期日";break;
		}
		return str;
	}
	
	
}
