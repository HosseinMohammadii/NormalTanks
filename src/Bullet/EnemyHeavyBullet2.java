package Bullet;
/**
 * this class is for heavy bullet of enemy
 * and extends from Bullet
 */
public class EnemyHeavyBullet2 extends Bullet{
    /**
     * * this constructor give the source position
     * and the position of place that click there
     * @param sourceX
     * @param sourceY
     * @param clickedX
     * @param clickedY
     */
    public EnemyHeavyBullet2(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=20;
        super.speed=11;
        super.radiusOfImage=11;
        super.type=32;
    }
}
