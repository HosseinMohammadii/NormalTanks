package EnemyTank;

import Bullet.*;
import LogicGraphic.*;

public class EnemyDynamicTank2 extends EnemyTank{

    public EnemyDynamicTank2(int x, int y, long lastBulletShootTime, double lifeHardness) {
        super(x, y, lastBulletShootTime, lifeHardness);
        health = 10 * (int) lifeHardness;
        areaDef=350;
        bulletShootSpeed=1000;
        rotateSpeedRadius=3.25;
        rotateSpeedDegree=4.5;
        angleDeg=0;
        angleRad=0;
        radiusOfImage=50;
        areaDef2=100;
    }

    @Override
    public void updateStatus(double targetX, double targetY) {
        if ((x - areaDef < targetX && x + areaDef > targetX) && (y - areaDef < targetY && y + areaDef > targetY)) {
            if ((x + areaDef2 > targetX && x - areaDef2 < targetX) && (y + areaDef2 > targetY && y - areaDef2 < targetY)) {
            }else{
                calAngle(targetX, targetY);
                updateAngle();
                updateByAngleDeg();
                updateToShow();
            }
            shoot((int) targetX, (int) targetY);
        }
    }

    @Override
    public void updateStatus(double targetX, double targetY, double target2X, double target2Y) {

    }

    private void calAngle(double targetX,double targetY){
//        if(targetX==x) {
//            requestAngleRad = Math.atan((y - targetY) / (x + 1 - targetX));
//        }
//        else{
        requestAngleRad = Math.atan((y - targetY) / (x - targetX));
//    }
        requestAngleDeg=180*requestAngleRad/Math.PI;
        if(targetX<=x)
            requestAngleDeg+=180;

    }

    public void updateAngle(){
        if(requestAngleDeg>=360)
            requestAngleDeg-=360;
        if(requestAngleDeg<0)
            requestAngleDeg+=360;
        if(angleDeg>=360)
            angleDeg-=360;
        if(angleDeg<0)
            angleDeg+=360;
        System.out.println(requestAngleDeg+"    "+angleDeg);
        if((requestAngleDeg>180 && angleDeg>180)||(requestAngleDeg<180 && angleDeg<=180)){
            if(requestAngleDeg>=angleDeg && Math.abs(requestAngleDeg-angleDeg)>4.5)
                angleDeg+=rotateSpeedDegree;
            else if(requestAngleDeg<angleDeg && Math.abs(requestAngleDeg-angleDeg)>4.5)
                angleDeg-=rotateSpeedDegree;
        }
        else if(requestAngleDeg>=180 && angleDeg<=180){
            if(angleDeg<requestAngleDeg-180 && Math.abs(requestAngleDeg-angleDeg)>4.5)
                angleDeg-=rotateSpeedDegree;
            else if(angleDeg>requestAngleDeg-180 && Math.abs(requestAngleDeg-angleDeg)>4.5)
                angleDeg+=rotateSpeedDegree;

        }
        else if(requestAngleDeg<=180 && angleDeg>=180){
            if(requestAngleDeg<angleDeg-180 && Math.abs(requestAngleDeg-angleDeg)>4.5)
                angleDeg+=rotateSpeedDegree;
            else if(requestAngleDeg>angleDeg-180 && Math.abs(requestAngleDeg-angleDeg)>4.5)
                angleDeg-=rotateSpeedDegree;

        }


    }

    private void updateByAngleDeg(){
        angleRad=(p*angleDeg)/180;
        x += rotateSpeedRadius*Math.cos(angleRad);
        y += rotateSpeedRadius*Math.sin(angleRad);

    }

    private void updateToShow(){
        toShowX = (int) (x- GameState.frameStartX+radiusOfImage*RADICAL2*Math.cos((angleDeg+225)*p/180));
        toShowY = (int) (y-GameState.frameStartY+radiusOfImage*RADICAL2*Math.sin((angleDeg+225)*p/180));
    }

    private void shoot(int targetX,int targetY){
        if (System.currentTimeMillis() >= (lastBulletShootTime + bulletShootSpeed)) {
            GameState.enemyBullets.add(new EnemyHeavyBullet1(x,y, targetX, targetY));
            lastBulletShootTime = System.currentTimeMillis();
        }
    }

    private void updateLoc(double targetX , double targetY){
        if(x-targetX>0)
            x-=2;
        else if (x-targetX<0)
            x+= 2;
        if(y-targetY>0)
            y-=2;
        else if(y-targetY<0)
            y+=2;
    }
}
