import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MapEditor implements ActionListener {
    public String numbers[][] = new String[25][30];
    private JFrame mapEditor;
    private JTextField num;
    private JButton ok;
    private JPanel xy;
    private JLabel xx;
    private JSpinner x;
    private JLabel yy;
    private JSpinner y;
    private JMenuBar help;
    private JMenu help1;
    private JMenuItem help2;

    public MapEditor () {
        initFrame();
        initHelp();
        initBtn();
        initNum();
        initXX();
        initYY();
        initX();
        initY();
        initXY();
        xy.add( xx );
        xy.add( x );
        xy.add( yy );
        xy.add( y );
        mapEditor.setJMenuBar( help );
        mapEditor.add( num );
        mapEditor.add( xy );
        mapEditor.add( ok );
        mapEditor.setVisible( true );
        mapEditor.setSize( 200, 150 );
        mapEditor.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }
    public void initFrame () {
        mapEditor = new JFrame( "Map Editor" );
        mapEditor.setLayout( new GridLayout( 3, 1 ) );
    }

    public void initHelp () {
        help = new JMenuBar();
        help1 = new JMenu( "HELP" );
        help2 = new JMenuItem( "GUIDE" );
        help2.addActionListener( this );
        help1.add( help2 );
        help.add( help1 );
    }

    public void initNum () {
        num = new JTextField();
    }

    public void initBtn () {
        ok = new JButton( "OK!" );
        ok.addActionListener( this );
    }

    public void initXY () {
        xy = new JPanel();
        xy.setLayout( new GridLayout( 1, 4 ) );
    }

    public void initXX () {
        xx = new JLabel( "  X:" );
    }

    public void initX () {
        SpinnerNumberModel p = new SpinnerNumberModel( 0, 0, 24, 1 );
        x = new JSpinner( p );
    }

    public void initYY () {
        yy = new JLabel( "  Y:" );
    }

    public void initY () {
        SpinnerNumberModel q = new SpinnerNumberModel( 0, 0, 29, 1 );
        y = new JSpinner( q );

    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == help2) {
            JFrame guide = new JFrame( "HELP!" );
            guide.setLayout( new GridLayout( 8, 1 ) );
            guide.setSize( 100, 200 );
            JLabel label1 = new JLabel( "8.........................................................your tank" );
            JLabel label2 = new JLabel( "1...........................................................soft wall" );
            JLabel label3 = new JLabel( "2..........................................................hard wall" );
            JLabel label4 = new JLabel( "4...................................................dynamic tank" );
            JLabel label5 = new JLabel( "6........................................................static tank" );
            JLabel label6 = new JLabel( "the map is 20*20 and you should choose" );
            JLabel label8 = new JLabel( "between num 0 and 19" );
            guide.add( label1 );
            guide.add( label2 );
            guide.add( label3 );
            guide.add( label4 );
            guide.add( label5 );
            guide.add( label6 );
            guide.add( label8 );
            guide.setVisible( true );
        }
        if (e.getSource() == ok) {
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 30; j++) {
                    if (numbers[i][j] == null)
                        numbers[i][j] = "9";
                }
            }
            numbers[(int)x.getValue()][(int)y.getValue()] = num.getText();
            String a = "";
            for (int j = 0; j < 30; j++) {
                for (int i = 0; i < 25; i++) {
                    a = a + numbers[i][j] + ",";
                }
                a = a + "\n";
            }
            try {
                FileWriter writer = new FileWriter("Resources\\Save\\MapManual.txt", false);
                writer.write(a);
                writer.close();
            } catch (IOException v) {
                v.printStackTrace();
            }

        }

    }
}
