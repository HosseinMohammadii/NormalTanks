package Bullet;

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
    protected int radiusOfImage;



    public Bullet(int sourceX,int sourceY,int clickedX,int clickedY){
        isUsable=true;
        this.sourceX=sourceX;
        this.sourceY=sourceY;
        calAngle(clickedX,clickedY);
        radius=72;
        radiusOfImage=11;

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
      toCenterX=  (int) (radiusOfImage*Math.sqrt(2)*Math.cos((angleDeg+225)*Math.PI/180));
      toCenterY=  (int) (radiusOfImage*Math.sqrt(2)*Math.sin((angleDeg+225)*Math.PI/180));
    }

    public void updateLoc(){
        x = (int) (this.sourceX+radius*Math.cos(angleDeg*Math.PI/180));
        y = (int) (this.sourceY+radius*Math.sin(angleDeg*Math.PI/180));
        toShowX=x+toCenterX;
        toShowY=y+toCenterY;
        radius+=speed;
        updateUsable();
    }

    private void updateUsable(){
        if((x>1296)||(y>730))
            isUsable=false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }

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

    public int getToShowX() {
        return toShowX;
    }

    public void setToShowX(int toShowX) {
        this.toShowX = toShowX;
    }

    public int getToShowY() {
        return toShowY;
    }

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

    public int getRadiusOfImage() {
        return radiusOfImage;
    }

    public double getAngleDeg() {
        return angleDeg;
    }

    public void setRadiusOfImage(int radiusOfImage) {
        this.radiusOfImage = radiusOfImage;
    }
}
