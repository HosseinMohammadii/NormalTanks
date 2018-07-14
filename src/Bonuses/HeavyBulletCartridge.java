package Bonuses;
//
/**
 * this class is extends from Bonus class
 */
public class HeavyBulletCartridge extends Bonus {

    /**
     * give position in its constructor
     * @param x
     * @param y
     */
    public HeavyBulletCartridge (int x, int y) {
        super( x, y );
        type=102;
        capacity=60;
    }


}
