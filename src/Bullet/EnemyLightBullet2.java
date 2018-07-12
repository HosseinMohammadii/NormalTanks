package Bullet;

public class EnemyLightBullet2 extends Bullet {
    public EnemyLightBullet2(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=9;
        super.speed=16;
        super.radiusOfImage=11;
        super.type=42;
    }
}
