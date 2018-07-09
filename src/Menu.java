import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Menu implements MouseListener {
    public static boolean solo = false;
    public static boolean co_op = false;

    public static boolean easy = false;
    public static boolean normal = false;
    public static boolean hard = false;

    private JFrame startUp1;
    private JLabel SUP1;
    private Clip clip;

    private ImageIcon startImage0;
    private ImageIcon startImage1;
    private ImageIcon startImage2;


    public Menu () {
        initSU1();
    }

    public static void main (String[] args) {
        Menu menu = new Menu();
    }

    private void initSU1 () {
        startUp1 = new JFrame();
        SUP1 = new JLabel();
        startImage0 = new ImageIcon( "C:\\Users\\ES\\IdeaProjects\\Normal_Tanks\\Resources\\Images\\Startup0.png" );
        startImage1 = new ImageIcon( "C:\\Users\\ES\\IdeaProjects\\Normal_Tanks\\Resources\\Images\\Startup1.png" );
        startImage2 = new ImageIcon( "C:\\Users\\ES\\IdeaProjects\\Normal_Tanks\\Resources\\Images\\Startup2.png" );
        SUP1.setIcon( startImage0 );

        startUp1.add( SUP1 );

        playSound();

        startUp1.setSize( 970, 606 );
        SUP1.addMouseListener( this );
        startUp1.setVisible( true );
    }


    public void playSound () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( new File( "C:\\Users\\ES\\IdeaProjects\\Normal_Tanks\\Resources\\Sounds\\gameSound1.wav" ).getAbsoluteFile() );
            clip = AudioSystem.getClip();
            clip.open( audioInputStream );
            clip.start();

        } catch (Exception ex) {
            System.out.println( "Error with playing sound." );
            ex.printStackTrace();
        }
    }


    @Override
    public void mouseClicked (MouseEvent e) {
        if (e.getXOnScreen() > 100 && e.getXOnScreen() < 240 && e.getYOnScreen() > 240 && e.getYOnScreen() < 305 && SUP1.getIcon().equals( startImage0 )) {
            SUP1.setIcon( startImage1 );
            solo = true;

        }
        else if (e.getXOnScreen() > 100 && e.getXOnScreen() < 240 && e.getYOnScreen() > 315 && e.getYOnScreen() < 360 && SUP1.getIcon().equals( startImage0 )) {
            SUP1.setIcon(startImage1 );
            co_op = true;
        }

        else if (e.getXOnScreen() > 150 && e.getXOnScreen() < 300 && e.getYOnScreen() > 280 && e.getYOnScreen() < 315&& SUP1.getIcon().equals( startImage1 ) ) {
            SUP1.setIcon( startImage2 );
            easy = true;
        }
        else if (e.getXOnScreen() > 150 && e.getXOnScreen() < 300 && e.getYOnScreen() > 315 && e.getYOnScreen() < 360 && SUP1.getIcon().equals( startImage1 )) {
            SUP1.setIcon(startImage2 );
            normal = true;
        }
        else if (e.getXOnScreen() > 150 && e.getXOnScreen() < 300 && e.getYOnScreen() > 360 && e.getYOnScreen() < 400 && SUP1.getIcon().equals( startImage1 )) {
            SUP1.setIcon( startImage2);
            hard = true;
        }
        System.out.println( "solo  " + solo );
        System.out.println( "co_op  " + co_op );
        System.out.println( "easy  " + easy );
        System.out.println( "normal  " + normal );
        System.out.println( "hard  " + hard );
        System.out.println( "X  " + e.getXOnScreen() );
        System.out.println( "Y  " + e.getYOnScreen() );
    }


    @Override
    public void mousePressed (MouseEvent e) {

    }

    @Override
    public void mouseReleased (MouseEvent e) {

    }

    @Override
    public void mouseEntered (MouseEvent e) {
    }

    @Override
    public void mouseExited (MouseEvent e) {

    }

}
