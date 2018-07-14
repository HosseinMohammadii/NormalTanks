package Blocks;
/**
 * this class is extends from wall
 */
public class HardWall extends Wall {
    /**
     * give position in its constructor
     * @param x
     * @param y
     */
    public HardWall (int x, int y) {
        super( x, y );
        imageRadius=50;
        type=202;

    }

    @Override
    public void hurt(int damage) {

    }
    //the size of height and width is 100

}
