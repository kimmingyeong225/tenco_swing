package Bubble.ex06;

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

		// 백그라운드 서비스 시작

		new Thread(new BackgroundPlayerService(player)).start();

	}

	private void initData() {
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		// backgroundMap = new JLabel(new ImageIcon("img/test.png"));
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

					// 왼쪽으로 방향키 누르고 있다면
					// key 이벤트가 계속 <- <- <- <- <-
					// 왼쪽 상태가 아니라면
					// 왼쪽 벽에 충돌 한게 아니하면
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}

					break;
				case KeyEvent.VK_RIGHT:

					if (!player.isRight() && !player.isRightWallCrash()) {
						player.rigth();
					}

					break;
				case KeyEvent.VK_UP:
					player.up();

					break;
				case KeyEvent.VK_SPACE:
					
					add(new Bubble(player)); // 익명 클래스 add -> 붙이다(그 값 하나만 출력
					break;
				default:
					break;
				// case KeyEvent.VK_DOWN :
				// player.down();

				}

			}// end of KeyPressed

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가능 상태 멈춤
					player.setLeft(false);
					break;

				case KeyEvent.VK_RIGHT:
					//오른쪽을 가능 상태 멈춤
					player.setRight(false);
					break;
				default:
					break;

				}

			}// end of KeyReleased

		});

	}

	// 코드 테스트
	public static void main(String[] args) {
		new BubbleFrame();

	}// end of main

}
