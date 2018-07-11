package Tank;
import LogicGraphic.*;


public class Tank {
    protected double x;
    protected double y;
    protected int toShowX;
    protected int toShowY;
    protected double angleDeg;
    protected double angleRad;
    protected static final double p=Math.PI;
    protected static final double RADICAL2=Math.sqrt(2);
    protected double rotateSpeedDegree;
    protected double rotateSpeedRadius;
    protected double radiusOfImage;
    protected int speed;
    protected int presentGun;//1 for Heavy 2 for Light
    protected int health;
    protected boolean alive;
    protected int bonousLive;
    protected int heavyGunRemain;
    protected int lightGunRemain;
    protected int heavyGunLevel;
    protected int lightGunLevel;
    private int bulletShootSpeed;

    public Tank (int startX,int startY){
        alive=true;
        health=100;
        bonousLive=1;
        x=startX;
        y=startY;
        speed = 6;
        heavyGunRemain=10;
        lightGunRemain=100;
        heavyGunLevel=1;
        lightGunLevel=1;
        presentGun=1;
        updateBulletShootSpeed();
        //1 for Heavy 2 for Light

        rotateSpeedRadius=speed/4;
        angleDeg = 0;
        radiusOfImage=50;
        rotateSpeedDegree=4.5;

        //kjk
    }
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
    public void changeWeapon(){
        if(presentGun==1)
            presentGun=2;
        else
            presentGun=1;
        updateBulletShootSpeed();
    }

    public void upgradeWeapon(){
        if(presentGun==1)
            heavyGunLevel+=1;
        updateBulletShootSpeed();
    }
    private void updateBulletShootSpeed(){
        if(presentGun==1 && heavyGunLevel==1)
            bulletShootSpeed=600;
        if(presentGun==1 && heavyGunLevel==2)
            bulletShootSpeed=300;
        if(presentGun==2 && lightGunLevel==1)
            bulletShootSpeed=20;
        if(presentGun==2 && lightGunLevel==2)
            bulletShootSpeed=100;
    }

    public void shoot(){
        if(presentGun==1)
            heavyGunRemain--;
        if(presentGun==2)
            lightGunRemain--;

    }

    public void hurt(int damage){
        updateHealth(damage);
        updateLive();
    }

    private void updateHealth(int damage){
        health-=damage;
    }

    private void updateLive(){
        if(health<=0 && bonousLive >0){
            health=100;
            bonousLive--;
        }
        if(health<=0 && bonousLive <0)
            alive=false;
    }

    public double getAngleRad() {
        return (angleDeg*p)/180;
    }


    public int getToShowX() {
        return toShowX;
    }

    public int getToShowY() {
        return toShowY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getBulletShootSpeed(){
        return bulletShootSpeed;
    }

    public int getPresentGun() {
        return presentGun;
    }

    public int getHeavyGunRemain() {
        return heavyGunRemain;
    }

    public int getLightGunRemain() {
        return lightGunRemain;
    }

    public int getHeavyGunLevel() {
        return heavyGunLevel;
    }

    public int getLightGunLevel() {
        return lightGunLevel;
    }
}
