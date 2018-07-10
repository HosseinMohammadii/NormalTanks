package walls;

public class SoftWall {
    private int x;
    private int y;
    private int toShowX;
    private int toShowY;

    private int health;

    public SoftWall (int locLeft, int locUp, int health) {
        this.x = locLeft;
        this.y = locUp;
        this.health = health;
    }
    public void heathReducing(int health){
        health--;
    }

    public int getx () {
        return x;
    }

    public int gety () {
        return y;
    }

    public int getHealth () {
        return health;
    }
}
