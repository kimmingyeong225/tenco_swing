package ch01;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class BorderLayoutEx1 extends JFrame{
	
	// 배열
	final int WIDTH = 600;
	final int HEIGHT = 600;
	
	JButton[] buttons;
	String[] directions = {BorderLayout.EAST, BorderLayout.WEST, BorderLayout.NORTH, BorderLayout.SOUTH,
			BorderLayout.CENTER};

	//생성자
	public BorderLayoutEx1() {
		
		initData();
		setInitLayout();
		
	}
	
	public void initData() {
		setTitle("borderLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttons = new JButton[directions.length];// 객체 메모리 공간 5칸 올림
	
	}
	
	public void setInitLayout() {
		//배치관리자 선정(컨테이너)
		
		setLayout(new BorderLayout());
	
		// 반복문을 활용해서 코드를 완성하세요.
		
	 	//new BorderLayout(directions);
		for (int i = 0; i < buttons.length; i++) {
			//super.add(buttons[i]);
			add( new JButton(directions[i]), directions[i]);
		}
		
		
	
	
		}
	public static void main(String[] args) {
		new BorderLayoutEx1();
	
	}
	
	
}
