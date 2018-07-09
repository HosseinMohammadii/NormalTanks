package Bullet;

public class HeavyBullet2 extends Bullet {

    public HeavyBullet2(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=20;
        super.speed=13;
        super.radiusOfImage=11;
    }
}
