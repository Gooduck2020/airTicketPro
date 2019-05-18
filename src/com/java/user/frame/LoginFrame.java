package com.java.user.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.admin.frame.AdminPage;
import com.java.admin.frame.PersonManFrame;
import com.java.dao.UserDao;
import com.java.domian.User;
import com.java.factory.DaoFactory;

public class LoginFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public static User loginUser = null;
	
	UserDao userDao = DaoFactory.createUserDao();
	JTextField usernameText = null;
	JPasswordField passwordText = null;
	public LoginFrame() {
		setTitle("登录");
		setLayout(new GridLayout(3,1));
		JPanel header = new JPanel();
		JPanel mainer = new JPanel();
		JPanel footer = new JPanel();
		mainer.setLayout(null);
		footer.setLayout(null);
		JLabel sysname = new JLabel("机票购买系统");
		sysname.setHorizontalAlignment((int)CENTER_ALIGNMENT);
		sysname.setFont(new Font("",Font.PLAIN,40));
		JLabel userLabel = new JLabel("用户名");
		userLabel.setBounds(120,20,50,20);
		usernameText = new JTextField(16);
		usernameText.setBounds(180, 15, 200, 30);
		JLabel pwdLabel = new JLabel("密码");
		pwdLabel.setBounds(130,70,50,20);
		passwordText = new JPasswordField(16);
		passwordText.setBounds(180, 65, 200, 30);
		JButton loginBtn = new JButton("登录");
		LoginListener loginListener = new LoginListener();
		loginBtn.addActionListener(loginListener);
		JButton registerBtn = new JButton("注册");
		registerBtn.addActionListener(new RegisterListener());
		header.setLayout(new BorderLayout());
		header.add(sysname,BorderLayout.CENTER);
		mainer.add(userLabel);
		mainer.add(usernameText);
		mainer.add(pwdLabel);
		mainer.add(passwordText);
		loginBtn.setBounds(120, 30, 100, 40);
		registerBtn.setBounds(280, 30, 100, 40);
		//格子按钮
		footer.add(loginBtn);
		footer.add(registerBtn);
		header.setBackground(Color.white);
		mainer.setBackground(Color.white);
		footer.setBackground(Color.white);
		add(header);
		add(mainer);
		add(footer);
		setLocation(700, 280);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
		setResizable(false);
	}
	
	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String username = usernameText.getText();
			String password = String.valueOf(passwordText.getPassword());
			User user = userDao.LoginUser(username,password);
			if(user!=null) {
				loginUser = user;
				if(user.getUser_limit()==1) {
					new UserMainFrame();
					setVisible(false);
				}else{
					new AdminPage();
					setVisible(false);
				}
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误", "提示", 1);
			}
		}
		
	}
	class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new UserRegisterFrame();
		}
	}
	
}
