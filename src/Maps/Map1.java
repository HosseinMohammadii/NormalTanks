package Maps;

import Blocks.HardWall;
import Blocks.Plant;
import Blocks.SoftWall;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map1 {
    private char[][] numbers = new char[20][30];
    public static ArrayList<HardWall> hardWalls;
    public static ArrayList<SoftWall> softWalls;
    public static ArrayList<Plant> plants;

    public static BufferedImage image0;
    public static BufferedImage image1;
    public static BufferedImage image2;

    public Map1 () {
        try {
            image0 = ImageIO.read(new File("Resources\\Images\\tank.png"));
        }
        catch(IOException e){
            System.out.println(e);
        }

        readFromFile();


    }

    public static void main (String[] args) {
        Map1 map1 = new Map1();
    }

    public void readFromFile () {

        int i = 0;
        int j = 0;
        File file = new File( "Resources\\Save\\Map1.txt" );
        Scanner input = null;
        try {
            input = new Scanner( file );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (input.hasNextLine()) {
            String a = input.nextLine();
            System.out.println(a);
            for (int k = 0; k < 39; k++) {
                numbers[i][j]=a.charAt( k );
                k++;
                i++;
            }
            i=0;
            j++;
        }



    }
}
