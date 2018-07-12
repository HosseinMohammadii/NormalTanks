package Bullet;

public class EnemyHeavyBullet2 extends Bullet{
    public EnemyHeavyBullet2(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=20;
        super.speed=11;
        super.radiusOfImage=11;
        super.type=32;
    }
}
