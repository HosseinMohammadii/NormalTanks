package EnemyTank;

import Bullet.*;
import LogicGraphic.*;
/**
 * this class is for EnemyDynamicTank2
 * that is synamic and has
 * it's field
 * and has dynamic fields
 */
public class EnemyDynamicTank2 extends EnemyTank{
    /**
     * constructor of this class that give the buttom params
     * @param x
     * @param y
     * @param lastBulletShootTime
     * @param lifeHardness
     */
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
    /**
     * override this class from enemy tan class
     * @param targetX
     * @param targetY
     */
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
    /**
     *      * override this class from enemy tan class
     * @param targetX
     * @param targetY
     * @param target2X
     * @param target2Y
     */
    @Override
    public void updateStatus(double targetX, double targetY, double target2X, double target2Y) {

    }

    /**
     * /**
     * method to calculate the angle
     * @param targetX
     * @param targetY
     */
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

    /**
     * method to update the angle
     * that have more if
     * and else if
     */
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

    /**
     * method to update by angel degree
     */
    private void updateByAngleDeg(){
        angleRad=(p*angleDeg)/180;
        x += rotateSpeedRadius*Math.cos(angleRad);
        y += rotateSpeedRadius*Math.sin(angleRad);

    }
    /**
     * update frame to show
     * calculate the
     * toShowX
     * and
     * toShowY
     */
    private void updateToShow(){
        toShowX = (int) (x- GameState.frameStartX+radiusOfImage*RADICAL2*Math.cos((angleDeg+225)*p/180));
        toShowY = (int) (y-GameState.frameStartY+radiusOfImage*RADICAL2*Math.sin((angleDeg+225)*p/180));
    }
    /**
     * for handel the shootin of enemy tank
     * @param targetX
     * @param targetY
     */
    private void shoot(int targetX,int targetY){
        if (System.currentTimeMillis() >= (lastBulletShootTime + bulletShootSpeed)) {
            GameState.enemyBullets.add(new EnemyHeavyBullet1(x,y, targetX, targetY));
            lastBulletShootTime = System.currentTimeMillis();
        }
    }
/**
 * method to update
 * the location of tank
 */
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
