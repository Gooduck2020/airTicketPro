package com.java.user.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.java.domian.Person;
import com.java.factory.DaoFactory;

public class AddPFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField numText = null;
	private JTextField nameText = null;
	public AddPFrame() {
		setLayout(null);
		setTitle("添加乘车人");
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setBounds(60, 25, 40, 30);
		nameText = new JTextField(10);
		nameText.setBounds(105, 25, 150, 30);
		JLabel numLabel = new JLabel("身份证号");
		numLabel.setBounds(35, 65, 60, 30);
		numText = new JTextField(10);
		numText.setBounds(105, 65, 150, 30);
		JButton submit = new JButton("确定");
		submit.setBounds(45, 120, 210, 30);
		submit.addActionListener(new SubmitListener());
		
		add(nameLabel);
		add(nameText);
		add(numLabel);
		add(numText);
		add(submit);
		getContentPane().setBackground(Color.white);
		setLocation(800, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
		setResizable(false);
	}
	
	class SubmitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Person person = new Person();
			String person_name = nameText.getText();
			String person_num = numText.getText();
			person.setPerson_user(LoginFrame.loginUser);
			person.setPerson_name(person_name);
			person.setPerson_num(person_num);
			DaoFactory.createPersonDao().addPerson(person);
			setVisible(false);
		}
		
	}
	
}
