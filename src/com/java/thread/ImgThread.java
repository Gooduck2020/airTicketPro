package com.java.thread;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImgThread implements Runnable {
	private JLabel lab;
	
	public ImgThread(JLabel lab) {
		this.lab = lab;
	}
	@Override
	public void run() {
		int i = 0;
		String str = "a";
		ImageIcon img1 = null;
		while(true) {

			if(i%4 == 0) {
				img1 = new ImageIcon(getClass().getResource("icon/R1.jpg"));
				img1.setImage(img1.getImage().getScaledInstance(500, 150,Image.SCALE_DEFAULT));
			}else if(i%4==1){
				img1 = new ImageIcon(getClass().getResource("icon/R2.jpg"));
				img1.setImage(img1.getImage().getScaledInstance(500, 150,Image.SCALE_DEFAULT));
			}else if(i%4==2) {
				img1 = new ImageIcon(getClass().getResource("icon/R3.jpg"));
				img1.setImage(img1.getImage().getScaledInstance(500, 150,Image.SCALE_DEFAULT));
			}else {
				img1 = new ImageIcon(getClass().getResource("icon/R4.jpg"));
				img1.setImage(img1.getImage().getScaledInstance(500, 150,Image.SCALE_DEFAULT));
			}
			lab.setIcon(img1);
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

}
