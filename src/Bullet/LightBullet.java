package Bullet;

public class LightBullet extends Bullet {
    public LightBullet(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=4;
        super.speed=16;
        super.radiusOfImage=11;
    }
}
