package walls;

public class SoftWall {
    private int locLeft;
    private int locUp;

    private int health;

    public SoftWall (int locLeft, int locUp, int health) {
        this.locLeft = locLeft;
        this.locUp = locUp;
        this.health = health;
    }
    public void heathReducing(int health){
        health--;
    }

    public int getLocLeft () {
        return locLeft;
    }

    public int getLocUp () {
        return locUp;
    }

    public int getHealth () {
        return health;
    }
}
