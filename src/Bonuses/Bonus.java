package Bonuses;
/**
 * this class is for bonuses and has fiels like
 * x,y,type,...
 *
 */
public abstract class Bonus {
    protected int x;
    protected int y;
    protected int type;
    protected int capacity;


    protected int toShowX;
    protected int toShowY;

    private boolean exist;
    /**
     * its constructor that set its position
     * @param x
     * @param y
     */
    public Bonus(int x, int y) {
        this.x = x;
        this.y = y;
        exist = true;
        updateToShow();
    }

    /**
     *  /**
     * whe bonus ate it set false
     */

    public void eat() {
        exist = false;
    }
    /**
     * to give rhe centre of image
     */
    private void updateToShow(){
        toShowX=x-25;
        toShowY=y-25;
    }
    /**
     * get its type
     * @return
     */
    public int getType() {
        return type;
    }
    /**
     * to return its capacity
     * @return
     */
    public int giveBonus(){
        return capacity;
    }
    /**
     * for getting toShowX
     * @return
     */
    public int getToShowX() {
        return toShowX;
    }
    /**
     * for getting toShowY
     * @return
     */
    public int getToShowY() {
        return toShowY;
    }
    /**
     * for getting exist
     * @return
     */
    public boolean isExist() {
        return exist;
    }
    /**
     * for getting X
     * @return
     */
    public int getX() {
        return x;
    }
    /**
     * for getting Y
     * @return
     */
    public int getY() {
        return y;
    }
}
