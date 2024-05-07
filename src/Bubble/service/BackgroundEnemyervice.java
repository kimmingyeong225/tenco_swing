package Bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Bubble.components.Player;

/*
 * 스스로 수정 
 */
public class BackgroundEnemyervice implements Runnable{

	private BufferedImage image;
	private Player player;
	
	
	public BackgroundEnemyervice(Player player) {
		this.player = player;
	
		
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	@Override
	public void run() {
		while(true) {
			// 색상 확인 todo (보정값 필요)
			Color leftColor = new Color(image.getRGB(player.getX() + 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			//Color upColor = new Color(image.getRGB(player.getX() + 10 , player.getY() + 10));
			//Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
			//--> RGB 뽑아내는거
			
			// 흰색이면 바닥 RGB => 255 255 255
			// 바닥인 경우 --> 255 0 0 (바닥이라고 판단 가능)
			// 바닥인 경우 --> 0 0 355 (바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(player.getX() + 20, player.getY() + 50 + 5);
			int bottomColorRight = image.getRGB(player.getX() +50 + 10, player.getY() + 50 + 5);//+5 이미지 값 때문에 +해줌
			
			//int topColor = image.getRGB(bubble.getX() + 25, bubble.getY() -5); // 버블 팡!
			// 색깔을 이용해서 터트리려고 했는데..
			
			// x, y 좌표에 터졌을 때 버블이 터진다!
			// if x == bublle이 같다면 버블이 터진다!
		
			
			
			// 하얀색 ---> int 값이 -1
			if(bottomColorLeft + bottomColorRight != -2) {
				// 여기는 멈추어야 한다. (빨간색 바닥 또는 파란색 바닥)
				player.setDown(false);
			}else {
				
				// 플레이어가 올라가는 상태가 아니라면 
				// 그리고 
				// 플레이어가 내려가는 상태가 아니라면
				// down() 호출
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
				
				// 버블 팡!
////				if(topColor == -65536) {
////					bubble.setUp(false);
////					bubble.setTopWallCrash(true);
////					bubble.pop(); 
//					
//				}
			
			}
			
			
			
			
			// 왼쪽에 충돌함
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽벽에 출동 함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
				
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				
				System.out.println("오른쪽벽에 충돌 함");
				player.setRightWallCrash(true);
				player.setRight(false);
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
				//bubble.setTopWallCrash(false); // 버블 팡
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
		
		
	
		
	
	}

}
