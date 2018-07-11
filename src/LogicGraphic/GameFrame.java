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
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicTreeUI;
import Bullet.Bullet;
import Bullet.HeavyBullet;
import Tank.Tank;

import static javax.swing.plaf.basic.BasicTreeUI.*;

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
	private BufferedImage bullet;
	private double a= 0;
	private double b= 0;
	private double c= 0;
	private double cc=0;
	private int aa;
	private int bb;
	private int aaa,bbb;
	private int aaaa , bbbb;
	int hh,jj,kk,ll;
	private boolean tirAlive=false;
	private int tirX;
	private int tirY;
	private ArrayList<Bullet> bs=new ArrayList<>();
	int d;

	Bullet bn;
	String Test=".";

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
			bullet = ImageIO.read(new File("Resources\\Images\\HeavyBullet2.png"));
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
		// Draw ball

		AffineTransform backup1 = g2d.getTransform();
		AffineTransform trans1 = new AffineTransform();
		trans1.rotate( state.tank.getAngleRad(), state.tank.getToShowX(), state.tank.getToShowY() ); // the points to rotate around (the center in my example, your left side for your problem)
		g2d.transform( trans1 );
		g2d.drawImage( tankImage, state.tank.getToShowX(), state.tank.getToShowY(),null );  // the actual location of the sprite
		g2d.setTransform( backup1 ); // restore previous transform






        System.out.println(GameState.mouseLiveX+"     "+GameState.mouseLiveY);
		a=Math.atan((state.tank.getY()-GameState.mouseLiveY)/(state.tank.getX()-GameState.mouseLiveX));
		if(GameState.mouseLiveX<state.tank.getX())
			a+=Math.PI;
		aa= (int) (state.tank.getX()+33*Math.sqrt(2)*Math.cos(a+Math.PI*5/4));
		bb= (int) (state.tank.getY()+33*Math.sqrt(2)*Math.sin(a+Math.PI*5/4));

		AffineTransform backup = g2d.getTransform();
		AffineTransform trans = new AffineTransform();
		trans.rotate( a, aa, bb ); // the points to rotate around (the center in my example, your left side for your problem)
		g2d.transform( trans );
		g2d.drawImage( tankGunToopL1Image, aa, bb,null );  // the actual location of the sprite
		g2d.setTransform( backup ); // restore previous transform


		if (state.isMouseClick()){
			bs.add(new HeavyBullet((int)GameState.tank.getX(),(int)GameState.tank.getY(),(int)GameState.mouseLiveX,(int)GameState.mouseLiveY));
			//bs.remove(bs.size()-1);
			System.out.println("new bullet added"+bs.size());
			hh=(int)state.tank.getX();
			jj=(int)state.tank.getY();
			kk=state.getMouseX();
			ll=state.getMouseY();
			tirAlive=true;
			//System.out.println(bn.getAngleDeg());
		}

		if(tirAlive) {
			//Iterator<Bullet> bss=new Iterator<>();
			 for(Bullet bn : bs) {
//				if(!bn.isUsable()){
//					bs.remove(bn);
//					continue first;
//				}
				AffineTransform backup2 = g2d.getTransform();
				AffineTransform trans2 = new AffineTransform();
				trans2.rotate(bn.getAngleRad(), bn.getToShowX(), bn.getToShowY()); // the points to rotate around (the center in my example, your left side for your problem)
				g2d.transform(trans2);
				g2d.drawImage(bullet, bn.getToShowX(), bn.getToShowY(), null);  // the actual location of the sprite
				g2d.setTransform(backup2);// restore previous transform
				bn.updateLoc();
				g2d.setColor(Color.CYAN);
				g2d.setFont(g2d.getFont().deriveFont(100.0f));
				g2d.drawString(Test, hh, jj);
				g2d.setFont(g2d.getFont().deriveFont(100.0f));
				g2d.drawString(Test, kk, ll);
				g2d.setFont(g2d.getFont().deriveFont(100.0f));
				g2d.drawString(Test, aaa, bbb);
				//System.out.println(hh+"   "+jj);
				//System.out.println(kk+"   "+ll);
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
