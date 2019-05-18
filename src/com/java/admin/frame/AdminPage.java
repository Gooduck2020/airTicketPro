package com.java.admin.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.java.thread.ThreadImp;
import com.java.user.frame.LoginFrame;

public class AdminPage extends JFrame {
	private static final long serialVersionUID = 1L;

	public AdminPage() {
		setLayout(null);
		JLabel Title = new JLabel("管理员界面");
		JLabel Time = new JLabel();
		JLabel jButton1Tip = new JLabel("审核订单");
		JLabel jButton2Tip = new JLabel("察看订单");
		JLabel jButton3Tip = new JLabel("增加航班");
		JLabel jButton4Tip = new JLabel("人员调度");
		JLabel jButton5Tip = new JLabel("暂无功能");

		ThreadImp threadImp = new ThreadImp(Time);
		Thread thread = new Thread(threadImp);
		thread.start();
		Font Titlef = new Font("宋体", Font.BOLD, 35);

		Font Timef = new Font("宋体", Font.BOLD, 32);
		Title.setForeground(Color.white);
		Title.setFont(Titlef);
		Time.setForeground(Color.white);
		Time.setFont(Timef);
		ImageIcon manage1 = new ImageIcon(getClass().getResource("icon/003.jpg"));
		manage1.setImage(manage1.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		ImageIcon manage2 = new ImageIcon(getClass().getResource("icon/002.jpg"));
		manage2.setImage(manage2.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		ImageIcon manage3 = new ImageIcon(getClass().getResource("icon/004.jpg"));
		manage3.setImage(manage3.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		ImageIcon manage4 = new ImageIcon(getClass().getResource("icon/000.jpg"));
		manage4.setImage(manage4.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		ImageIcon manage5 = new ImageIcon(getClass().getResource("icon/005.jpg"));
		manage5.setImage(manage5.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
		ImageIcon manage6 = new ImageIcon(getClass().getResource("icon/bgc1.jpg"));
		manage6.setImage(manage6.getImage().getScaledInstance(1000, 600, Image.SCALE_AREA_AVERAGING));
		JButton jButton1 = new JButton(manage1);
		JButton jButton2 = new JButton(manage2);
		CheckOrderListener checkOrderListener = new CheckOrderListener();
		ReviewOrderListener reviewOrderListener = new ReviewOrderListener();
		jButton1.addActionListener(reviewOrderListener);
		JButton jButton3 = new JButton(manage3);
		jButton2.addActionListener(checkOrderListener);
		JButton jButton4 = new JButton(manage4);
		jButton4.addActionListener(new PerListener());
		AddFlightListener addFlightListener = new AddFlightListener();
		jButton3.addActionListener(addFlightListener);
		JButton jButton5 = new JButton(manage5);

		add(Title);
		add(jButton1);
		add(jButton2);
		add(jButton3);
		add(jButton4);
		add(jButton5);
		add(jButton1Tip);
		add(jButton2Tip);
		add(jButton3Tip);
		add(jButton4Tip);
		add(jButton5Tip);

		add(Time);
		Title.setBounds(360, 40, 200, 40);

		jButton1.setBounds(140, 150, 100, 100);
		jButton2.setBounds(265, 150, 100, 100);
		jButton3.setBounds(390, 150, 100, 100);
		jButton4.setBounds(515, 150, 100, 100);
		jButton5.setBounds(640, 150, 100, 100);

		Font jButton1Tipf = new Font("宋体", Font.BOLD, 22);
		jButton1Tip.setForeground(Color.white);
		jButton1Tip.setFont(jButton1Tipf);
		jButton1Tip.setBounds(140, 240, 100, 100);

		Font jButton2Tipf = new Font("宋体", Font.BOLD, 22);
		jButton2Tip.setForeground(Color.white);
		jButton2Tip.setFont(jButton2Tipf);
		jButton2Tip.setBounds(265, 240, 100, 100);

		Font jButton3Tipf = new Font("宋体", Font.BOLD, 22);
		jButton3Tip.setForeground(Color.white);
		jButton3Tip.setFont(jButton3Tipf);
		jButton3Tip.setBounds(390, 240, 100, 100);

		Font jButton4Tipf = new Font("宋体", Font.BOLD, 22);
		jButton4Tip.setForeground(Color.white);
		jButton4Tip.setFont(jButton4Tipf);
		jButton4Tip.setBounds(515, 240, 100, 100);

		Font jButton5Tipf = new Font("宋体", Font.BOLD, 22);
		jButton5Tip.setForeground(Color.white);
		jButton5Tip.setFont(jButton5Tipf);
		jButton5Tip.setBounds(640, 240, 100, 100);

		Time.setBounds(300, 170, 590, 400);

		JLabel bgc = new JLabel(manage6);
		bgc.setBounds(0, 0, 900, 600);// 320 60
		add(bgc);
		setLocation(400, 100);
		setSize(900, 600);
		setVisible(true);
		setResizable(false);

	}

	class CheckOrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new CheckOrder();
		}
	}

	class ReviewOrderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new ReviewOrder();

		}
	}

	class AddFlightListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddFlight();
		}
	}
	class PerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Integer user_limit = LoginFrame.loginUser.getUser_limit();
			System.out.println(user_limit);
			if(user_limit==3) {
				new PersonManFrame();
			}
			else {
				JOptionPane.showMessageDialog(null, "暂无权限", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		
	}	
}
