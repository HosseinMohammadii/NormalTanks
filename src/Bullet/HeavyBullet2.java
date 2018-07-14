package Bullet;

/**
 * this class is for heavy bullet of our tank
 * and extends from Bullet
 */
public class HeavyBullet2 extends Bullet {
    /**
     * * this constructor give the source position
     * and the position of place that click there
     * @param sourceX
     * @param sourceY
     * @param clickedX
     * @param clickedY
     */
    public HeavyBullet2(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=20;
        super.speed=13;
        super.radiusOfImage=11;
        super.type=2;
    }
}
