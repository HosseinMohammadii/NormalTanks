package Bullet;

public class LightBullet2 extends Bullet {
    public LightBullet2(int sourceX, int sourceY, int clickedX, int clickedY, long time) {
        super(sourceX, sourceY, clickedX, clickedY, time);
        super.damage=7;
        super.speed=16;
        super.radiusOfImage=11;
        super.type=12;
    }
}
