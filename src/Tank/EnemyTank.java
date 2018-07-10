package Tank;
import LogicGraphic.*;
public class EnemyTank {

    protected double x;
    protected double y;
    protected int toShowX;
    protected int toShowY;
    protected double angleDeg;
    protected double angleRad;
    protected static final double p=Math.PI;
    protected static final double RADICAL2=Math.sqrt(2);
    protected double changeAngleAmount;
    protected double rotateSpeedDegree;
    protected double radiusOfImage;
    protected int speed;
    protected int prsentGun;
    protected int live;
    protected int heavyGunRemain;
    protected int LightGunRemain;
    protected int HeavyGunLevel;
    protected int LightGunLevel;
    private double rotateSpeedRadius;



    public void update(){
        updateAngle();
        x = Math.max(x, 0);
        x = Math.min(x, GameFrame.GAME_WIDTH - 50);
        y = Math.max(y, 0);
        y = Math.min(y, GameFrame.GAME_HEIGHT - 50);
        updateToShow();

    }
    private void updateAngle(){
        if(GameState.keyRIGHT&&GameState.keyUp){
            if(angleDeg==315){
                x += speed/RADICAL2;
                y -= speed/RADICAL2;

            }
            else if((angleDeg<=135)||(angleDeg>315)) {
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if((angleDeg>135)&&(angleDeg<315)){
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
        }

        else if(GameState.keyDOWN&&GameState.keyLEFT){
            if(angleDeg==135){
                x -= speed/RADICAL2;
                y += speed/RADICAL2;
            }
            else if((angleDeg<=315)&&(angleDeg>135)) {
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if((angleDeg>315)||(angleDeg<135)) {
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
        }
        else if(GameState.keyRIGHT&&GameState.keyDOWN){
            if(angleDeg==45) {
                x += speed/RADICAL2;
                y += speed/RADICAL2;
            }
            else if ((angleDeg<=225)&&(angleDeg>45)){
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if ((angleDeg>225)||(angleDeg<45)){
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
        }
        else if(GameState.keyLEFT&&GameState.keyUp){
            if(angleDeg==225) {
                x -= speed/RADICAL2;
                y -= speed/RADICAL2;
            }
            else if ((angleDeg<225)&&(angleDeg>=45)){
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if ((angleDeg>225)||(angleDeg<45)){
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
        }
        else if(GameState.keyRIGHT&&(!GameState.keyDOWN)&&(!GameState.keyUp)){
            if(angleDeg==0) {
                x += speed;
            }
            else if ((angleDeg<=180)&&(angleDeg>0)){
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if ((angleDeg>180)||(angleDeg<0)){
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
        }
        else if(GameState.keyLEFT&&!GameState.keyDOWN&&!GameState.keyUp){
            if(angleDeg==180) {
                x -= speed;
            }
            else if ((angleDeg<180)&&(angleDeg>=0)){
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if ((angleDeg>180)||(angleDeg<0)){
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
        }

        else if(GameState.keyUp&&!GameState.keyLEFT&&!GameState.keyRIGHT){
            if(angleDeg==270) {
                y -= speed;
            }
            else if ((angleDeg<=90)||(angleDeg>270)){
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if ((angleDeg>90)&&(angleDeg<270)){
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
        }

        else if(GameState.keyDOWN&&!GameState.keyLEFT&&!GameState.keyRIGHT){
            if(angleDeg==90) {
                y += speed;

            }
            else if ((angleDeg<90)||(angleDeg>=270)){
                angleDeg += rotateSpeedDegree;
                updateByAngleDeg();
            }
            else if ((angleDeg>90)&&(angleDeg<270)){
                angleDeg -= rotateSpeedDegree;
                updateByAngleDeg();
            }
        }
    }
    private void updateByAngleDeg(){
        if(angleDeg>=360)
            angleDeg-=360;
        if(angleDeg<0)
            angleDeg+=360;
        angleRad=(p*angleDeg)/180;
        x += rotateSpeedRadius*Math.cos(angleRad);
        y += rotateSpeedRadius*Math.sin(angleRad);
        System.out.println("DEGREE:  "+angleDeg);
    }
    private void updateToShow(){
        toShowX = (int) (x-GameState.frameStartX+radiusOfImage*RADICAL2*Math.cos((angleDeg+225)*p/180));
        toShowY = (int) (y-GameState.frameStartY+radiusOfImage*RADICAL2*Math.sin((angleDeg+225)*p/180));
    }

    public double getAngleRad() {
        return (angleDeg*p)/180;
    }

}
