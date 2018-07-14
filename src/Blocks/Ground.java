package Blocks;

/**
 * this class is extends from wall
 */
public class Ground extends Wall {
    /**
     * give position in its constructor
     * @param x
     * @param y
     */
    public Ground (int x, int y) {
        super( x, y );
        type=209;
    }

    @Override
    public void hurt(int damage) {

    }
}
