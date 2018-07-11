/*** In The Name of Allah ***/
package LogicGraphic;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Tank.Tank;


/**
 * This class holds the state of game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {

	private boolean mouseRelease;
	public static int locX, locY, diam;
	public static int frameStartX;
	public static int frameStartY;
	public boolean gameOver;
	public static boolean keyUp, keyDOWN, keyRIGHT, keyLEFT;
	public static boolean mousepress;
	private static boolean mouseClick;
	public static int mouseX, mouseY;
	private KeyHandler keyHandler;
	private MouseHandler mouseHandler;
	public double dgree;
	public double teta;
	private static final double p=Math.PI;
	public static Tank tank=new Tank(100,100);
	public static double mouseLiveX;
	public static double mouseLiveY;
	public static boolean solo = false;
	public static boolean co_op = false;

	public static boolean easy = false;
	public static boolean normal = false;
	public static boolean hard = false;


	public GameState() {
		locX = 100;
		locY = 100;
		frameStartX=0;
		frameStartY=0;
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
		mouseRelease = false;
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

		mouseLiveX = MouseInfo.getPointerInfo().getLocation().getX();
		mouseLiveY = MouseInfo.getPointerInfo().getLocation().getY();
		tank.update();

	}

	public static boolean isSolo() {
		return solo;
	}

	public static void setSolo(boolean solo) {
		GameState.solo = solo;
	}

	public static boolean isCo_op() {
		return co_op;
	}

	public static void setCo_op(boolean co_op) {
		GameState.co_op = co_op;
	}

	public static boolean isEasy() {
		return easy;
	}

	public static void setEasy(boolean easy) {
		GameState.easy = easy;
	}

	public static boolean isNormal() {
		return normal;
	}

	public static void setNormal(boolean normal) {
		GameState.normal = normal;
	}

	public static boolean isHard() {
		return hard;
	}

	public static void setHard(boolean hard) {
		GameState.hard = hard;
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

	public boolean isMouseRelease() {
		return mouseRelease;
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

			mousepress = true;

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mousepress = false;
			mouseRelease = true;
			mouseClick=false;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			mousepress=false;
			mouseClick=false;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1)
				mouseClick=true;

		}
	}
}

