package EnemyTank;

/**
 * this class handle the behavior an all of things about
 * enemy tank
 * static and dynamic
 * both types
 */
public abstract class EnemyTank {

    protected int x;
    protected int y;
    protected int targetX;
    protected int targetY;
    protected int type;
    protected int toShowX;
    protected int toShowY;
    protected double angleDeg;
    protected double angleRad;
    protected int areaDef;
    protected int areaDef2;
    protected static final double p=Math.PI;
    protected static final double RADICAL2=Math.sqrt(2);
    protected double rotateSpeedDegree;
    protected double rotateSpeedRadius;
    protected double radiusOfImage;
    protected int speed;
    protected int health;
    protected boolean alive;
    protected int bulletShootSpeed;
    public long lastBulletShootTime;
    protected double requestAngleDeg;
    protected double requestAngleRad;

    /**
     * the constructor of this class that give
     * the buttom params
     * @param x
     * @param y
     * @param lastBulletShootTime
     * @param lifeHardness
     */
    public EnemyTank(int x, int y,long lastBulletShootTime,double lifeHardness) {
        this.x = x;
        this.y = y;
        this.lastBulletShootTime = lastBulletShootTime;
        alive=true;
    }

    /**
     * to update the status
     * @param targetX
     * @param targetY
     */
    public abstract void updateStatus(double targetX,double targetY);

    /**
     *
     * @param targetX
     * @param targetY
     * @param target2X
     * @param target2Y
     */
    public abstract void updateStatus(double targetX,double targetY,double target2X,double target2Y);

    /**
     * to handel that tank hurt
     * by bullet
     * @param damage
     */
    public void hurt(int damage){
        health-=damage;
        if(health<=0)
            alive=false;
    }


    /**
     * getter to get X
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * getter to get Y
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * getter to get targetX
     * @return
     */
    public int getTargetX() {
        return targetX;
    }

    /**
     * getter to show x
     * @return
     */
    public int getToShowX() {
        return toShowX;
    }

    /**
     * getter to show Y
     * @return
     */
    public int getToShowY() {
        return toShowY;
    }

    /**
     * getter to get radian of angle
     * @return
     */
    public double getAngleRad() {
        return (angleDeg*p)/180;
    }

    /**
     * getter to get deg of angle
     * @return
     */
    public double getAngleDeg() {
        return angleDeg;
    }

    /**
     * to return isAlive
     * @return
     */
    public boolean isAlive() {
        return alive;
    }


}
