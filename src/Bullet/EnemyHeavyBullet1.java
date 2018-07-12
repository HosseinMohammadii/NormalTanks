package Bullet;

public class EnemyHeavyBullet1 extends Bullet {
    public EnemyHeavyBullet1(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=10;
        super.speed=4;
        super.radiusOfImage=11;
        super.type=31;
    }
}
