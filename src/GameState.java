/*** In The Name of Allah ***/

import java.io.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.security.Key;

import sun.audio.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 * This class holds the state of game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {

	private boolean mouseReleas;
	public int locX, locY, diam;
	public boolean gameOver;
	
	private boolean keyUp, keyDOWN, keyRIGHT, keyLEFT;
	public boolean nw,ne,sw,se;
	public boolean mousepress;
	private boolean mouseClick;
	public int mouseX, mouseY;
	private int mouseXX, mouseYY;
	private KeyHandler keyHandler;
	private MouseHandler mouseHandler;
	public double dgree;
	public double teta;
	private static final double p=Math.PI;
	private double changeAngleAmount;
	private int tankSpeed;
	private int prsentGun;
	private int live;
	private int HeavyGunRemain;
	private int LightGunRemain;
	private int HeavyGunLevel;
	private int LightGunLevel;

	private InputStream soundin ;
	private AudioStream as ;
	
	public GameState() {
		locX = 100;
		locY = 100;
		diam = 0;
		gameOver = false;
		//
		keyUp = false;
		keyDOWN = false;
		keyRIGHT = false;
		keyLEFT = false;
		dgree=0;
		//
		mousepress = false;
		mouseClick = false;
		mouseReleas = false;
		mouseX = 0;
		mouseY = 0;
		//
		keyHandler = new KeyHandler();
		mouseHandler = new MouseHandler();
	}

	
	/**
	 * The method which updates the game state.
	 */
	public void update() {
//		if (mousepress) {
//			locY = mouseY - diam / 2;
//			locX = mouseX - diam / 2;
//		}
//		if (keyUp)
//			locY -= 10;
//		if (keyDOWN)
//			locY += 10;
//		if (keyLEFT)
//			locX -= 10;
//		if (keyRIGHT)
//			locX += 10;


		if(keyRIGHT&&keyUp){
			if(dgree==315){
				locX += 4;
				locY -= 4;

			}
			else if((dgree<=135)||(dgree>315)) {
				dgree -= 3.75;
				updateBydgree();
			}
			else if((dgree>135)&&(dgree<315)){
				dgree += 3.75;
				updateBydgree();
			}
		}

		else if(keyDOWN&&keyLEFT){
			if(dgree==135){
				locX -= 4;
				locY += 4;
			}
			else if((dgree<=315)&&(dgree>135)) {
				dgree -= 3.75;
				updateBydgree();
			}
			else if((dgree>315)||(dgree<135)) {
				dgree += 3.75;
				updateBydgree();
			}
		}
		else if(keyRIGHT&&keyDOWN){
			if(dgree==45) {
				locX += 4;
				locY += 4;
			}
			else if ((dgree<=225)&&(dgree>45)){
				dgree -= 3.75;
				updateBydgree();
			}
			else if ((dgree>225)||(dgree<45)){
				dgree += 3.75;
				updateBydgree();
			}
		}
		else if(keyLEFT&&keyUp){
			if(dgree==225) {
				locX -= 4;
				locY -= 4;
			}
			else if ((dgree<225)&&(dgree>=45)){
				dgree += 3.75;
				updateBydgree();
			}
			else if ((dgree>225)||(dgree<45)){
				dgree -= 3.75;
				updateBydgree();
			}
		}
		else if(keyRIGHT&&(!keyDOWN)&&(!keyUp)){
			if(dgree==0) {
				locX += 7;
			}
			else if ((dgree<=180)&&(dgree>0)){
				dgree -= 3.75;
				updateBydgree();
			}
			else if ((dgree>180)||(dgree<0)){
				dgree += 3.75;
				updateBydgree();
			}
		}
		else if(keyLEFT&&!keyDOWN&&!keyUp){
			if(dgree==180) {
				locX -= 7;
			}
			else if ((dgree<180)&&(dgree>=0)){
				dgree += 3.75;
				updateBydgree();
			}
			else if ((dgree>180)||(dgree<0)){
				dgree -= 3.75;
				updateBydgree();
			}
		}

		else if(keyUp&&!keyLEFT&&!keyRIGHT){
			if(dgree==270) {
				locY -= 7;
			}
			else if ((dgree<=90)||(dgree>270)){
				dgree -= 3.75;
				updateBydgree();
			}
			else if ((dgree>90)&&(dgree<270)){
				dgree += 3.75;
				updateBydgree();
			}
		}

		else if(keyDOWN&&!keyLEFT&&!keyRIGHT){
			if(dgree==90) {
				locY += 7;

			}
			else if ((dgree<90)||(dgree>=270)){
				dgree += 3.75;
				updateBydgree();
			}
			else if ((dgree>90)&&(dgree<270)){
				dgree -= 3.75;
				updateBydgree();
			}
		}
//		System.out.println("dgree: "+ dgree);


//		if(keyRIGHT){
//			if(dgree==0) {
//				locX += 7;
//			}
//			else if ((dgree<=180)&&(dgree>0)){
//				changeAngleAmount -= 3.75;
//				updateBydgree2();
//			}
//			else if ((dgree>180)||(dgree<0)){
//				changeAngleAmount += 3.75;
//				updateBydgree2();
//			}
//		}
//		if(keyLEFT){
//			if(dgree==180) {
//				locX -= 7;
//			}
//			else if ((dgree<180)&&(dgree>=0)){
//				changeAngleAmount += 3.75;
//				updateBydgree2();
//			}
//			else if ((dgree>180)||(dgree<0)){
//				changeAngleAmount -= 3.75;
//				updateBydgree2();
//			}
//		}
//
//		if(keyUp){
//			if(dgree==270) {
//				locY -= 7;
//			}
//			else if ((dgree<=90)||(dgree>270)){
//				changeAngleAmount -= 3.75;
//				updateBydgree2();
//			}
//			else if ((dgree>90)&&(dgree<270)){
//				changeAngleAmount += 3.75;
//				updateBydgree2();
//			}
//		}
//
//		if(keyDOWN){
//			if(dgree==90) {
//				locY += 7;
//
//			}
//			else if ((dgree<90)||(dgree>=270)){
//				changeAngleAmount += 3.75;
//				updateBydgree2();
//			}
//			else if ((dgree>90)&&(dgree<270)){
//				changeAngleAmount -= 3.75;
//				updateBydgree2();
//			}
//		}


		locX = Math.max(locX, 0);
		locX = Math.min(locX, GameFrame.GAME_WIDTH - diam);
		locY = Math.max(locY, 0);
		locY = Math.min(locY, GameFrame.GAME_HEIGHT - diam);
	}
	
	
	public KeyListener getKeyListener() {
		return keyHandler;
	}
	public MouseListener getMouseListener() {
		return mouseHandler;
	}
	public MouseMotionListener getMouseMotionListener() {
		return mouseHandler;
	}

	private void updateBydgree(){
		if(dgree>=360)
			dgree-=360;
		if(dgree<0)
			dgree+=360;
		teta=p*dgree/180;
		locX += 2*Math.cos(teta);
		locY += 2*Math.sin(teta);
		System.out.println("DEGREE:  "+dgree);
	}
	private void updateBydgree2(){
		if(changeAngleAmount>3.5)
			changeAngleAmount=3.5;
		if(changeAngleAmount<-3.25)
			changeAngleAmount=-3.5;
		dgree+=changeAngleAmount;
		if(dgree>=360)
			dgree-=360;
		if(dgree<0)
			dgree+=360;
		teta=p*dgree/180;
		locX += 4*Math.cos(teta);
		locY += 4*Math.sin(teta);
		//System.out.println("DEGREE:  "+dgree);
	}

	public int getLocX() {
		return locX;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public int getLocY() {
		return locY;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	public boolean isMouseClick() {
		return mouseClick;
	}

	public void setMouseClick(boolean mouseClick) {
		this.mouseClick = mouseClick;
	}

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	public boolean isMouseReleas() {
		return mouseReleas;
	}

	public boolean isMousepress() {
		return mousepress;
	}

	/**
	 * The keyboard handler.
	 */
	class KeyHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_UP:
					keyUp = true;
					break;
				case KeyEvent.VK_DOWN:
					keyDOWN = true;
					break;
				case KeyEvent.VK_LEFT:
					keyLEFT = true;
					break;
				case KeyEvent.VK_RIGHT:
					keyRIGHT = true;
					break;


						case KeyEvent.VK_ESCAPE:
					gameOver = true;
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_UP:
					keyUp = false;
					break;
				case KeyEvent.VK_DOWN:
					keyDOWN = false;
					break;
				case KeyEvent.VK_LEFT:
					keyLEFT = false;
					break;
				case KeyEvent.VK_RIGHT:
					keyRIGHT = false;
					break;
			}
		}

	}

	/**
	 * The mouse handler.
	 */
	class MouseHandler extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			mousepress = true;
			mouseClick=true;

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mousepress = false;
			mouseClick = false;
			mouseReleas = true;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			mousepress=false;
			mouseClick=false;
		}

//		@Override
//		public void mouseClicked(MouseEvent e) {
//			if(e.getClickCount()==1)
//				mouseClick=true;
//		}
	}
}

