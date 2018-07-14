package EnemyTank;

/**
 * the mother class of enemy tank
 * that all extends to it
 */
public abstract class EnemyTank {

    protected static final double p = Math.PI;
    protected static final double RADICAL2 = Math.sqrt( 2 );
    public long lastBulletShootTime;
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
    protected double rotateSpeedDegree;
    protected double rotateSpeedRadius;
    protected double radiusOfImage;
    protected int speed;
    protected int health;
    protected boolean alive;
    protected int bulletShootSpeed;
    protected double requestAngleDeg;
    protected double requestAngleRad;

    /**
     * constructor of this class that give the buttom params
     *
     * @param x
     * @param y
     * @param lastBulletShootTime
     * @param lifeHardness
     */
    public EnemyTank (int x, int y, long lastBulletShootTime, double lifeHardness) {
        this.x = x;
        this.y = y;
        this.lastBulletShootTime = lastBulletShootTime;
        alive = true;
    }

    /**
     * override this class from enemy tan class
     *
     * @param targetX
     * @param targetY
     */
    public abstract void updateStatus (double targetX, double targetY);

    /**
     * override this class from enemy tan class
     *
     * @param targetX
     * @param targetY
     */
    public abstract void updateStatus (double targetX, double targetY, double target2X, double target2Y);

    /**
     * to handel the hurt of tank
     *
     * @param damage
     */
    public void hurt (int damage) {
        health -= damage;
        if (health <= 0) alive = false;
    }


    /**
     * method to get X
     *
     * @return
     */
    public int getX () {
        return x;
    }

    /**
     * method to get Y
     *
     * @return
     */
    public int getY () {
        return y;
    }

    /**
     * method to get target
     *
     * @return
     */
    public int getTargetX () {
        return targetX;
    }

    /**
     * to get toShowX
     *
     * @return
     */
    public int getToShowX () {
        return toShowX;
    }

    /**
     * metjod to get toShowY
     *
     * @return
     */
    public int getToShowY () {
        return toShowY;
    }

    /**
     * real method to get deg of angel
     *
     * @return
     */
    public double getAngleRad () {
        return (angleDeg * p) / 180;
    }

    /**
     * method to get deg of angel
     *
     * @return
     */
    public double getAngleDeg () {
        return angleDeg;
    }

    /**
     * method to get alive
     *
     * @return
     */
    public boolean isAlive () {
        return alive;
    }


}
