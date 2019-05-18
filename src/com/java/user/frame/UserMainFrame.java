package com.java.user.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class UserMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public UserMainFrame() {
		if(LoginFrame.loginUser!=null) {
			setTitle("欢迎进入购票系统！    尊敬的用户:"+LoginFrame.loginUser.getUser_name());
		}else {
			setTitle("欢迎进入购票系统！    未登录");
		}
		setLayout(new GridLayout(3,1));
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("选项");
		JMenuItem item1 = new JMenuItem("消息");
		JMenuItem item2 = new JMenuItem("首页");
		JMenuItem item3 = new JMenuItem("联系我们");
		JMenuItem item4 = new JMenuItem("我要反馈");
		JMenuItem item5 = new JMenuItem("注销");
		item5.addActionListener(new LoginBtn());
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		menu.add(item5);
		bar.add(menu);
		setJMenuBar(bar);
		JPanel header = new JPanel();
		JPanel bodyer = new JPanel();
		JPanel footer = new JPanel();
		bodyer.setLayout(new FlowLayout());
		ImageIcon img1 = new ImageIcon(getClass().getResource("icon/002.jpg"));
		img1.setImage(img1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT));
		JButton flightBtn = new JButton(img1);
		flightBtn.setPreferredSize(new Dimension(150, 150));
		ImageIcon img2 = new ImageIcon(getClass().getResource("icon/001.png"));
		img2.setImage(img2.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT));
		JButton orderBtn = new JButton(img2);
		orderBtn.setPreferredSize(new Dimension(150, 150));
		ImageIcon img3 = new ImageIcon(getClass().getResource("icon/003.png"));
		img3.setImage(img3.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT));
		JButton cancelBtn = new JButton(img3);
		cancelBtn.setPreferredSize(new Dimension(150, 150));
		flightBtn.addActionListener(new FlightBtnListener());
		orderBtn.addActionListener(new OrderBtn());
		cancelBtn.addActionListener(new CancelListener());
		bodyer.add(flightBtn);
		bodyer.add(orderBtn);
		bodyer.add(cancelBtn);
		add(header);
		add(bodyer);
		add(footer);
		setLocation(670, 260);
		setSize(600, 500);
		setVisible(true);
	}
	class CancelListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new CancelFrame();
		}
		
	}
	class FlightBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new CheckFrame();
		}
	}
	
	class LoginBtn implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new LoginFrame();
		}
	}
	class OrderBtn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new UserOrderFrame();
		}
	}
}
