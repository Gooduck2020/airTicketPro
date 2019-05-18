package com.java.user.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.java.domian.Ticket;
import com.java.factory.DaoFactory;

public class UserOrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JScrollPane pane = new JScrollPane();
	List<Ticket> userTicket = null;
	public UserOrderFrame() {
		setLayout(new FlowLayout());
		
		setTitle("我的订单信息");
		userTicket = DaoFactory.createTicketDao().searchUserTicket(LoginFrame.loginUser);
		JPanel allP = new JPanel();
		allP.setLayout(new GridLayout(5, 2, 5, 10));
		JPanel[] panels = new JPanel[10];
		for( int i = 0 ; i < 10 ; i++ ) {
			panels[i] = new JPanel();
			panels[i].setBackground(Color.WHITE);
			panels[i].setLayout(null);
			allP.add(panels[i]);
		}
		for( int i = 0 ; i < userTicket.size() ; i++ ) {
			if(userTicket.get(i)!=null) {
				JLabel orderLabel = getOrder_id(i);
				JLabel stateLabel = getState(i);
				JLabel infoLabel = getInfo(i);
				JLabel perLabel = getPer(i);
				panels[i].add(orderLabel);
				panels[i].add(stateLabel);
				panels[i].add(infoLabel);
				panels[i].add(perLabel);
			}
		}
		pane.setViewportView(allP);
		pane.setPreferredSize(new Dimension(700, 500));
		add(pane);
		setLocation(670, 260);
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
	}
	
	private JLabel getPer(int i) {
		String person_name = userTicket.get(i).getTicket_person().getPerson_name();
		JLabel perLabel = new JLabel("乘坐人:"+person_name);
		perLabel.setBounds(245, 55, 100, 30);
		return perLabel;
	}

	private JLabel getInfo(int i) {
		String flight_start = userTicket.get(i).getTicket_flight().getFlight_start();
		String flight_end = userTicket.get(i).getTicket_flight().getFlight_end();
		Date flight_time = userTicket.get(i).getTicket_flight().getFlight_time();
		String flight_name = userTicket.get(i).getTicket_flight().getFlight_name();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String flight_dates = sdf.format(flight_time);
		JLabel infoLabel = new JLabel(flight_start+"——"+flight_end+"    "+flight_name+"    出行时间:"+flight_dates);
		infoLabel.setBounds(10, 25, 310, 30);
		return infoLabel;
	}


	private JLabel getOrder_id(int i) {
		String a = userTicket.get(i).getTicket_order().getOrder_id().substring(0, 4);
		String b = userTicket.get(i).getTicket_order().getOrder_id().substring(32, 36);
		JLabel orderLabel = new JLabel("订单号:"+a+"**"+b);
		orderLabel.setBounds(10,0,150,20);
		return orderLabel;
	}
	
	private JLabel getState(Integer i) {
		Integer order_state = userTicket.get(i).getTicket_order().getOrder_state();
		JLabel stateLabel = new JLabel();
		String stateStr = "";
		switch(order_state) {
		case 0: stateStr = "待审核"; stateLabel.setForeground(Color.GRAY);  break;
		case 1:	stateStr = "出票成功"; stateLabel.setForeground(Color.GREEN); break;
		case -1:stateStr = "出票失败"; stateLabel.setForeground(Color.RED);break;
		}
		stateLabel.setText(stateStr);
		stateLabel.setBounds(264, 0, 70, 20);
		return stateLabel;
	}
}
