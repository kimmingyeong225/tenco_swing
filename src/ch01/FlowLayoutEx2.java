package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;

import javax.swing.JFrame;


public class FlowLayoutEx2 extends JFrame {

	// 배열 활용 - 하나의 변수로 여러개 통으로 관리하고 싶다면 배열을 써보자
	private JButton[] buttons;
	

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능하다.
		initDate();
		setInitLayout();
		

	}

	// 멤버 변수를 초기화 하는 기능(값 넣다)
	private void initDate() {
		buttons = new JButton[6];

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("[button " + (i + 1) + "]");
		}

	}

	// 컴포넌트들을 배치하는 기능

	public void setInitLayout() {
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50));
		for (int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}

		

	}

	// 코드 테스트
	public static void main(String[] args) {
		// flowLayoutEx f1 = new FlowLayoutEx(); // <--- 부를 수 있는 이름이 있는 상태
		new FlowLayoutEx2(); // <--- 익명 클래스 (주소값이 없음) // 다시 접근해서 사용할 일 없으면

	}// end of main
}
