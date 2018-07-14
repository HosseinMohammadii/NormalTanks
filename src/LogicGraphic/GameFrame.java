/*** In The Name of Allah ***/
//yessssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
package LogicGraphic;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Blocks.*;
import Bonuses.*;
import Bullet.*;
import Tank.*;
import EnemyTank.*;

/**
 * The window on which the rendering is performed.
 * This example uses the modern BufferStrategy approach for double-buffering,
 * actually it performs triple-buffering!
 * For more information on BufferStrategy check out:
 *    http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 *    http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameFrame extends JFrame{

	public static final int GAME_HEIGHT = 730;                  // 720p game resolution
	public static final int GAME_WIDTH = 16 * GAME_HEIGHT / 9;  // wide aspect ratio

	//uncomment all /*...*/ in the class for using Tank icon instead of a simple circle
	private BufferedImage tankImage;
	private BufferedImage tankGunToopL1Image;
	private BufferedImage tankGunToopL2Image;
	private BufferedImage tankGunTirL1Image;
	private BufferedImage heavyBullet;
	private BufferedImage heavyBullet2;
	private BufferedImage lightBullet;
	private BufferedImage lightBullet2;
	private BufferedImage enemyStaticTank1;
	private BufferedImage enemyStaticTank1Gun;
	private BufferedImage enemyStaticTank2;
	private BufferedImage enemyStaticTank2Gun;
	private BufferedImage enemyDynamicTank1;
	private BufferedImage enemyDynamicTank1Gun;
	private BufferedImage enemyDynamicTank2;
	private BufferedImage enemyDynamicTank2Gun;
	private BufferedImage enemyHeavyBullet;
	private BufferedImage enemyHeavyBullet2;
	private BufferedImage enemyLightBullet2;
	private BufferedImage enemyLightBullet;
	private BufferedImage ground;
	private BufferedImage upgradeWeapon;
	private BufferedImage extraLive;
	private BufferedImage heavyBulletCartridge;
	private BufferedImage lightBulletCartridge;
	private BufferedImage repair;
	private BufferedImage hardWall;
	private BufferedImage plant;
	private BufferedImage softWall;

	private double a= 0;
	private double b= 0;
	private double c= 0;
	private double cc=0;
	private int aa;
	private int bb;
	private int aaa,bbb;


	private long lastRender;
	private ArrayList<Float> fpsHistory;

	private BufferStrategy bufferStrategy;



	public GameFrame(String title) {
		super(title);
		setResizable(false);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		lastRender = -1;
		fpsHistory = new ArrayList<>(100);

		try{
			tankImage = ImageIO.read(new File("Resources\\Images\\tank.png"));
			tankGunToopL1Image = ImageIO.read(new File("Resources\\Images\\tankGun01.png"));
			tankGunToopL2Image = ImageIO.read(new File("Resources\\Images\\tankGun1.png"));
			tankGunTirL1Image = ImageIO.read(new File("Resources\\Images\\tankGun2.png"));
			heavyBullet = ImageIO.read(new File("Resources\\Images\\HeavyBullet2.png"));
			lightBullet = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			heavyBullet2 = ImageIO.read(new File("Resources\\Images\\HeavyBullet2.png"));
			lightBullet2 = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyStaticTank1 = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyStaticTank1Gun = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyStaticTank2 = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyStaticTank2Gun = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyDynamicTank1 = ImageIO.read(new File("Resources\\Images\\E-100_strip2.png"));
			enemyDynamicTank1Gun = ImageIO.read(new File("Resources\\Images\\2.1.png"));
			enemyDynamicTank2 = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyDynamicTank2Gun = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyHeavyBullet= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyHeavyBullet2= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyLightBullet2= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			enemyLightBullet= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			ground = ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			upgradeWeapon= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			extraLive= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			heavyBulletCartridge= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			lightBulletCartridge= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			repair= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			hardWall= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			plant= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));
			softWall= ImageIO.read(new File("Resources\\Images\\LightBulletL1.png"));


		}
		catch(IOException e){
			System.out.println(e);
		}
	}

	/**
	 * This must be called once after the JFrame is shown:
	 *    frame.setVisible(true);
	 * and before any rendering is started.
	 */
	public void initBufferStrategy() {
		// Triple-buffering
		createBufferStrategy(3);
		bufferStrategy = getBufferStrategy();
	}


	/**
	 * Game rendering with triple-buffering using BufferStrategy.
	 */
	public void render(GameState state) {
		// Render single frame
		do {
			// The following loop ensures that the contents of the drawing buffer
			// are consistent in case the underlying surface was recreated
			do {
				// Get a new graphics context every time through the loop
				// to make sure the strategy is validated
				Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
				try {
					doRendering(graphics, state);
				} finally {
					// Dispose the graphics
					graphics.dispose();
				}
				// Repeat the rendering if the drawing buffer contents were restored
			} while (bufferStrategy.contentsRestored());

			// Display the buffer
			bufferStrategy.show();
			// Tell the system to do the drawing NOW;
			// otherwise it can take a few extra ms and will feel jerky!
			Toolkit.getDefaultToolkit().sync();

		// Repeat the rendering if the drawing buffer was lost
		} while (bufferStrategy.contentsLost());
	}

	/**
	 * Rendering all game elements based on the game state.
	 */
	private void doRendering(Graphics2D g2d, GameState state) {
		// Draw background
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);


		for(Wall block : state.walls){
			if(block.getType()==209)
				g2d.drawImage(ground,block.getToShowX(),block.getToShowY(),null);
		}

		if(state.bonuses.size()>0){
			for(Bonus bonus : state.bonuses){
				if(bonus.getType()==101)
					g2d.drawImage(extraLive,bonus.getToShowX(),bonus.getToShowY(),null);
				else if(bonus.getType()==102)
					g2d.drawImage(heavyBulletCartridge,bonus.getToShowX(),bonus.getToShowY(),null);
				else if(bonus.getType()==103)
					g2d.drawImage(lightBulletCartridge,bonus.getToShowX(),bonus.getToShowY(),null);
				else if(bonus.getType()==104)
					g2d.drawImage(repair,bonus.getToShowX(),bonus.getToShowY(),null);
				else if(bonus.getType()==105)
					g2d.drawImage(upgradeWeapon,bonus.getToShowX(),bonus.getToShowY(),null);
			}
		}

		for(Wall block : state.walls){
			if(block.getType()==202)
				g2d.drawImage(hardWall,block.getToShowX(),block.getToShowY(),null);
			else if(block.getType()==203)
				g2d.drawImage(plant,block.getToShowX(),block.getToShowY(),null);
			else if(block.getType()==201)
				g2d.drawImage(softWall,block.getToShowX(),block.getToShowY(),null);
		}
		for(Tank tank : state.tanks){
			AffineTransform backup = g2d.getTransform();
			AffineTransform trans = new AffineTransform();
			trans.rotate( tank.getAngleRad(), tank.getToShowX(), tank.getToShowY() ); // the points to rotate around (the center in my example, your left side for your problem)
			g2d.transform( trans );
			g2d.drawImage(tankImage,tank.getToShowX(),tank.getToShowY(),null);
			g2d.setTransform( backup );

			a=Math.atan((tank.getY()-GameState.mouseLiveY)/(tank.getX()-GameState.mouseLiveX));
			if(GameState.mouseLiveX<tank.getX())
				a+=Math.PI;
			aa= (int) (tank.getX()-GameState.frameStartX+35*Math.sqrt(2)*Math.cos(a+Math.PI*5/4));
			bb= (int) (tank.getY()-GameState.frameStartX+35*Math.sqrt(2)*Math.sin(a+Math.PI*5/4));

			AffineTransform backup2 = g2d.getTransform();
			AffineTransform trans2 = new AffineTransform();
			trans2.rotate( a, aa, bb ); // the points to rotate around (the center in my example, your left side for your problem)
			g2d.transform( trans2 );
			if(tank.getPresentGun()==1 && tank.getHeavyGunLevel()==1) {
				g2d.drawImage(tankGunToopL1Image, aa, bb, null);  // the actual location of the sprite
			}
			else if(tank.getPresentGun()==1 && tank.getHeavyGunLevel()==2) {
				g2d.drawImage(tankGunToopL2Image, aa, bb, null);  // the actual location of the sprite
			}
			else if(tank.getPresentGun()==2) {
				g2d.drawImage(tankGunTirL1Image, aa, bb, null);  // the actual location of the sprite
			}
			g2d.setTransform( backup2 );
		}

		if(state.enemyTanks.size()>0){
			for(EnemyTank tank : state.enemyTanks){
				AffineTransform backup2 = g2d.getTransform();
				AffineTransform trans2 = new AffineTransform();
				trans2.rotate( tank.getAngleRad(), tank.getToShowX(), tank.getToShowY() ); // the points to rotate around (the center in my example, your left side for your problem)
				g2d.transform( trans2 );
				if(tank.getType()==1) {
					g2d.drawImage(enemyDynamicTank1, tank.getToShowX(), tank.getToShowY(), null);  // the actual location of the sprite
				}
				else if(tank.getType()==2) {
					g2d.drawImage(enemyDynamicTank2, tank.getToShowX(), tank.getToShowY(), null);  // the actual location of the sprite
				}
				else if(tank.getType()==11) {
					g2d.drawImage(enemyStaticTank1, tank.getToShowX(), tank.getToShowY(), null);  // the actual location of the sprite
				}
				else if(tank.getType()==12) {
					g2d.drawImage(enemyStaticTank2, tank.getToShowX(), tank.getToShowY(), null);  // the actual location of the sprite
				}
				g2d.setTransform( backup2 );

			}
		}

		if(state.enemyBullets.size()>0) {
			for (Bullet bn : GameState.enemyBullets) {
				AffineTransform backup3 = g2d.getTransform();
				AffineTransform trans3 = new AffineTransform();
				trans3.rotate(bn.getAngleRad(), bn.getToShowX(), bn.getToShowY()); // the points to rotate around (the center in my example, your left side for your problem)
				g2d.transform(trans3);
				if(bn.getType()== 31 )
					g2d.drawImage(enemyHeavyBullet, bn.getToShowX(), bn.getToShowY(), null);
				else if(bn.getType()== 32 )
					g2d.drawImage(enemyHeavyBullet2, bn.getToShowX(), bn.getToShowY(), null);
				else if(bn.getType()== 41 )
					g2d.drawImage(enemyLightBullet, bn.getToShowX(), bn.getToShowY(), null);
				else if(bn.getType()== 42 )
					g2d.drawImage(enemyLightBullet2, bn.getToShowX(), bn.getToShowY(), null);
				g2d.setTransform(backup3);// restore previous transform
			}
		}

		if(state.bullets.size()>0) {
			for (Bullet bn : GameState.bullets) {
				AffineTransform backup2 = g2d.getTransform();
				AffineTransform trans2 = new AffineTransform();
				trans2.rotate(bn.getAngleRad(), bn.getToShowX(), bn.getToShowY()); // the points to rotate around (the center in my example, your left side for your problem)
				g2d.transform(trans2);
				if(bn.getType()== 1 )
					g2d.drawImage(heavyBullet, bn.getToShowX(), bn.getToShowY(), null);
				else if(bn.getType()== 2 )
					g2d.drawImage(heavyBullet2, bn.getToShowX(), bn.getToShowY(), null);
				else if(bn.getType()== 11 )
					g2d.drawImage(lightBullet, bn.getToShowX(), bn.getToShowY(), null);
				else if(bn.getType()== 12 )
					g2d.drawImage(lightBullet2, bn.getToShowX(), bn.getToShowY(), null);
				g2d.setTransform(backup2);// restore previous transform
			}
		}



		g2d.setRenderingHint(
				RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);


		// Print FPS info
		long currentRender = System.currentTimeMillis();
		if (lastRender > 0) {
			fpsHistory.add(1000.0f / (currentRender - lastRender));
			if (fpsHistory.size() > 100) {
				fpsHistory.remove(0); // remove oldest
			}
			float avg = 0.0f;
			for (float fps : fpsHistory) {
				avg += fps;
			}
			avg /= fpsHistory.size();
			String str = String.format("Average FPS = %.1f , Last Interval = %d ms",
					avg, (currentRender - lastRender));
			g2d.setColor(Color.CYAN);
			g2d.setFont(g2d.getFont().deriveFont(18.0f));
			int strWidth = g2d.getFontMetrics().stringWidth(str);
			int strHeight = g2d.getFontMetrics().getHeight();
			g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, strHeight+50);
		}
		lastRender = currentRender;
		// Print user guide
		String userGuide
				= "Use the MOUSE or ARROW KEYS to move the BALL. "
				+ "Press ESCAPE to end the game.";
		g2d.setFont(g2d.getFont().deriveFont(18.0f));
		g2d.drawString(userGuide, 10, GAME_HEIGHT - 10);
		// Draw GAME OVER
		if (state.gameOver) {
			String str = "GAME OVER";
			g2d.setColor(Color.WHITE);
			g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(64.0f));
			int strWidth = g2d.getFontMetrics().stringWidth(str);
			g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, GAME_HEIGHT / 2);
		}
	}
	
}
