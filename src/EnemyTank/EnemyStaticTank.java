package EnemyTank;

import Bullet.EnemyHeavyBullet1;
import LogicGraphic.GameState;

/**
 * this class is for EnemyStaticTank2
 * that is static and has
 * it's field
 */
public class EnemyStaticTank extends EnemyTank {
    /**
     * constructor of this class that give the buttom params
     *
     * @param x
     * @param y
     * @param lastBulletShootTime
     * @param lifeHardness
     */
    public EnemyStaticTank (int x, int y, long lastBulletShootTime, double lifeHardness) {
        super( x, y, lastBulletShootTime, lifeHardness );
        super.health = 10 * (int)lifeHardness;
        bulletShootSpeed = 900;
        areaDef = 400;
        radiusOfImage = 50;
    }

    /**
     * override this class from enemy tan class
     *
     * @param targetX
     * @param targetY
     */
    @Override
    public void updateStatus (double targetX, double targetY) {
        calAngle( (int)targetX, (int)targetY );
        if ((x - areaDef < targetX || x + areaDef > targetX) && (y - areaDef < targetY || y + areaDef < targetY)) {
            shoot( (int)targetX, (int)targetY );
            updateToShow();
        }
    }

    /**
     * * override this class from enemy tan class
     *
     * @param targetX
     * @param targetY
     * @param target2X
     * @param target2Y
     */
    @Override
    public void updateStatus (double targetX, double targetY, double target2X, double target2Y) {

    }

    /**
     * method to calculate the angle
     *
     * @param clickedX
     * @param clickedY
     */
    private void calAngle (int clickedX, int clickedY) {
        if (clickedX == x) {
            angleRad = Math.atan( (y - clickedY) / (x + 1 - clickedX) );
        } else {
            angleRad = Math.atan( (y - clickedY) / (x - clickedX) );
        }
        angleDeg = (180 * angleRad) / Math.PI;
        if (clickedX < x) angleDeg += 180;
    }

    /**
     * for handel the shootin of enemy tank
     *
     * @param targetX
     * @param targetY
     */
    private void shoot (int targetX, int targetY) {
        if (System.currentTimeMillis() >= (lastBulletShootTime + bulletShootSpeed)) {
            GameState.enemyBullets.add( new EnemyHeavyBullet1( x, y, targetX, targetY ) );
            lastBulletShootTime = System.currentTimeMillis();
        }
    }

    /**
     * update frame to show
     * calculate the
     * toShowX
     * and
     * toShowY
     */
    private void updateToShow () {
        toShowX = (int)(x - GameState.frameStartX + radiusOfImage * RADICAL2 * Math.cos( (angleDeg + 225) * p / 180 ));
        toShowY = (int)(y - GameState.frameStartY + radiusOfImage * RADICAL2 * Math.sin( (angleDeg + 225) * p / 180 ));
    }
}
