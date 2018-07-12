package EnemyTank;

import Bullet.EnemyHeavyBullet1;
import LogicGraphic.GameState;

public class EnemyDynamicTank extends EnemyTank {
    private double requestAngleDeg;
    private double requestAngleRad;

    public EnemyDynamicTank(int x, int y, long lastBulletShootTime, double lifeHardness) {
        super(x, y, lastBulletShootTime, lifeHardness);
        health = 10 * (int) lifeHardness;
        areaDef=300;
        bulletShootSpeed=1000;
    }

    private void calAngle(int clickedX,int clickedY){
        if(clickedX==x) {
            requestAngleRad = Math.atan((y - clickedY) / (x + 1 - clickedX));
        }
        else{
            requestAngleRad=Math.atan((y-clickedY)/(x-clickedX));}
        requestAngleDeg=(180*angleRad)/Math.PI;
        if(clickedX<x)
            requestAngleDeg+=180;
    }

//    public void updateAngle() {
//        if (requestAngleDeg==315) {
//            if (angleDeg == 315) {
//                x += speed / RADICAL2;
//                y -= speed / RADICAL2;
//
//            } else if ((angleDeg <= 135) || (angleDeg > 315)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 135) && (angleDeg < 315)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        } else if (requestAngleDeg==135) {
//            if (angleDeg == 135) {
//                x -= speed / RADICAL2;
//                y += speed / RADICAL2;
//            } else if ((angleDeg <= 315) && (angleDeg > 135)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 315) || (angleDeg < 135)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        } else if (requestAngleDeg==45) {
//            if (angleDeg == 45) {
//                x += speed / RADICAL2;
//                y += speed / RADICAL2;
//            } else if ((angleDeg <= 225) && (angleDeg > 45)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 225) || (angleDeg < 45)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        } else if (requestAngleDeg==225) {
//            if (angleDeg == 225) {
//                x -= speed / RADICAL2;
//                y -= speed / RADICAL2;
//            } else if ((angleDeg < 225) && (angleDeg >= 45)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 225) || (angleDeg < 45)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        } else if (requestAngleDeg==0) {
//            if (angleDeg == 0) {
//                x += speed;
//            } else if ((angleDeg <= 180) && (angleDeg > 0)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 180) || (angleDeg < 0)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        } else if (requestAngleDeg==180) {
//            if (angleDeg == 180) {
//                x -= speed;
//            } else if ((angleDeg < 180) && (angleDeg >= 0)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 180) || (angleDeg < 0)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        } else if (requestAngleDeg==270) {
//            if (angleDeg == 270) {
//                y -= speed;
//            } else if ((angleDeg <= 90) || (angleDeg > 270)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 90) && (angleDeg < 270)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        } else if (requestAngleDeg==90) {
//            if (angleDeg == 90) {
//                y += speed;
//
//            } else if ((angleDeg < 90) || (angleDeg >= 270)) {
//                angleDeg += rotateSpeedDegree;
//                updateByAngleDeg();
//            } else if ((angleDeg > 90) && (angleDeg < 270)) {
//                angleDeg -= rotateSpeedDegree;
//                updateByAngleDeg();
//            }
//        }
//    }
public void updateStatus(int targetX, int targetY) {
    if ((x - areaDef < targetX || x + areaDef > targetX) && (y - areaDef < targetY || y + areaDef < targetY)) {
        calAngle(targetX, targetY);
        updateAngle();
        updateByAngleDeg();
        shoot(targetX,targetY);
        updateToShow();

    }
}

    private void shoot(int targetX,int targetY){
        if (System.currentTimeMillis() >= (lastBulletShootTime + bulletShootSpeed)) {
            GameState.bullets.add(new EnemyHeavyBullet1(x,y, targetX, targetY));
            lastBulletShootTime = System.currentTimeMillis();
        }
    }
    public void updateAngle(){
        if(requestAngleDeg-angleDeg<180)
            angleDeg-=rotateSpeedDegree;
        else if(requestAngleDeg-angleDeg>180)
            angleDeg-=rotateSpeedDegree;

    }

    private void updateByAngleDeg(){
        angleRad=(p*angleDeg)/180;
        x += rotateSpeedRadius*Math.cos(angleRad);
        y += rotateSpeedRadius*Math.sin(angleRad);
    }
    private void updateToShow(){
        toShowX = (int) (x-GameState.frameStartX+radiusOfImage*RADICAL2*Math.cos((angleDeg+225)*p/180));
        toShowY = (int) (y-GameState.frameStartY+radiusOfImage*RADICAL2*Math.sin((angleDeg+225)*p/180));
    }
}
