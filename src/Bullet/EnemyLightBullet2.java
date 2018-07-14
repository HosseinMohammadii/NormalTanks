package Bullet;
/**
 * this class is for light bullet of enemy
 * and extends from Bullet
 */
public class EnemyLightBullet2 extends Bullet {
    /**
     * * this constructor give the source position
     * and the position of place that click there
     * @param sourceX
     * @param sourceY
     * @param clickedX
     * @param clickedY
     */
    public EnemyLightBullet2(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=9;
        super.speed=16;
        super.radiusOfImage=11;
        super.type=42;
    }
}
