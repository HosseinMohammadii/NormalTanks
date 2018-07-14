package Blocks;

public class SoftWall extends Wall {

    private int health;

    public SoftWall (int x, int y) {
        super( x, y );
        imageRadius = 50;
        health = 40;
        type=201;

    }

    @Override
    public void hurt(int damage) {
        health-=damage;
        if(health<=0)
            exist=false;
        update();
    }


    private void update () {
        if (health == 0)
            exist = false;
    }
}
