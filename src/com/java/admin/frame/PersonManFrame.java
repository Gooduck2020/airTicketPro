package com.java.admin.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java.domian.User;
import com.java.factory.DaoFactory;

public class PersonManFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable personTable = new JTable();
	private JScrollPane pane = new JScrollPane();
	private JTextField user_name = null;
	private JTextField user_phone = null;
	
	public PersonManFrame() {
		setTitle("人员管理");
		
		setLayout(new FlowLayout());
		JLabel nameLabel = new JLabel("服务用户");
		JLabel phoneLabel = new JLabel("联系方式");
		user_name = new JTextField(8);
		user_phone = new JTextField(8);
		JButton delUser = new JButton("删除用户");
		delUser.addActionListener(new DelUserListener());
		JButton addUser = new JButton("添加服务人员");
		addUser.addActionListener(new AddUserListener());
		add(nameLabel);
		add(user_name);
		add(phoneLabel);
		add(user_phone);
		add(addUser);
		add(delUser);
		reperTable();
		setSize(450,500);
		setLocation(700, 280);
		setVisible(true);
		setResizable(false);
	}
	
	class AddUserListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			User user = new User();
			user.setUser_limit(2);
			user.setUser_name(user_name.getText());
			user.setUser_phone(user_phone.getText());
			user.setUser_pwd("1234");
			try {
				DaoFactory.createUserDao().addUser(user);
				reperTable();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "该用户已存在", "提示", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	class DelUserListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int row = personTable.getSelectedRow();
			String user_name = (String)personTable.getValueAt(row, 1);
			if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(null, "确定要删除吗","提示",1)) {
				DaoFactory.createUserDao().deleteUser(user_name);
				reperTable();
			}else {
				return;
			}
		}
	}
	
	public void reperTable() {
		List<User> userList = DaoFactory.createUserDao().getUserByLimit();
		Vector<String> titles = new Vector<String>();
		titles.add("序号");
		titles.add("用户名");
		titles.add("联系方式");
		titles.add("身份");
		Vector<Vector<Object>> content = new Vector<Vector<Object>>();
		for (int i = 0; i < userList.size(); i++) {
			Vector<Object> v = new Vector<Object>();
			v.add(i+1);
			v.add(userList.get(i).getUser_name());
			v.add(userList.get(i).getUser_phone());
			String indentity = getIdentity(userList.get(i).getUser_limit());
			v.add(indentity);
			content.add(v);
		}
		DefaultTableModel data = new DefaultTableModel(content, titles);
		pane.setViewportView(personTable);
		pane.setPreferredSize(new Dimension(400, 300));
		pane.setVisible(true);
		personTable.setModel(data);
		add(pane);

	}
	private String getIdentity(Integer user_limit) {
		String identity = "";
		switch(user_limit) {
		case 1: identity = "用户"; break;
		case 2: identity = "服务人员";break;
		}
		return identity;
	}
}
