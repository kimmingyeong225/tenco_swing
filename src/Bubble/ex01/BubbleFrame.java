package Bubble.ex01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	
	private Player player;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {

		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame -> root Panal
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);

		player = new Player();

	}

	private void setInitLayout() {

		// 좌표 값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(player);

	}

	private void addEventListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 구현
					// 어떤 걸 누르면 이동하는지 얼마 값을 이동하는지
					player.left();

					break;
				case KeyEvent.VK_RIGHT:
					player.rigth();
					
					break;
				case KeyEvent.VK_UP:
					player.up();

					break;

				}

			}// end of KeyPressed

		});

	}
	
	// 코드 테스트
	public static void main(String[] args) {
		new BubbleFrame();
		
	}// end of main

}
