package Bullet;

public class HeavyBullet extends Bullet{
    public HeavyBullet(int sourceX, int sourceY, int clickedX, int clickedY,long time) {
        super(sourceX, sourceY, clickedX, clickedY,time);
        super.damage=10;
        super.speed=9;
        super.radiusOfImage=11;
        super.type=1;
    }


}
