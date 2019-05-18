package com.java.user.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.java.dao.UserDao;
import com.java.domian.User;
import com.java.factory.DaoFactory;


public class RegisterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField userTextField = new JTextField();
	JTextField pwdTextField = new JTextField();
	JTextField rePwdTextField = new JTextField();

	public RegisterFrame() {
		setTitle("注册");
		setLayout(new GridLayout(4, 1));
		JLabel userLabel = new JLabel("用户名");
		JLabel pwdLabel = new JLabel("密码");
		JLabel rePwdLabel = new JLabel("确认密码");
		JButton submit = new JButton("提交");
		RegisterBtListener registerBtListener = new RegisterBtListener();
		submit.addActionListener(registerBtListener);
		add(userLabel);
		add(userTextField);
		add(pwdLabel);
		add(pwdTextField);
		add(rePwdLabel);
		add(rePwdTextField);
		add(submit);

		setSize(300, 300);
		setVisible(true);

	}

	class RegisterBtListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String username = userTextField.getText();
			String password = pwdTextField.getText();
			String repassword = rePwdTextField.getText();
			if (username.equals("") || password.equals("") || repassword.equals("")) {
				JOptionPane.showMessageDialog(null, "填写不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
			} else if (!password.equals(repassword)) {
				JOptionPane.showMessageDialog(null, "两次密码不一致", "错误", JOptionPane.PLAIN_MESSAGE);
			} else {
				UserDao userDao = DaoFactory.createUserDao();
				try {
					userDao.addUser(new User());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "该用户已经存在", "错误", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}

	}

}