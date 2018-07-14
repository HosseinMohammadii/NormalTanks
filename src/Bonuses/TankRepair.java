package Bonuses;
/**
 * this class is extends from Bonus class
 */
public class TankRepair extends Bonus{
//
    /**
     * give position in its constructor
     * @param x
     * @param y
     */
    public TankRepair (int x, int y) {
        super( x, y );
        type=104;
    }
}
