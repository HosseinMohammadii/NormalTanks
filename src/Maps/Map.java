package Maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    protected String[][] numbers = new String[25][30];
    protected String address;


    public Map (String address) {

        readFromFile( address );


    }

    public static void main (String[] args) {
        Map map = new Map( "Resources\\Save\\Map1Normal.txt" );
    }

    public void readFromFile (String address) {

        int i = 0;
        int j = 0;
//        "Resources\\Save\\Map1.txt"
        File file = new File( address );
        Scanner input = null;
        try {
            input = new Scanner( file );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String a = "";
        while (input.hasNextLine()) {
            a =  a + input.nextLine();
            System.out.println( a );

        }
        String[] b = a.split( "," );
        for (int k = 0; k < b.length; k++) {
            System.out.println( b[k] );
        }
        System.out.println(b.length);
        for (int k = 0; k < b.length; k++) {

            if(i==25)
                i=0;
            j = k / 25;
            numbers[i][j] = b[k];
            i++;
        }
        for (int k = 0; k <30 ; k++) {
            for (int l = 0; l <25 ; l++) {
                System.out.print( numbers[l][k] );
            }
            System.out.println();
        }

    }

}
