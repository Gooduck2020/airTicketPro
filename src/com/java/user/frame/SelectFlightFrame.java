package com.java.user.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java.domian.Flight;
import com.java.factory.DaoFactory;

public class SelectFlightFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable flightTable = new JTable();
	private JScrollPane jPane = new JScrollPane();
	private JTextField yyText = null;
	private JTextField mmText = null;
	private JTextField ddText = null;
	private Flight flight = null;
	private int[] dates = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
	public SelectFlightFrame(Flight flight) {
		this.flight = flight;
		setLayout(null);
		selectFlight(flight);
		JLabel timeLabel = new JLabel("出行时间");
		yyText = new JTextField((1900+flight.getFlight_time().getYear())+"");
		JLabel yylabel = new JLabel("年");
		mmText = new JTextField((1+flight.getFlight_time().getMonth())+"");
		JLabel mmlabel = new JLabel("月");
		ddText = new JTextField(flight.getFlight_time().getDate()+"");
		JLabel ddlabel = new JLabel("日");
		timeLabel.setBounds(160, 30, 60, 20);
		
		JButton lastBtn = new JButton("上一天");
		JButton nextBtn = new JButton("下一天");
		lastBtn.setBounds(60, 30, 80, 20);
		nextBtn.setBounds(435, 30, 80, 20);
		lastBtn.addActionListener(new LastDay());
		nextBtn.addActionListener(new NextDay());
		add(lastBtn);
		add(nextBtn);
		
		yyText.setBounds(220, 30, 40, 20);
		yyText.setEnabled(false);
		mmText.setBounds(295, 30, 30, 20);
		mmText.setEnabled(false);
		ddText.setBounds(360, 30, 30, 20);
		ddText.setEnabled(false);
		yylabel.setBounds(265, 25, 20, 30);
		mmlabel.setBounds(330, 25, 20, 30);
		ddlabel.setBounds(395, 25, 20, 30);
		JButton reSearch = new JButton("查询");
		JButton buyTicket = new JButton("购票");
		reSearch.setBounds(30, 100, 70, 50);
		buyTicket.setBounds(30, 190, 70, 50);
		add(reSearch);
		add(buyTicket);
		reSearch.addActionListener(new ResearchListener());
		buyTicket.addActionListener(new BuyTicket());;
		add(timeLabel);
		add(yyText);
		add(yylabel);
		add(mmText);
		add(mmlabel);
		add(ddText);
		add(ddlabel);
		setLocation(670, 260);
		setSize(600, 500);
		setVisible(true);
	}
	
	class NextDay implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int day = Integer.parseInt(ddText.getText());
			int month = Integer.parseInt(mmText.getText());
			if(day < dates[month-1]) {
				ddText.setText((day+1)+"");
			}else {
				ddText.setText(1+"");
				mmText.setText((month+1)+"");
			}
			
		}
		
	}
	class LastDay implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int day = Integer.parseInt(ddText.getText());
			int month = Integer.parseInt(mmText.getText());
			if(day > 1) {
				ddText.setText((day-1)+"");
			}else {
				ddText.setText(dates[month-2]+"");
				mmText.setText((month-1)+"");
			}
		}
	}
	
	class BuyTicket implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = flightTable.getSelectedRow();
			if(row == -1) {
				return;
			}
			try {
				Flight tflight = DaoFactory.createFlightDao().getSearchFlight(flight).get(row);
				new BuyTicketFrame(tflight);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class ResearchListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String yy = yyText.getText();
			String mm = mmText.getText();
			String dd = ddText.getText();
			String datestr = "";
			datestr = yy+"-"+mm+"-"+dd;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new Date();
			try {
				date1 = sdf.parse(datestr);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			flight.setFlight_time(date1);
			selectFlight(flight);
		}
	}
	
	
	private void selectFlight(Flight flight) {
		Vector<String> thead = new Vector<String>();
		thead.add("航班编号");
		thead.add("航班起止点");
		thead.add("出发时间");
		Vector<Vector<Object>> tbody = new Vector<Vector<Object>>();
		List<Flight> list = null;
		try {
			list = DaoFactory.createFlightDao().getSearchFlight(flight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0 ; i < list.size() ; i++ ) {
			Vector<Object> temp = new Vector<Object>();
			temp.add(list.get(i).getFlight_name());
			temp.add(list.get(i).getFlight_start()+"-->"+list.get(i).getFlight_end());
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String format = sdf.format(list.get(i).getFlight_time());
			temp.add(format);
			tbody.add(temp);
		}
		DefaultTableModel dtm = new DefaultTableModel(tbody,thead);
		flightTable.setModel(dtm);
		flightTable.setBounds(130, 100, 400, 300);
		jPane.setBounds(130, 100, 400, 300);
		jPane.setViewportView(flightTable);
		jPane.setPreferredSize(new Dimension(400, 300));
		add(jPane);
	}
	
}
