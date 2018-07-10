package blocks;

public class SoftWall extends Wall {

    private int health;

    public SoftWall (int x, int y) {
        super( x, y );
        imageRadius = 50;
        health = 40;
    }

    public void healthReducing (int damage) {
        health = health - damage;
        if (health < 0)
            health = 0;
    }

    private void update () {
        if (health == 0)
            exist = false;
    }
}
