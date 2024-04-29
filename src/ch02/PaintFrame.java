package ch02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;




// 내부 클래스를 활용해서 코드를 완성해주세요
public class PaintFrame extends JFrame{
	
	MyDrawPanel myDrawPanel;

	public PaintFrame() {
		
		initData();
		setInitLayout();
	}
		

	

	private void initData() {
		setTitle("그림 그리기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel = new MyDrawPanel();
	}

	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);

	}

	
	
	class MyDrawPanel extends JPanel {

		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//g.drawRect(100, 100, 50, 100);
			//int x1, int y1, int x2, int y2
			//g.setColor(Color.pink);
			//g.fillRect(200, 200, 250, 250);// 채우기
			g.drawRect(200, 200, 250, 250);
			//g.setColor(Color.red);
			g.drawRect(300, 300, 50, 100);
			g.fillRect(300, 300, 50, 100);// 채우기
			//g.drawLine(250, 300, 300, 300); // 막대기
			
			g.drawOval(100, 50, 100, 100); // 타원
			g.drawString("해", 145, 100);
			
			//g.drawString("반가워", 400, 400);
			g.drawString("|—————————| \"|——————————|\"", 200, 400);
			g.drawString("👩🏻‍🤝‍👩🏻👩🏻‍🤝‍  👩 👩🏻‍🤝‍👩🏻👩🏻‍🤝‍  👩 👩🏻‍🤝‍👩🏻👩🏻‍🤝‍  👩", 200, 250);
			g.drawString("⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐ ⭐⭐",200, 200);
			//g.setColor(Color.red);
			
			g.drawLine(450, 200 ,300, 100);// 오른쪽
			g.drawLine(300, 100, 200, 200);
			
			
			


}
	}
	}
