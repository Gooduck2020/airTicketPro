package com.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ThreadImp implements Runnable {
	private JLabel jlabel = new JLabel();

	public ThreadImp(JLabel jlabel) {
		this.jlabel = jlabel;
	}

	@Override
	public void run() {
		while (true) {
			// TODO Auto-generated method stub
			// 我要获取当前的日期
			Date date = new Date();
			// 设置要获取到什么样的时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 获取String类型的时间
			String createdate = sdf.format(date);
			jlabel.setText(createdate);
		}
	}

}
