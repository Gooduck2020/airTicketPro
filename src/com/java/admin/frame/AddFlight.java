package com.java.admin.frame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java.domian.Flight;
import com.java.factory.DaoFactory;

public class AddFlight extends JFrame {

	/**
	 * 
	 **/
	private static final long serialVersionUID = 1L;
	JTable FlightTable = new JTable();
	JScrollPane scrollPane = new JScrollPane();
	ArrayList<Flight> list = new ArrayList<Flight>();
	JTextField PlaneName = new JTextField();
	JTextField Begin = new JTextField();
	JTextField End = new JTextField();
	JTextField FlightTime = new JTextField();
	JLabel jPlaneName = new JLabel("航班名:");
	JLabel jBegin = new JLabel("航班起点:");
	JLabel jEnd = new JLabel("航班终点:");
	JLabel jFlightTime = new JLabel("航班时间:");
	JButton confirm = new JButton("确定");
	JButton delete = new JButton("删除");
	JButton update = new JButton("跟新");

	public AddFlight() {
		try {
			list = DaoFactory.createFlightDao().SelectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfirmListener confirmListener = new ConfirmListener();
		confirm.addActionListener(confirmListener);
		DeleteListener deleteListener = new DeleteListener();
		delete.addActionListener(deleteListener);
		UpdateListener updateListener = new UpdateListener();
		update.addActionListener(updateListener);
		setLayout(null);
//		list.add(new Flight("马航", "南京", "上海", "8am"));
		scrollPane.setBounds(40, 20, 450, 300);

		jPlaneName.setBounds(40, 330, 70, 25);
		PlaneName.setBounds(125, 330, 100, 25);

		jBegin.setBounds(255, 330, 70, 25);
		Begin.setBounds(335, 330, 100, 25);

		jEnd.setBounds(40, 370, 70, 25);
		End.setBounds(125, 370, 100, 25);

		jFlightTime.setBounds(255, 370, 70, 25);
		FlightTime.setBounds(335, 370, 100, 25);

		confirm.setBounds(70, 410, 90, 30);
		delete.setBounds(200, 410, 90, 30);
		update.setBounds(320, 410, 90, 30);
		add(jPlaneName);
		add(jBegin);
		add(jEnd);
		add(jFlightTime);
		add(PlaneName);
		add(Begin);
		add(End);
		add(FlightTime);
		add(confirm);
		add(delete);
		add(update);
		reAddFlight(list);
		setLocationRelativeTo(null);
		setSize(550, 500);
		setVisible(true);
	}

	public void reAddFlight(ArrayList<Flight> list) {
		Vector<String> titles = new Vector<String>();
//		titles.add("航班号");
		titles.add("航班名");
		titles.add("航班起点");
		titles.add("航班终点");
		titles.add("航班时间");
		Vector<Vector<Object>> content = new Vector<Vector<Object>>();
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<Object>();
//			v.add(list.get(i).getFlight_id());
			v.add(list.get(i).getFlight_name());
			v.add(list.get(i).getFlight_start());
			v.add(list.get(i).getFlight_end());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String format = sdf.format(list.get(i).getFlight_time());
			v.add(format);
			content.add(v);
		}
		DefaultTableModel data = new DefaultTableModel(content, titles);
		scrollPane.setViewportView(FlightTable);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		scrollPane.setVisible(true);
		FlightTable.setModel(data);
		add(scrollPane);

	}

	class ConfirmListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int isright = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this content?", "提示", JOptionPane.YES_NO_OPTION);
			if (isright == JOptionPane.YES_OPTION) {
				int num = (list.get(list.size() - 1)).getFlight_id() + 1;
				String tPlaneName = PlaneName.getText();
				String tBegin = Begin.getText();
				String tEnd = End.getText();
				String tFlightTime = FlightTime.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date parse = null;
				try {
					parse = sdf.parse(tFlightTime);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				Flight flight = new Flight(num, tPlaneName, tBegin, tEnd, parse);
				list.add(flight);
				try {
					DaoFactory.createFlightDao().InsertFlight(flight);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PlaneName.setText("");
				Begin.setText("");
				End.setText("");
				FlightTime.setText("");
				reAddFlight(list);

			}else {
				PlaneName.setText("");
				Begin.setText("");
				End.setText("");
				FlightTime.setText("");
				reAddFlight(list);
			}
			
			
		}
	}

	class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int isright = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this content?", "提示", JOptionPane.YES_NO_OPTION);
			if (isright == JOptionPane.YES_OPTION) {
//				int num;
//				 num = Integer.parseInt((FlightTable.getValueAt(FlightTable.getSelectedRow(),0 )).toString()) ;
				int num;

				num = list.get(FlightTable.getSelectedRow()).getFlight_id();
				System.out.println(num);
				System.out.println(FlightTable.getSelectedRow());
				try {
					DaoFactory.createFlightDao().deleteBynum(num);
					list = DaoFactory.createFlightDao().SelectAll();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				reAddFlight(list);
			}else {
				return;
			}
			

		}
	}

	class UpdateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int isright = JOptionPane.showConfirmDialog(null, "Are you sure you want to change this?", "提示", JOptionPane.YES_NO_OPTION);
			if (isright == JOptionPane.YES_OPTION) {
				// TODO Auto-generated method stub
				int num = FlightTable.getSelectedRow();
				Flight flight = new Flight();
				String tPlaneName = PlaneName.getText();
				String tBegin = Begin.getText();
				String tEnd = End.getText();
				String tFlightTime = FlightTime.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date parse = null;
				try {
					parse = sdf.parse(tFlightTime);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				list.get(FlightTable.getSelectedRow()).setFlight_name(tPlaneName);
				list.get(FlightTable.getSelectedRow()).setFlight_start(tBegin);
				list.get(FlightTable.getSelectedRow()).setFlight_end(tEnd);
				list.get(FlightTable.getSelectedRow()).setFlight_time(parse);
//				System.out.println(list.get(num));
//				System.out.println(num);
//				System.out.println(list.get(num).getFlight_id());
				try {
					DaoFactory.createFlightDao().update(list.get(num), list.get(num).getFlight_id());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PlaneName.setText("");
				Begin.setText("");
				End.setText("");
				FlightTime.setText("");
				reAddFlight(list);

			}else {
				PlaneName.setText("");
				Begin.setText("");
				End.setText("");
				FlightTime.setText("");
				reAddFlight(list);
			}
		}

	}

}
