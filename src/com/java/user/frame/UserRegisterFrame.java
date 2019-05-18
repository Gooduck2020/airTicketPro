package com.java.user.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.dao.UserDao;
import com.java.domian.User;
import com.java.factory.DaoFactory;
import com.java.thread.ImgThread;


public class UserRegisterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField userText = new JTextField();
	JTextField pwdText = new JPasswordField();
	JTextField rePwdText = new JTextField();
	JTextField phoneText = new JTextField();
	public UserRegisterFrame() {
		setTitle("注册");
		setLayout(null);
		JLabel lab = new JLabel();
		Thread t = new Thread(new ImgThread(lab));
		t.start();
		lab.setBounds(0 , 0, 500, 150);
		add(lab);
		JLabel userLabel = new JLabel("用户名");
		userLabel.setBounds(112, 180, 40, 30);
		userText.setBounds(192,180,170,30);
		JLabel pwdLabel = new JLabel("密码");
		pwdLabel.setBounds(125, 225, 40, 30);
		pwdText.setBounds(192,225,170,30);
		JLabel rePwdLabel = new JLabel("确认密码");
		rePwdLabel.setBounds(100, 270, 60, 30);
		rePwdText.setBounds(192,270,170,30);
		JLabel phoneLabel = new JLabel("联系电话");
		phoneLabel.setBounds(100, 315, 60, 30);
		phoneText.setBounds(192,315,170,30);
		JButton submit = new JButton("注册新用户");
		submit.setBounds(130, 380, 230, 40);
		submit.setBackground(new Color(50, 133, 255));
		submit.setFont(new Font("幼圆", Font.BOLD, 15));
		submit.setForeground(Color.WHITE);
		RegisterBtListener registerBtListener = new RegisterBtListener();
		submit.addActionListener(registerBtListener);
		add(userLabel);
		add(userText);
		add(pwdLabel);
		add(pwdText);
		add(rePwdLabel);
		add(rePwdText);
		add(phoneLabel);
		add(phoneText);
		add(submit);
		getContentPane().setBackground(Color.white);
		setLocation(700, 220);
		setSize(500	, 500);
		setVisible(true);
		setResizable(false);

	}

	class RegisterBtListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String username = userText.getText();
			String password = pwdText.getText();
			String repassword = rePwdText.getText();
			String phone = phoneText.getText();
			if (username.equals("") || password.equals("") || repassword.equals("")||phone.equals("")) {
				JOptionPane.showMessageDialog(null, "填写不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
			} else if (!password.equals(repassword)) {
				JOptionPane.showMessageDialog(null, "两次密码不一致", "错误", JOptionPane.PLAIN_MESSAGE);
			} else {
				User user = new User();
				user.setUser_name(username);
				user.setUser_pwd(password);
				user.setUser_phone(phone);
				user.setUser_limit(1);
				UserDao userDao = DaoFactory.createUserDao();
				try {
					userDao.addUser(user);
					JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "该用户已被注册", "错误", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}

	}

}