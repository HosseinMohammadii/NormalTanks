package EnemyTank;

import Bullet.EnemyHeavyBullet1;
import LogicGraphic.GameState;

public class EnemyDynamicTank extends EnemyTank {


    public EnemyDynamicTank(int x, int y, double lifeHardness) {
        super(x, y, lifeHardness);
        super.health=(int)(10*lifeHardness);
        areaDef=350;
        bulletShootSpeed=1000;
        //1000
        rotateSpeedRadius=2.75;
        //2.75
        rotateSpeedDegree=4.5;
        angleDeg=0;
        angleRad=0;
        radiusOfImage=50;
        areaDef2=100;
        type=1;
    }


@Override
public void updateStatus(double targetX, double targetY) {
    defineAndShoot(targetX,targetY);
}


    @Override
    public void updateStatus(double targetX,double targetY,double target2X,double target2Y) {
        if((Math.abs(x-targetX)*Math.abs(x-targetX)*Math.abs(y-targetY)*Math.abs(y-targetY))<=(Math.abs(x-target2X)*Math.abs(x-target2X)*Math.abs(y-target2Y)*Math.abs(y-target2Y))) {
            defineAndShoot(targetX, targetY);
        }
        else{
            defineAndShoot(target2X, target2Y);
        }
    }

    private void defineAndShoot(double target2X, double target2Y) {
        if ((x - areaDef < target2X && x + areaDef > target2X) && (y - areaDef < target2Y && y + areaDef > target2Y)) {
            if (!((x + areaDef2 > target2X && x - areaDef2 < target2X) && (y + areaDef2 > target2Y && y - areaDef2 < target2Y))) {
                calAngle(target2X, target2Y);
                updateAngle();
                updateByAngleDeg();
                updateToShow();
            }
            shoot((int) target2X, (int) target2Y);
        }
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
        toShowX = (int) (x-GameState.frameStartX+radiusOfImage*RADICAL2*Math.cos((angleDeg+225)*p/180));
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
