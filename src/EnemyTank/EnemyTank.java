package EnemyTank;

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

    public EnemyTank(int x, int y,long lastBulletShootTime,double lifeHardness) {
        this.x = x;
        this.y = y;
        this.lastBulletShootTime = lastBulletShootTime;
        alive=true;
    }
    public abstract void updateStatus(double targetX,double targetY);

    public abstract void updateStatus(double targetX,double targetY,double target2X,double target2Y);

    public void hurt(int damage){
        health-=damage;
        if(health<=0)
            alive=false;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getToShowX() {
        return toShowX;
    }

    public int getToShowY() {
        return toShowY;
    }

    public double getAngleRad() {
        return (angleDeg*p)/180;
    }

    public double getAngleDeg() {
        return angleDeg;
    }

    public boolean isAlive() {
        return alive;
    }


}
