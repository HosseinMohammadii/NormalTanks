import LogicGraphic.GameState;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Menu implements MouseListener {

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
        startImage0 = new ImageIcon( "Resources\\Images\\Startup0.png" );
        startImage1 = new ImageIcon( "Resources\\Images\\Startup1.png" );
        startImage2 = new ImageIcon( "Resources\\Images\\Startup2.png" );
        SUP1.setIcon( startImage0 );

        startUp1.add( SUP1 );

        playSound();

        startUp1.setSize( 970, 606 );
        SUP1.addMouseListener( this );
        startUp1.setVisible( true );
    }


    public void playSound () {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( new File( "Resources\\Sounds\\gameSound1.wav" ).getAbsoluteFile() );
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
            GameState.setSolo(true);

        }
        else if (e.getXOnScreen() > 100 && e.getXOnScreen() < 240 && e.getYOnScreen() > 315 && e.getYOnScreen() < 360 && SUP1.getIcon().equals( startImage0 )) {
            SUP1.setIcon(startImage1 );
            GameState.setCo_op(true);
        }
        else if (e.getXOnScreen() > 100 && e.getXOnScreen() < 240 && e.getYOnScreen() > 360 && e.getYOnScreen() < 400 && SUP1.getIcon().equals( startImage0 )) {
            SUP1.setIcon(startImage1 );
            GameState.setMapEditor(true);
        }

        else if (e.getXOnScreen() > 150 && e.getXOnScreen() < 300 && e.getYOnScreen() > 280 && e.getYOnScreen() < 315&& SUP1.getIcon().equals( startImage1 ) ) {
            SUP1.setIcon( startImage2 );
            GameState.setEasy(true);
        }
        else if (e.getXOnScreen() > 150 && e.getXOnScreen() < 300 && e.getYOnScreen() > 315 && e.getYOnScreen() < 360 && SUP1.getIcon().equals( startImage1 )) {
            SUP1.setIcon(startImage2 );
            GameState.setNormal(true);
        }
        else if (e.getXOnScreen() > 150 && e.getXOnScreen() < 300 && e.getYOnScreen() > 360 && e.getYOnScreen() < 400 && SUP1.getIcon().equals( startImage1 )) {
            SUP1.setIcon( startImage2);
            GameState.setHard(true);
        }

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
