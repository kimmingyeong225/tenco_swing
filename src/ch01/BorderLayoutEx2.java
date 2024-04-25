package ch01;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class BorderLayoutEx2 extends JFrame{

	//생성자
	public BorderLayoutEx2() {
		
		initData();
		setInitLayout();
		
	}
	
	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void setInitLayout() {
		//배치관리자 선정(컨테이너)
		
		setLayout(new BorderLayout());
		add(new JButton("동"), BorderLayout.EAST);
		add(new JButton("서"), BorderLayout.WEST);
		add(new JButton("남"), BorderLayout.SOUTH);
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("센터"), BorderLayout.CENTER);
	
	
		}
	public static void main(String[] args) {
		new BorderLayoutEx2();
	
	}
	
	
}
