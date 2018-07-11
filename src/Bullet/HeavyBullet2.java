package Bullet;

public class HeavyBullet2 extends Bullet {

    public HeavyBullet2(int sourceX, int sourceY, int clickedX, int clickedY,long time) {
        super(sourceX, sourceY, clickedX, clickedY,time);
        super.damage=20;
        super.speed=13;
        super.radiusOfImage=11;
        super.type=2;
    }
}
