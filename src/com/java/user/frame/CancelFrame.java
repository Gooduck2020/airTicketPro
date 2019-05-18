package com.java.user.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.domian.Ticket;
import com.java.domian.User;
import com.java.factory.DaoFactory;

public class CancelFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable tickTable = new JTable();
	private JScrollPane pane = new JScrollPane();
	private List<Ticket> ticketList = null;
	public CancelFrame() {
		setTitle("退订机票");
		setLayout(new FlowLayout());
		setSize(450,400);
		setLocation(700, 280);
		JButton delBtn = new JButton("退订");
		delBtn.addActionListener(new DelListener());
		add(delBtn);
		reperTable();
		setVisible(true);
		setResizable(false);
	}
	
	class DelListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = tickTable.getSelectedRow();
			Integer id = ticketList.get(row).getTicket_id();
			String order_id = ticketList.get(row).getTicket_order().getOrder_id();
			if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(null, "确定退订吗?","提示",1)) {
				DaoFactory.createTicketDao().deleteTicket(id);
				reperTable();
				DaoFactory.createOrderDao().updateOrderTickNum(order_id);
			}
			
		}
	}
	
	public void reperTable() {
		ticketList = DaoFactory.createTicketDao().searchUserTicket(LoginFrame.loginUser);
		if(ticketList == null) {
			return;
		}
		Vector<String> titles = new Vector<String>();
		titles.add("订单号");
		titles.add("出行时间");
		titles.add("起止点");
		titles.add("订单状态");
		Vector<Vector<Object>> content = new Vector<Vector<Object>>();
		for (int i = 0; i < ticketList.size(); i++) {
			Vector<Object> v = new Vector<Object>();
			v.add(getOrder_id(i));
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
			String dates = sdf.format(ticketList.get(i).getTicket_flight().getFlight_time());
			v.add(dates);
			v.add(ticketList.get(i).getTicket_flight().getFlight_start()+"——>"+ticketList.get(i).getTicket_flight().getFlight_end());
			v.add(ticketList.get(i).getTicket_order().getOrder_state());
			content.add(v);
		}
		DefaultTableModel data = new DefaultTableModel(content, titles);
		pane.setViewportView(tickTable);
		pane.setPreferredSize(new Dimension(400, 300));
		pane.setVisible(true);
		tickTable.setModel(data);
		add(pane);

	}
	private String getOrder_id(int i) {
		String a = ticketList.get(i).getTicket_order().getOrder_id().substring(0, 4);
		String b = ticketList.get(i).getTicket_order().getOrder_id().substring(32, 36);
		String order = "订单号:"+a+"**"+b;
		return order;
	}
}
