package Bonuses;

/**
 * this class is extends from Bonus class
 */
public class ExtraLive extends Bonus {
    /**
     * give position in its constructor
     * @param x
     * @param y
     */
    public ExtraLive(int x, int y) {
        super(x, y);
        type=101;
    }
}
