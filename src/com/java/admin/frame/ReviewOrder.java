package com.java.admin.frame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.java.domian.Order;
import com.java.factory.DaoFactory;

public class ReviewOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable OrderTable = new JTable();
	JScrollPane scrollPane = new JScrollPane();
	List<Order> list = new ArrayList<Order>();

	public ReviewOrder() {
		try {
			list=DaoFactory.createOrderDao().Select();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setLayout(null);
		JButton confirm = new JButton("确定");
		ConfirmListener confirmListener = new ConfirmListener();
		confirm.addActionListener(confirmListener);
		JButton cancel = new JButton("取消");
		CancelListener cancelListener = new CancelListener();
		cancel.addActionListener(cancelListener);
		scrollPane.setBounds(40, 20, 400, 300);
		confirm.setBounds(150, 400, 60, 30);
		cancel.setBounds(250, 400, 60, 30);

		
		add(confirm);
		add(cancel);
		RefreshReviewOrder(list);
		setLocation(400, 100);
		setSize(500, 500);
		setVisible(true);

	}

	public void RefreshReviewOrder(List<Order> list) {
		Vector<String> titles = new Vector<String>();
		titles.add("订单号");
		titles.add("订单人");
		titles.add("购票数");
		titles.add("订单状态");
		Vector<Vector<Object>> content = new Vector<Vector<Object>>();
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<Object>();
			v.add(list.get(i).getOrder_id());
			v.add(list.get(i).getOrder_user().getUser_name());
			v.add(list.get(i).getOrder_Ticknum());
			
			if(list.get(i).getOrder_state()==0) {
				v.add("待审核");
			}else if(list.get(i).getOrder_state()==-1) {
				v.add("出票失败");
			}else if(list.get(i).getOrder_state()==1) {
				v.add("出票成功");
			}
			content.add(v);
		}
		DefaultTableModel data = new DefaultTableModel(content, titles);
		scrollPane.setViewportView(OrderTable);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		scrollPane.setVisible(true);
		OrderTable.setModel(data);
		add(scrollPane);

	}

	class ConfirmListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			
			int selectedRow = OrderTable.getSelectedRow();
			if (list.get(selectedRow).getOrder_state()==0) {
				list.get(selectedRow).setOrder_state(1);
				try {
					DaoFactory.createOrderDao().update(list.get(selectedRow), list.get(selectedRow).getOrder_id());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
					try {
						list=DaoFactory.createOrderDao().Select();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
				RefreshReviewOrder(list);
			} else {
				return;
			}

		}
	}

	class CancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = OrderTable.getSelectedRow();
			if (list.get(selectedRow).getOrder_state()==0) {
				list.get(selectedRow).setOrder_state(-1);
				try {
					DaoFactory.createOrderDao().update(list.get(selectedRow), list.get(selectedRow).getOrder_id());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					list=DaoFactory.createOrderDao().Select();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				RefreshReviewOrder(list);
			}else {
				return;
			}
		}
	}
}
