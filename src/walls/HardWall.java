package walls;

public class HardWall {
    //the size of height and width is 100
    private int locLeft;
    private int locUp;

    public HardWall (int locLeft, int locUp) {
        this.locLeft = locLeft;
        this.locUp = locUp;
    }

    public int getLocLeft () {
        return locLeft;
    }
    public int getLocUp () {
        return locUp;
    }
}
