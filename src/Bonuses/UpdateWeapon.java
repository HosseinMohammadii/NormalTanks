package Bonuses;
/**
 * this class is extends from Bonus class
 */
public class UpdateWeapon extends Bonus {
    /**
     * give position in its constructor
     *
     * @param x
     * @param y
     */
    public UpdateWeapon (int x, int y) {
        super( x, y );
        type = 105;
    }
}

