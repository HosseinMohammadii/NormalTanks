package EnemyTank;

import Bullet.EnemyHeavyBullet1;
import LogicGraphic.GameState;

public class EnemyStaticTank2 extends EnemyTank {
    public EnemyStaticTank2(int x, int y, double lifeHardness) {
        super(x, y, lifeHardness);
        super.health=(int)(10*lifeHardness);
        bulletShootSpeed=900;
        areaDef=400;
        radiusOfImage=50;
        type=12;
    }

    @Override
    public void updateStatus(double targetX, double targetY) {
        calAngle(targetX, targetY);
        if ((x - areaDef < targetX || x + areaDef > targetX) && (y - areaDef < targetY || y + areaDef < targetY)) {
            shoot((int)targetX,(int)targetY);
            updateToShow();
        }
    }

    @Override
    public void updateStatus(double targetX, double targetY, double target2X, double target2Y) {
        if((Math.abs(x-targetX)*Math.abs(x-targetX)*Math.abs(y-targetY)*Math.abs(y-targetY))<=(Math.abs(x-target2X)*Math.abs(x-target2X)*Math.abs(y-target2Y)*Math.abs(y-target2Y))) {
            defineAndShoot(targetX, targetY);
        }
        else{
            defineAndShoot(target2X, target2Y);
        }
    }
    private void defineAndShoot(double target2X, double target2Y) {
        calAngle(targetX, targetY);
        if ((x - areaDef < target2X && x + areaDef > target2X) && (y - areaDef < target2Y && y + areaDef > target2Y)) {
            shoot((int) target2X, (int) target2Y);
            updateToShow();

        }
    }

    private void calAngle(double clickedX,double clickedY){
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
            GameState.enemyBullets.add(new EnemyHeavyBullet1(x,y, targetX, targetY));
            lastBulletShootTime = System.currentTimeMillis();
        }
    }

    private void updateToShow(){
        toShowX = (int) (x-GameState.frameStartX+radiusOfImage*RADICAL2*Math.cos((angleDeg+225)*p/180));
        toShowY = (int) (y-GameState.frameStartY+radiusOfImage*RADICAL2*Math.sin((angleDeg+225)*p/180));
    }
}
