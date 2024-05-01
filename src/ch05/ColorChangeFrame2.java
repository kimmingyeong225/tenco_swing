package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel;
	private JPanel pane2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	


	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBackground(Color.black);

		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pane2 = new JPanel();
		pane2.setLayout(new FlowLayout());
		pane2.setBackground(Color.white);

		button1 = new JButton("다크그레이");
		button2 = new JButton("하늘");
		button3 = new JButton("파랑");
		button4 = new JButton("분홍");

	}

	private void setInitLayout() {

		add(panel, BorderLayout.CENTER);
		add(pane2, BorderLayout.SOUTH);
		pane2.add(button1);
		pane2.add(button2);
		pane2.add(button3);
		pane2.add(button4);
//		add(panel, BorderLayout.CENTER);
//		add(pane2, FlowLayout.CENTER);
//		add(button3, FlowLayout.RIGHT);
//		add(button4, FlowLayout.LEFT);
		setVisible(true);

	}

	// 이 메서드에 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

	}

	// 오버라이드 : 이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getSource().toString());
		Object object = e.getSource();

		JButton selectedButton = (JButton) e.getSource();

		// System.out.println(selectedButton);
		System.out.println(selectedButton.getText());
		
		if (selectedButton == this.button1) {
			System.out.println("button1 객체가 눌러졌다라고 판명 가능");
			panel.setBackground(Color.DARK_GRAY);
		} else if (selectedButton == this.button2) {
			System.out.println("button2 객체가 눌러졌다라고 판명 가능");
			panel.setBackground(Color.cyan);
		} else if (selectedButton == this.button3) {
			System.out.println("button3 객체가 눌러졌다라고 판명 가능");
			panel.setBackground(Color.blue);
		} else if (selectedButton == this.button4) {
			System.out.println("button4 객체가 눌러졌다고 판명 가능");
			panel.setBackground(Color.pink);
		}

	}
	
		

	// 코드 테스트
	public static void main(String[] args) {
		new ColorChangeFrame2();
	}

}
