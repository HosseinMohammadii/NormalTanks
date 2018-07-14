package Blocks;
/**
 * this class is extends from wall
 */
public class SoftWall extends Wall {

    private int health;

    /**
     * give position in its constructor
     * @param x
     * @param y
     */
    public SoftWall (int x, int y) {
        super( x, y );
        imageRadius = 50;
        health = 40;
        type=201;

    }

    /**
     * when shoot to soft wall its health reduce until it disappear
     * @param damage
     */
    public void healthReducing (int damage) {
        health = health - damage;
        if (health < 0)
            health = 0;
    }

    /**
     * for disappearing soft wall
     */
    private void update () {
        if (health == 0)
            exist = false;
    }
}
