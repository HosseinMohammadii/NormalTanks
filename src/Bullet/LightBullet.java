package Bullet;

public class LightBullet extends Bullet {
    public LightBullet(int sourceX, int sourceY, int clickedX, int clickedY,long time) {
        super(sourceX, sourceY, clickedX, clickedY,time);
        super.damage=3;
        super.speed=16;
        super.radiusOfImage=11;
        super.type=11;
    }
}
