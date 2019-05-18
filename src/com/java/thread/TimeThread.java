package com.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class TimeThread implements Runnable {
	
	private JLabel timeLabel;
	
	public TimeThread(JLabel timeLabel) {
		this.timeLabel = timeLabel;
	}

	@Override
	public void run() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd  HH:mm:ss");
		String timeText = simpleDateFormat.format(date);
		timeLabel.setText(timeText);
	}

}
