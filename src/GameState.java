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
	
	public int locX, locY, diam;
	public boolean gameOver;
	
	private boolean keyUP, keyDOWN, keyRIGHT, keyLEFT;
	public boolean nw,ne,sw,se;
	public boolean mousePress;
	private int mouseX, mouseY;
	private int mouseXX, mouseYY;
	private KeyHandler keyHandler;
	private MouseHandler mouseHandler;
	public double teta;
	private static final double P=Math.PI;

	private InputStream soundin ;
	private AudioStream as ;
	
	public GameState() {
		locX = 100;
		locY = 100;
		diam = 0;
		gameOver = false;
		//
		keyUP = false;
		keyDOWN = false;
		keyRIGHT = false;
		keyLEFT = false;
		teta=0;
		//
		mousePress = false;
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
//		if (mousePress) {
//			locY = mouseY - diam / 2;
//			locX = mouseX - diam / 2;
//		}
		if (keyUP)
			locY -= 10;
		if (keyDOWN)
			locY += 10;
		if (keyLEFT)
			locX -= 10;
		if (keyRIGHT)
			locX += 10;

//		if(keyRIGHT&&keyUP){
//			if(teta==P*7/4){
//				locX += 4;
//				locY -= 4;
//
//			}
//			else if((teta<=P*3/4)&&(teta>P*7/4)) {
//				teta -= P / 64;
//				updateByTeta();
//			}
//			else if((teta>P*3/4)&&(teta<P*7/4)){
//				teta += P / 64;
//				updateByTeta();
//			}
//		}
//
//		else if(keyDOWN&&keyLEFT){
//			if(teta==P*3/4){
//				locX -= 7;
//				locY += 7;
//			}
//			else if((teta<=P*7/4)&&(teta>P*3/4)) {
//				teta -= P / 64;
//				updateByTeta();
//			}
//			else if((teta>P*7/4)&&(teta<P*3/4)) {
//				teta += P / 64;
//				updateByTeta();
//			}
//		}
//		else if(keyRIGHT&&keyDOWN){
//			if(teta==P/4) {
//				locX += 4;
//				locY += 4;
//			}
//			else if ((teta<=P*5/4)&&(teta>P/4)){
//				teta -= P/128;
//				updateByTeta();
//			}
//			else if ((teta>P*5/4)&&(teta<P/4)){
//				teta += P/64;
//				updateByTeta();
//			}
//		}
//		else if(keyLEFT&&keyUP){
//			if(teta==P*5/4) {
//				locX -= 4;
//				locY -= 4;
//			}
//			else if ((teta<P*5/4)&&(teta>=P/4)){
//				teta += P/64;
//				updateByTeta();
//			}
//			else if ((teta>P*5/4)&&(teta<P/4)){
//				teta -= P/64;
//				updateByTeta();
//			}
//		}
//		else if(keyRIGHT&&!keyDOWN&&!keyUP){
//			if(teta==0) {
//				locX += 10;
//			}
//			else if ((teta<=P)&&(teta==0)){
//				teta -= P/64;
//				updateByTeta();
//			}
//			else if ((teta>P)&&(teta<0)){
//				teta += P/64;
//				updateByTeta();
//			}
//		}
//		else if(keyLEFT&&!keyDOWN&&!keyUP){
//			if(teta==P) {
//				locX -= 10;
//			}
//			else if ((teta<P)&&(teta>=0)){
//				teta += P/64;
//				updateByTeta();
//			}
//			else if ((teta>P)&&(teta<0)){
//				teta -= P/64;
//				updateByTeta();
//			}
//		}
//
//		else if(keyUP&&!keyLEFT&&!keyRIGHT){
//			if(teta==P*3/2) {
//				locY -= 10;
//			}
//			else if ((teta<=P/2)&&(teta>P*3/2)){
//				teta -= P/64;
//				updateByTeta();
//			}
//			else if ((teta>P/2)&&(teta<P*3/2)){
//				teta += P/64;
//				updateByTeta();
//			}
//		}
//
//		else if(keyDOWN&&!keyLEFT&&!keyRIGHT){
//			if(teta==P/2) {
//				locY -= 10;
//
//			}
//			else if ((teta<P/2)&&(teta>=P*3/2)){
//				teta -= P/64;
//				updateByTeta();
//			}
//			else if ((teta>P/2)&&(teta<P*3/2)){
//				teta += P/64;
//				updateByTeta();
//			}
//		}
//		System.out.println("TETA: "+ teta);





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

	private void updateByTeta(){
		if(teta>=2*P)
			teta-=2*P;
		if(teta<0)
			teta+=2*P;
		locX += 1*Math.cos(teta);
		locY += 1*Math.sin(teta);
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
					keyUP = true;
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
					keyUP = false;
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
			mousePress = true;

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mousePress = false;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			mousePress=false;
		}
	}
}

