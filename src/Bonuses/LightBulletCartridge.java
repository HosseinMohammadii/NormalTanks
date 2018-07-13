package Bonuses;
//
public class LightBulletCartridge extends Bonus{
private int capacity;
    public LightBulletCartridge (int x, int y) {
        super( x, y );
        type=103;
        capacity=120;
    }
    public int giveBonus(){
        return capacity;
    }
}
