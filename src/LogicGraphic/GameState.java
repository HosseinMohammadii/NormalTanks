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
import Bonuses.*;
import Maps.*;
import Blocks.*;


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
    public static boolean keyUp, keyDOWN, keyRIGHT, keyLEFT,keyUpPer, keyDOWNPer, keyRIGHTPer, keyLEFTPer;
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
    public static int level;
    public static boolean easy = false;
    public static boolean normal = false;
    public static boolean hard = false;
    public static Map map;
    public static double hardness;
    public static ArrayList<Bullet> bullets;
    ArrayList<Bullet> bulletsPointers;
    public static ArrayList<Bullet>enemyBullets;
    ArrayList<Bullet>enemyBulletsPointer;
    public ArrayList<EnemyTank> enemyTanks;
     ArrayList<EnemyTank> enemyTanksPointer;
    public ArrayList<Tank> tanks;
    public ArrayList<Tank> tanksPointer;
    public ArrayList<Bonus> bonuses;
     ArrayList<Bonus> bonusesPointer;
    public ArrayList<Wall> walls;
     ArrayList<Wall> wallspointer;
    //public EnemyStaticTank ta=new EnemyStaticTank(600,600,System.currentTimeMillis(),1);
    public EnemyDynamicTank tat=new EnemyDynamicTank(20,500,1);


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
        enemyTanks = new ArrayList<>();
        enemyTanksPointer = new ArrayList<>();
        tanks=new ArrayList<>();
        tanksPointer = new ArrayList<>();
        bonuses = new ArrayList<>();
        bonusesPointer = new ArrayList<>();
        walls = new ArrayList<>();
        wallspointer = new ArrayList<>();
        level=1;
        solo=true;
        easy=true;
        tanks.add(new Tank(100,100));

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
        initMap();
        initObjects();
    }

    public void initMap () {
        if (level == 1 && easy)
            map = new MapOneEasy();
        if (level == 1 && normal)
            map = new MapOneNormal();
        if (level == 1 && hard)
            map = new MapOneHard();
        if (level == 2 && easy)
            map = new MapTwoEasy();
        if (level == 2 && normal)
            map = new MapTwoNormal();
        if (level == 2 && hard)
            map = new MapTwoHard();
        if(easy)
            hardness=1;
        if(normal)
            hardness=1.4;
        if(hard)
            hardness=1.8;
    }

    public void initObjects () {
        for (int j = 0; j < 30; j++) {
            for (int i = 0; i < 25; i++) {
                if (map.getNumbers()[i][j].equals( "9" ))
                    walls.add( new Ground( (i * 100) + 50, (j * 100) + 50 ) );
                if (map.getNumbers()[i][j].equals( "1" ))
                    walls.add( new SoftWall( (i * 100) + 50, (j * 100) + 50 ) );
                if (map.getNumbers()[i][j].equals( "2" ))
                    walls.add( new HardWall( (i * 100) + 50, (j * 100) + 50 ) );
                if (map.getNumbers()[i][j].equals( "3" ))
                    walls.add( new Plant( (i * 100) + 50, (j * 100) + 50 ) );
                if (map.getNumbers()[i][j].equals( "91" )) {
                    walls.add( new Ground( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new UpdateWeapon( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "92" )) {
                    walls.add( new Ground( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new HeavyBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "93" )) {
                    walls.add( new Ground( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new LightBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "94" )) {
                    walls.add( new Ground( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new ExtraLive( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "95" )) {
                    walls.add( new Ground( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new TankRepair( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "11" )) {
                    walls.add( new SoftWall( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new UpdateWeapon( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "12" )) {
                    walls.add( new SoftWall( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new HeavyBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "13" )) {
                    walls.add( new SoftWall( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new LightBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "14" )) {
                    walls.add( new SoftWall( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new ExtraLive( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "15" )) {
                    walls.add( new SoftWall( (i * 100) + 50, (j * 100) + 50 ) );
                    bonuses.add( new TankRepair( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "61" )) {
                    enemyTanks.add( new EnemyStaticTank( (i * 100) + 50, (j * 100) + 50 ,hardness));
                    bonuses.add( new UpdateWeapon( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "62" )) {
                    enemyTanks.add( new EnemyStaticTank((i * 100) + 50, (j * 100) + 50 ,hardness ));
                    bonuses.add( new HeavyBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "63" )) {
                    enemyTanks.add( new EnemyStaticTank((i * 100) + 50, (j * 100) + 50 ,hardness ));
                    bonuses.add( new LightBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "64" )) {
                    enemyTanks.add( new EnemyStaticTank((i * 100) + 50, (j * 100) + 50 ,hardness) );
                    bonuses.add( new ExtraLive( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "65" )) {
                    enemyTanks.add( new EnemyStaticTank( (i * 100) + 50, (j * 100) + 50 ,hardness ));
                    bonuses.add( new TankRepair( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "71" )) {
                    enemyTanks.add( new EnemyStaticTank2( (i * 100) + 50, (j * 100) + 50 ,hardness ));
                    bonuses.add( new UpdateWeapon( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "72" )) {
                    enemyTanks.add( new EnemyStaticTank2((i * 100) + 50, (j * 100) + 50 ,hardness ));
                    bonuses.add( new HeavyBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "73" )) {
                    enemyTanks.add( new EnemyStaticTank2((i * 100) + 50, (j * 100) + 50 ,hardness));
                    bonuses.add( new LightBulletCartridge( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "74" )) {
                    enemyTanks.add( new EnemyStaticTank2((i * 100) + 50, (j * 100) + 50 ,hardness ));
                    bonuses.add( new ExtraLive( (i * 100) + 50, (j * 100) + 50 ) );
                }
                if (map.getNumbers()[i][j].equals( "75" )) {
                    enemyTanks.add( new EnemyStaticTank2((i * 100) + 50, (j * 100) + 50 ,hardness));
                    bonuses.add( new TankRepair( (i * 100) + 50, (j * 100) + 50 ) );
                }
            }
        }
    }

    /**
     * The method which updates the game state.
     */
    public void update() {

        keyRIGHTPer = true;
        keyLEFTPer = true;
        keyUpPer = true;
        keyDOWNPer = true;

        mouseLiveX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseLiveY = MouseInfo.getPointerInfo().getLocation().getY();

        if (tanks.get(0).getToShowY() <= 300)
            frameStartY -= 300 - tanks.get(0).getToShowY();
        if (tanks.get(0).getToShowY() >= GameFrame.HEIGHT - 300)
            frameStartY += tanks.get(0).getToShowY() - (GameFrame.HEIGHT - 300);
        if (tanks.get(0).getToShowX() <= 300)
            frameStartX -= 300 - tanks.get(0).getToShowX();
        if (tanks.get(0).getToShowX() >= GameFrame.WIDTH - 300)
            frameStartX += tanks.get(0).getToShowX() - (GameFrame.WIDTH - 300);

        frameStartX = Math.max(frameStartX, 0);
        frameStartX = Math.min(frameStartX, map.getMapWidth() - GameFrame.WIDTH);
        frameStartY = Math.max(frameStartY, 0);
        frameStartY = Math.min(frameStartY, map.getMapHeight() - GameFrame.HEIGHT);

        if (leftMouseClick) {
            if (tanks.get(0).getPresentGun() == 1 && tanks.get(0).getHeavyGunRemain() > 0 && tanks.get(0).getHeavyGunLevel() == 1) {
                if (System.currentTimeMillis() >= (tanks.get(0).lastBulletShootTime + tanks.get(0).getBulletShootSpeed())) {
                    bullets.add(new HeavyBullet((int) tanks.get(0).getX(), (int) tanks.get(0).getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tanks.get(0).shoot();
                    tanks.get(0).lastBulletShootTime = System.currentTimeMillis();
                }
            } else if (tanks.get(0).getPresentGun() == 1 && tanks.get(0).getHeavyGunRemain() > 0 && tanks.get(0).getHeavyGunLevel() == 2) {
                if (System.currentTimeMillis() >= (tanks.get(0).lastBulletShootTime + tanks.get(0).getBulletShootSpeed())) {
                    bullets.add(new HeavyBullet2((int) tanks.get(0).getX(), (int) tanks.get(0).getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tanks.get(0).shoot();
                    tanks.get(0).lastBulletShootTime = System.currentTimeMillis();
                }
            } else if (tanks.get(0).getPresentGun() == 2 && tanks.get(0).getLightGunRemain() > 0 && tanks.get(0).getLightGunLevel() == 1) {
                if (System.currentTimeMillis() >= (tanks.get(0).lastBulletShootTime + tanks.get(0).getBulletShootSpeed())) {
                    bullets.add(new LightBullet((int) tanks.get(0).getX(), (int) tanks.get(0).getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tanks.get(0).shoot();
                    tanks.get(0).lastBulletShootTime = System.currentTimeMillis();
                }
            } else if (tanks.get(0).getPresentGun() == 2 && tanks.get(0).getLightGunRemain() > 0 && tanks.get(0).getLightGunLevel() == 2) {
                if (System.currentTimeMillis() >= (tanks.get(0).lastBulletShootTime + tanks.get(0).getBulletShootSpeed())) {
                    bullets.add(new LightBullet2((int) tanks.get(0).getX(), (int) tanks.get(0).getY(), (int) mouseLiveX, (int) mouseLiveY));
                    tanks.get(0).shoot();
                    tanks.get(0).lastBulletShootTime = System.currentTimeMillis();
                }
            }
        }
        if (enemyTanks.size() > 0){
            for (EnemyTank tank : enemyTanks) {
                for (Bullet bullet : bullets) {
                    if (tank.getX() - 30 < bullet.getX() && tank.getX() + 30 > bullet.getX() && tank.getY() - 30 < bullet.getY() && tank.getY() + 30 > bullet.getY()) {
                        tank.hurt(bullet.getDamage());
                        bullet.expire();
                    }
                }
            }
    }
        for(Tank tank: tanks) {
            for (Wall block : walls) {
                if ((block.getX() <= tank.getX() + 95) && (block.getY() <= tank.getY() + 95) && (block.getY() >= tank.getY() - 95))
                    keyRIGHTPer = false;
                else
                    keyRIGHTPer = true;
                if ((block.getX() >= tank.getX() - 95) && (block.getY() <= tank.getY() + 95) && (block.getY() >= tank.getY() - 95))
                    keyLEFTPer = false;
                else
                    keyLEFTPer = true;
                if ((block.getY() >= tank.getY() - 95) && (block.getX() <= tank.getX() + 95) && (block.getX() >= tank.getX() - 95))
                    keyUpPer = false;
                else
                    keyUpPer = true;
                if ((block.getY() <= tank.getY() + 95) && (block.getX() <= tank.getX() + 95) && (block.getX() >= tank.getX() - 95))
                    keyDOWNPer = false;
                else
                    keyDOWNPer = true;
            }
            if (enemyBullets.size() > 0){
                for (Bullet bullet : enemyBullets) {
                    if (tank.getX() - 30 < bullet.getX() && tank.getX() + 30 > bullet.getX() && tank.getY() - 30 < bullet.getY() && tank.getY() + 30 > bullet.getY()) {
                        tank.hurt(bullet.getDamage());
                        bullet.expire();
                    }
                }
            }

            if(bonuses.size()>0){
                for(Bonus bonus:bonuses) {
                    if (tank.getX() - 30 < bonus.getX() && tank.getX() + 30 > bonus.getX() && tank.getY() - 30 < bonus.getY() && tank.getY() + 30 > bonus.getY()) {
                        if (bonus.getType() == 101) {
                            tank.extraLive();
                            bonus.eat();
                        } else if (bonus.getType() == 102) {
                            tank.upgradeHeavyRemain(bonus.giveBonus());
                            bonus.eat();
                        } else if (bonus.getType() == 103) {
                            tank.upgradeLightRemain(bonus.giveBonus());
                            bonus.eat();
                        } else if (bonus.getType() == 104) {
                            tank.rapair();
                            bonus.eat();
                        } else if (bonus.getType() == 105) {
                            tank.upgradeWeapon();
                            bonus.eat();
                         }
                    }
                }
            }
        }

        for(Wall block : walls) {
            if (bullets.size() > 0){
                for (Bullet bullet : bullets) {
                    if (block.getType() == 201) {
                        if (block.getX() - 30 < bullet.getX() && block.getX() + 30 > bullet.getX() && block.getY() - 30 < bullet.getY() && block.getY() + 30 > bullet.getY()) {
                            block.hurt(bullet.getDamage());
                            bullet.expire();
                        }
                    }
                    if (block.getType() == 202) {
                        if (block.getX() - 30 < bullet.getX() && block.getX() + 30 > bullet.getX() && block.getY() - 30 < bullet.getY() && block.getY() + 30 > bullet.getY()) {
                            bullet.expire();
                        }
                    }
                }
            }
        }
        updateBulletsArray();
        updateEnemyBulletsArray();
        updateEnemyTanksArray();
        updateBonusesArray();
        updateWallsArray();



    }

    private void updateBulletsArray(){
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

    private void updateEnemyBulletsArray(){
        for (Bullet bullet : enemyBullets) {
            bullet.updateLoc();
            if (!bullet.isUsable()) {
                enemyBulletsPointer.add(bullet);
            }
        }
        for (Bullet pointer : enemyBulletsPointer) {
            enemyBullets.remove(pointer);
        }
        enemyBulletsPointer.clear();
    }

    private void updateEnemyTanksArray(){
        for(EnemyTank tank : enemyTanks){
            if(solo)
            tank.updateStatus(tanks.get(0).getX(),tanks.get(0).getY());
            if(co_op){
                tank.updateStatus(tanks.get(0).getX(),tanks.get(0).getY(),tanks.get(1).getX(),tanks.get(1).getY());
            }
            if(!tank.isAlive())
                enemyTanksPointer.add(tank);
        }
        for(EnemyTank tan:enemyTanksPointer)
            enemyTanks.remove(tan);
        enemyTanksPointer.clear();
    }

    private void updateBonusesArray(){
        for(Bonus bonus : bonuses){
            if(!bonus.isExist())
                bonusesPointer.add(bonus);
        }
        for(Bonus bonus : bonusesPointer){
                bonuses.remove(bonus);
        }
        bonusesPointer.clear();
    }

    private void updateWallsArray(){
        for(Wall block : walls){
            if(!block.isExist())
                wallspointer.add(block);
        }
        for(Wall block : wallspointer){
            walls.remove(block);
        }
        wallspointer.clear();
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
                case KeyEvent.VK_W:
                    if(keyUpPer)
                        keyUp = true;
                    break;
                case KeyEvent.VK_S:
                    if(keyDOWNPer)
                        keyDOWN = true;
                    break;
                case KeyEvent.VK_A:
                    if(keyLEFTPer)
                        keyLEFT = true;
                    break;
                case KeyEvent.VK_D:
                    if(keyRIGHTPer)
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
                case KeyEvent.VK_W:
                    keyUp = false;
                    break;
                case KeyEvent.VK_S:
                    keyDOWN = false;
                    break;
                case KeyEvent.VK_A:
                    keyLEFT = false;
                    break;
                case KeyEvent.VK_D:
                    if(keyRIGHTPer)
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

