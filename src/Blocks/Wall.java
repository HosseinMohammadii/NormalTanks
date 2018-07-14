package Blocks;

/**
 * the abstract class of wall that
 * all walls extends to it
 */
abstract public class Wall {
    protected int x;
    protected int y;

    protected int toShowX;
    protected int toShowY;

    protected int imageRadius;

    protected boolean exist;

    protected int type;

    /**
     * for getting thShowX
     * @return
     */
    public int getToShowX () {
        return toShowX;
    }
    /**
     * for getting thShowY
     * @return
     */
    public int getToShowY () {
        return toShowY;
    }

    /**
     * to check that it is exist or no
     * @return
     */
    public boolean isExist () {
        return exist;
    }

    /**
     * get type of wall
     * @return
     */
    public int getType () {
        return type;
    }

    /**
     * its constructor to getting position
     * @param x
     * @param y
     */
    public Wall (int x, int y) {
        this.x = x;
        this.y = y;
        exist = true;
    }

    /**
     * method to calling to show
     */
    public void calToShow () {
        toShowX = x - imageRadius;
        toShowY = y - imageRadius;
    }
}
