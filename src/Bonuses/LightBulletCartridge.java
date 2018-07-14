package Bonuses;
//
/**
 * this class is extends from Bonus class
 */
public class LightBulletCartridge extends Bonus{
private int capacity;
    /**
     * give position in its constructor
     * @param x
     * @param y
     */
    public LightBulletCartridge (int x, int y) {
        super( x, y );
        type=103;
        capacity=120;
    }

    /**
     * to return its capacity
     * @return
     */
    public int giveBonus(){
        return capacity;
    }
}
