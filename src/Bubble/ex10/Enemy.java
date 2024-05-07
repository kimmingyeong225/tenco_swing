package Bubble.ex10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel implements Moveable {

	BubbleFrame mContext;
	// 살아 있는 상태 0, 물방울에 갇힌 상태1
	private int state;

	// 적군에 좌표값 위치 상태
	private int x;
	private int y;
	private ImageIcon enemyR, enemyrL;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 적군 멈추기
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	
	// get, set

	
	public BubbleFrame getmContext() {
		return mContext;
	}

	public void setmContext(BubbleFrame mContext) {
		this.mContext = mContext;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getEnemyR() {
		return enemyR;
	}

	public void setEnemyR(ImageIcon enemyR) {
		this.enemyR = enemyR;
	}

	public ImageIcon getEnemyrL() {
		return enemyrL;
	}

	public void setEnemyrL(ImageIcon enemyrL) {
		this.enemyrL = enemyrL;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public EnemyWay getEnemyWay() {
		return enemyWay;
	}

	public void setEnemyWay(EnemyWay enemyWay) {
		this.enemyWay = enemyWay;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	
	// 적군 속도 상태
	private final int SPEED = 3;
	private final int JUMPSPEED = 1;

	// 적군 방향 상태
	private EnemyWay enemyWay;

	public Enemy(BubbleFrame mContext) { // 부모의 주소값이 들어오는
		this.mContext = mContext;
		initData();
		setInitLayout();
		
		left();
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}

	private void initData() {
		enemyR = new ImageIcon("img/enemyR.png");
		enemyrL = new ImageIcon("img/enemyL.png");

		state = 0;

		// 처음 실행 시 적군 위치
		x = 720;
		y = 175;

		// 적군 방향 상태
		left = false;
		right = false;
		up = false;
		down = false;

		enemyWay = EnemyWay.LEFT;

	}

	private void setInitLayout() {
		setIcon(enemyR);
		setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
		enemyWay = enemyWay.LEFT;
		left = true;
		setIcon(enemyrL);

		// <- <- <-
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {

					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}

			}
		}).start();

	}

	@Override
	public void right() {
		enemyWay = enemyWay.RIGHT;
		right = true;
		setIcon(enemyR);

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (right) {

					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {

						e.printStackTrace();
					} // 0.01

				}
			}

		}).start();

	}// end of right

	@Override
	public void up() {
		System.out.println("점프");

		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);

					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 객체의 상태값을 잘 조절해야 한다
				up = false;
				down();
			}
		}).start();

	}

	@Override
	public void down() {
		System.out.println("다운");
		down = true;

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (down) {

					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}
				// 상태값 처리를 확실히 하자
				down = false;
			}
		}).start();

		// 상태값 처리를 확실히 하자

	}// end of down

}// end of class
