package Bullet;
import LogicGraphic.*;

/**
 * this class is for handling Bullets
 * and has fields like its position and damage
 */
public class Bullet {
    protected int speed;
    protected int x;
    protected int y;
    protected int damage;
    protected boolean isUsable;
    protected double angleRad;
    protected double angleDeg;
    protected int radius;
    protected double sourceX;
    protected double sourceY;
    protected int toShowX;
    protected int toShowY;
    protected int toCenterX;
    protected int toCenterY;
    protected double radiusOfImage;
    protected long time;
    protected int type;


    /**
     * this constructor give the source position
     * and the position of place that click there
     * @param sourceX
     * @param sourceY
     * @param clickedX
     * @param clickedY
     */
    public Bullet(int sourceX,int sourceY,int clickedX,int clickedY){
        isUsable=true;
        this.sourceX=sourceX;
        this.sourceY=sourceY;
        calAngle(clickedX,clickedY);
        radius=72;
        radiusOfImage=11*Math.sqrt(2);
        toCenter();
        speed=6;
    }

    private void calAngle(int clickedX,int clickedY){
        angleRad=Math.atan((sourceY-clickedY)/(sourceX-clickedX));
        angleDeg=(180*angleRad)/Math.PI;
        if(clickedX<=sourceX)
            angleDeg+=180;
        //System.out.println((sourceY-clickedY)+"||||"+(sourceX-clickedX)+"||||"+angle+"    "+angleDeg+"    "+sourceY+"    "+clickedY+"    "+sourceX+"    "+clickedX);

    }

    private void toCenter(){
        //+Math.PI*5/4
      toCenterX=  (int) (radiusOfImage*Math.cos((angleDeg+225)*Math.PI/180));
      toCenterY=  (int) (radiusOfImage*Math.sin((angleDeg+225)*Math.PI/180));
    }

    public void updateLoc(){
        x = (int) (this.sourceX-GameState.frameStartX+radius*Math.cos(angleDeg*Math.PI/180));
        y = (int) (this.sourceY-GameState.frameStartX+radius*Math.sin(angleDeg*Math.PI/180));
        toShowX=x+toCenterX;
        toShowY=y+toCenterY;
        radius+=speed;
        updateUsable();
    }

    private void updateUsable(){
        if((x>1296)||(y>730))
            isUsable=false;
    }

    public int expire(){
        isUsable=false;
        return damage;
    }

    /**
     * getter for speed
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * setter for speed
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * getter for x
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * setter for x
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter for Y
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * setter for y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter for damage
     * @return
     */
    public int getDamage() {
        return damage;
    }

    /**
     * to set damage
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * for getting isUsable
     * @return
     */
    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }

    /**
     * getter for angelRad
     * @return
     */
    public double getAngleRad() {
        return angleDeg*Math.PI/180;
    }

    public void setAngleRad(double angleRad) {
        this.angleRad = angleRad;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getSourceX() {
        return sourceX;
    }

    public void setSourceX(int sourceX) {
        this.sourceX = sourceX;
    }

    public double getSourceY() {
        return sourceY;
    }

    public void setSourceY(int sourceY) {
        this.sourceY = sourceY;
    }

    /**
     * getter for toShowX
     * @return
     */
    public int getToShowX() {
        return toShowX;
    }

    /**
     * setter for toShowX
     * @param toShowX
     */
    public void setToShowX(int toShowX) {
        this.toShowX = toShowX;
    }

    /**
     * getter for toShowY
     * @return
     */
    public int getToShowY() {
        return toShowY;
    }

    /**
     * setter for toShowY
     * @param toShowY
     */
    public void setToShowY(int toShowY) {
        this.toShowY = toShowY;
    }

    public int getToCenterX() {
        return toCenterX;
    }

    public void setToCenterX(int toCenterX) {
        this.toCenterX = toCenterX;
    }

    public int getToCenterY() {
        return toCenterY;
    }

    public void setToCenterY(int toCenterY) {
        this.toCenterY = toCenterY;
    }

    /**
     * getter for radiusOfImage
     * @return
     */
    public double getRadiusOfImage() {
        return radiusOfImage;
    }

    public double getAngleDeg() {
        return angleDeg;
    }

    /**
     * method for set radiusOfImage
     * @param radiusOfImage
     */
    public void setRadiusOfImage(int radiusOfImage) {
        this.radiusOfImage = radiusOfImage;
    }

    /**
     * getter for time
     * @return time
     */
    public long getTime() {
        return time;
    }

    /**
     * getter for type
     * @return type
     */
    public int getType() {
        return type;
    }
}
