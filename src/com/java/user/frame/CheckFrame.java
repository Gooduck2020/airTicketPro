package com.java.user.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.domian.Flight;

public class CheckFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField startext = null;
	private JTextField endtext = null;
	private JTextField yyText = null;
	private JTextField mmText = null;
	private JTextField ddText = null;
	private JPanel yearPanel = null;
	private JPanel monthPanel = null;
	private JPanel dayPanel = null;
	private int[] dates = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
	public CheckFrame() {
		setLayout(null);
		setTitle("机票搜索");
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("选项");
		JMenuItem item1 = new JMenuItem("消息");
		JMenuItem item2 = new JMenuItem("首页");
		JMenuItem item3 = new JMenuItem("联系我们");
		JMenuItem item4 = new JMenuItem("我要反馈");
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		bar.add(menu);
		setJMenuBar(bar);
		JLabel label1 = new JLabel("单程");
		JLabel label2 = new JLabel("往返");
		JLabel label3 = new JLabel("多程");
		label1.setFont(new Font("宋体",Font.BOLD,15));
		label1.setBounds(120,10,35,35);
		label2.setBounds(220,10,35,35);
		label3.setBounds(320,10,35,35);
		JLabel startlabel = new JLabel("起点");
		JLabel endlabel = new JLabel("终点");
		startlabel.setBounds(80,80,30,30);
		endlabel.setBounds(280,80,30,30);
		startext = new JTextField("南京");
		ImageIcon img1 = new ImageIcon(getClass().getResource("icon/003.png"));
		img1.setImage(img1.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT));
		JButton changeBtn = new JButton(img1);
		changeBtn.addActionListener(new ChangeListener());
		endtext = new JTextField();
		startext.setBounds(110,80,80,30);
		endtext.setBounds(310,80,80,30);
		changeBtn.setBounds(220, 80, 30, 30);
		
		Date date = new Date();
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		
		yearPanel(year);
		monthPanel();
		dayPanel();
		
		getContentPane().add(yearPanel);
		getContentPane().add(monthPanel);
		getContentPane().add(dayPanel);
		JLabel timeLabel = new JLabel("出行时间");
		yyText = new JTextField(year+"");
		JLabel yylabel = new JLabel("年");
		mmText = new JTextField(month+"");
		JLabel mmlabel = new JLabel("月");
		ddText = new JTextField(day+"");
		JLabel ddlabel = new JLabel("日");
		timeLabel.setBounds(90, 170, 60, 30);
		yyText.setBounds(180, 177, 40, 20);
		mmText.setBounds(255, 177, 30, 20);
		ddText.setBounds(320, 177, 30, 20);
		yylabel.setBounds(225, 170, 20, 30);
		mmlabel.setBounds(290, 170, 20, 30);
		ddlabel.setBounds(355, 170, 20, 30);
		JButton searchBtn = new JButton("开始搜索");
		yyText.addActionListener(new SelectYear());
		mmText.addActionListener(new SelectMonth());
		ddText.addActionListener(new SelectDay());
		searchBtn.setBounds(145, 250, 200, 30);
		searchBtn.setBackground(new Color(249,111,60));
		searchBtn.setForeground(Color.WHITE);
		searchBtn.addActionListener(new SearchListener());
		add(label1);
		add(label2);
		add(label3);
		add(startlabel);
		add(changeBtn);
		add(endlabel);
		add(startext);
		add(endtext);
		add(timeLabel);
		add(yyText);
		add(yylabel);
		add(mmText);
		add(ddText);
		add(mmlabel);
		add(ddlabel);
		add(searchBtn);
		getContentPane().setBackground(Color.white);
		setLocation(700, 280);
		setSize(500, 400);
		setVisible(true);
		setResizable(false);
	}
	private void dayPanel() {
		dayPanel = new JPanel();
		dayPanel.setLayout(new GridLayout(5, 7));
		if(mmText==null) {
			return;
		}
		int m = Integer.parseInt(mmText.getText());
		for( int i = 0 ; i < dates[m] ; i++ ){
			JButton monbtn = new JButton(dates[i-1]+"");
			monbtn.addActionListener(new hideDay());
			dayPanel.add(monbtn);
		}
		dayPanel.setBounds(320, 197, 150, 100);
		dayPanel.setVisible(false);
	}
	
	private void yearPanel(int year) {
		yearPanel = new JPanel();
		yearPanel.setLayout(new GridLayout(2, 1));
		JButton newYear = new JButton(year+"");
		newYear.addActionListener(new hideYear());
		JButton nextYear = new JButton((year+1)+"");
		nextYear.addActionListener(new hideYear());
		yearPanel.add(newYear);
		yearPanel.add(nextYear);
		yearPanel.setBounds(180, 197, 70, 60);
		yearPanel.setVisible(false);
	}
	private void monthPanel() {
		monthPanel = new JPanel();
		monthPanel.setLayout(new GridLayout(4, 3));
		for( int i = 0 ; i < dates.length ; i++ ) {
			JButton monbtn = new JButton((i+1)+"");
			monbtn.addActionListener(new hideMonth());
			monthPanel.add(monbtn);
		}
		monthPanel.setBounds(255, 197, 150, 100);
		monthPanel.setVisible(false);
	}
	
	
	class ChangeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String temp = endtext.getText();
			endtext.setText(startext.getText());
			startext.setText(temp);
		}
	}
	class SearchListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String datestr = "";
			String start = startext.getText();
			String end = endtext.getText();
			String yy = yyText.getText();
			String mm = mmText.getText();
			String dd = ddText.getText();
			if(yy.equals("")||mm.equals("")||dd.equals("")) {
				JOptionPane.showMessageDialog(null, "日期不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			datestr = yy+"-"+mm+"-"+dd;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new Date();
			try {
				date1 = sdf.parse(datestr);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Flight flight = new Flight();
			flight.setFlight_start(start);
			flight.setFlight_end(end);
			flight.setFlight_time(date1);
			new SelectFlightFrame(flight);
		}
	}
	class SelectYear implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			yearPanel.setVisible(true);
		}
	}
	class SelectMonth implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			monthPanel.setVisible(true);
		}
	}
	class SelectDay implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dayPanel.setVisible(true);
		}
	}
	
	class hideMonth implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			monthPanel.setVisible(false);
			mmText.setText(((JButton)e.getSource()).getText());
		}
		
	}
	class hideYear implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			yearPanel.setVisible(false);
			yyText.setText(((JButton)e.getSource()).getText());
		}
	}
	class hideDay implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dayPanel.setVisible(false);
			ddText.setText(((JButton)e.getSource()).getText());
		}
	}
	
}
