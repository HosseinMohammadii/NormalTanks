package Bullet;

public class HeavyBullet extends Bullet{
    public HeavyBullet(int sourceX, int sourceY, int clickedX, int clickedY) {
        super(sourceX, sourceY, clickedX, clickedY);
        super.damage=10;
        super.speed=9;
        super.radiusOfImage=11;
    }


}
