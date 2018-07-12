package EnemyTank;
import Bullet.*;
import LogicGraphic.GameState;

public class EnemyStaticTank extends EnemyTank{

    public EnemyStaticTank(int x, int y, long lastBulletShootTime, double lifeHardness) {
        super(x, y, lastBulletShootTime, lifeHardness);
        super.health=10*(int)lifeHardness;
        bulletShootSpeed=900;
        areaDef=400;
        radiusOfImage=50;
    }


    public void updateStatus(int targetX, int targetY) {
        calAngle(targetX, targetY);
        if ((x - areaDef < targetX || x + areaDef > targetX) && (y - areaDef < targetY || y + areaDef < targetY)) {
            shoot(targetX,targetY);
            updateToShow();
        }
    }
    private void calAngle(int clickedX,int clickedY){
        if(clickedX==x) {
            angleRad = Math.atan((y - clickedY) / (x + 1 - clickedX));
        }
        else{
            angleRad=Math.atan((y-clickedY)/(x-clickedX));}
        angleDeg=(180*angleRad)/Math.PI;
        if(clickedX<x)
            angleDeg+=180;
    }

    private void shoot(int targetX,int targetY){
        if (System.currentTimeMillis() >= (lastBulletShootTime + bulletShootSpeed)) {
            GameState.bullets.add(new EnemyHeavyBullet1(x,y, targetX, targetY));
            lastBulletShootTime = System.currentTimeMillis();
        }
    }

    private void updateToShow(){
        toShowX = (int) (x-GameState.frameStartX+radiusOfImage*RADICAL2*Math.cos((angleDeg+225)*p/180));
        toShowY = (int) (y-GameState.frameStartY+radiusOfImage*RADICAL2*Math.sin((angleDeg+225)*p/180));
    }
}
