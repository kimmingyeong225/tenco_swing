package Bubble.ex10;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * 스스로 수정 (적군이 벽에 안 부딪히게) (지금 왼쪽으로 쭉 가는 상태니까 멈추고 오른쪽으로 가도록!)
 */
public class BackgroundEnemyervice implements Runnable{

	private BufferedImage image;
	//private Player player;
	private Enemy enemy;
	//private Enemy enemy2;
	
	
	public BackgroundEnemyervice(Enemy enemy) {
		this.enemy = enemy;
		//this.enemy2 = enemy;
		
		
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
			//enemy2 = ImageIO.read(new File("img/enemyL.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	@Override
	public void run() {
		while(true) {
			// 색상 확인 todo (보정값 필요)
			Color leftColor = new Color(image.getRGB(enemy.getX() + 10, enemy.getY() + 25));
			Color rightColor = new Color(image.getRGB(enemy.getX() + 50 + 10, enemy.getY() + 25));
			//--> RGB 뽑아내는거
			
			// 흰색이면 바닥 RGB => 255 255 255
			// 바닥인 경우 --> 255 0 0 (바닥이라고 판단 가능)
			// 바닥인 경우 --> 0 0 355 (바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(enemy.getX() + 20, enemy.getY() + 50 + 5);
			int bottomColorRight = image.getRGB(enemy.getX() +50 + 10, enemy.getY() + 50 + 5);//+5 이미지 값 때문에 +해줌
	
			
			
			// 하얀색 ---> int 값이 -1
			if(bottomColorLeft + bottomColorRight != -2) {
				// 여기는 멈추어야 한다. (빨간색 바닥 또는 파란색 바닥)
				enemy.setDown(false);
			}else {
				
				// 플레이어가 올라가는 상태가 아니라면 
				// 그리고 
				// 플레이어가 내려가는 상태가 아니라면
				// down() 호출
				if(!enemy.isUp() && !enemy.isDown()) {
					enemy.down();
				}
				
	
			
			}
			
			
			
			
			// 왼쪽에 충돌함
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽벽에 출동 함");
				enemy.setLeftWallCrash(true);
				enemy.setLeft(false);
				
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				
				System.out.println("오른쪽벽에 충돌 함");
				enemy.setRightWallCrash(true);
				enemy.setRight(false);
			}else {
				enemy.setLeftWallCrash(false);
				enemy.setRightWallCrash(false);
				
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
		
		
	
		
	
		}
	}



