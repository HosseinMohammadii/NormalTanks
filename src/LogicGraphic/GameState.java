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
import java.util.ArrayList;

import Bullet.*;
import Tank.*;
import EnemyTank.*;


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
    public static boolean gameOver;
    public static boolean keyUp, keyDOWN, keyRIGHT, keyLEFT;
    public static boolean mousepress;
    public static boolean leftMouseClick;
    public static boolean rightMouseClick;
    private static boolean mouseClick;
    public static int mouseX, mouseY;
    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;
    public double dgree;
    public double teta;
    private static final double p = Math.PI;
    public static Tank tank = new Tank(100, 100);
    public static double mouseLiveX;
    public static double mouseLiveY;
    public static boolean solo = false;
    public static boolean co_op = false;

    public static boolean easy = false;
    public static boolean normal = false;
    public static boolean hard = false;
    public static ArrayList<Bullet> bullets;
    ArrayList<Bullet> bulletsPointers;
    public ArrayList<Bullet>enemyBullets;
    ArrayList<Bullet>enemyBulletsPointer;
    //public EnemyStaticTank ta=new EnemyStaticTank(600,600,System.currentTimeMillis(),1);
    public EnemyDynamicTank tat=new EnemyDynamicTank(600,600,System.currentTimeMillis(),1);


    public GameState() {
        locX = 100;
        locY = 100;
        frameStartX = 0;
        frameStartY = 0;
        diam = 0;
        gameOver = false;
        bullets = new ArrayList<>();
        bulletsPointers = new ArrayList<>();
        enemyBullets = new ArrayList<>();
        enemyBulletsPointer = new ArrayList<>();

        //
        keyUp = false;
        keyDOWN = false;
        keyRIGHT = false;
        keyLEFT = false;
        dgree = 0;
        
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
        tat.updateStatus((int)tank.getX(),(int)tank.getY());
        mouseLiveX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseLiveY = MouseInfo.getPointerInfo().getLocation().getY();
        tank.update();

        if(leftMouseClick){
            if (tank.getPresentGun() == 1 && tank.getHeavyGunRemain() > 0 && tank.getHeavyGunLevel() == 1) {
                if (System.currentTimeMillis() >= (tank.lastBulletShootTime + tank.getBulletShootSpeed())) {
                    bullets.add(new HeavyBullet((int) tank.getX(), (int) tank.getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tank.shoot();
                    tank.lastBulletShootTime = System.currentTimeMillis();
                }
            } else if (tank.getPresentGun() == 1 && tank.getHeavyGunRemain() > 0 && tank.getHeavyGunLevel() == 2) {
                if (System.currentTimeMillis() >= (tank.lastBulletShootTime + tank.getBulletShootSpeed())) {
                    bullets.add(new HeavyBullet2((int) tank.getX(), (int) tank.getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tank.shoot();
                    tank.lastBulletShootTime = System.currentTimeMillis();
                }
            } else if (tank.getPresentGun() == 2 && tank.getLightGunRemain() > 0 && tank.getLightGunLevel() == 1) {
                if (System.currentTimeMillis() >= (tank.lastBulletShootTime + tank.getBulletShootSpeed())) {
                    bullets.add(new LightBullet((int) tank.getX(), (int) tank.getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tank.shoot();
                    tank.lastBulletShootTime = System.currentTimeMillis();
                }
            } else if (tank.getPresentGun() == 2 && tank.getLightGunRemain() > 0 && tank.getLightGunLevel() == 2) {
                if (System.currentTimeMillis() >= (tank.lastBulletShootTime + tank.getBulletShootSpeed())) {
                    bullets.add(new LightBullet2((int) tank.getX(), (int) tank.getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tank.shoot();
                    tank.lastBulletShootTime = System.currentTimeMillis();
                }
            }
        }
        for (Bullet bullet : bullets) {
            bullet.updateLoc();
            if (!bullet.isUsable()) {
                bulletsPointers.add(bullet);
            }
        }
        for (Bullet pointer : bulletsPointers) {
            bullets.remove(pointer);
        }
        bulletsPointers.clear();


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

    public static void setGameOver(boolean gameOver) {
        GameState.gameOver = gameOver;
    }



    /**
     * The keyboard handler.
     */
    class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
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
            switch (e.getKeyCode()) {
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
            if (e.getButton() == MouseEvent.BUTTON1){
                leftMouseClick = true;

            }
            if (e.getButton() == MouseEvent.BUTTON3){
                rightMouseClick = true;
                tank.changeWeapon();
            }
            mousepress = true;

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mousepress = false;
            mouseRelease = true;
            mouseClick = false;
            leftMouseClick = false;
            rightMouseClick = false;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mousepress = false;
            mouseClick = false;
            if (e.getButton() == MouseEvent.BUTTON1){
                leftMouseClick = true;
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }


    }
}

