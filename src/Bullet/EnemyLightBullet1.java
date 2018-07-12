package Bullet;

public class EnemyLightBullet1 extends Bullet {
    public EnemyLightBullet1(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=6;
        super.speed=16;
        super.radiusOfImage=11;
        super.type=41;
    }
}

