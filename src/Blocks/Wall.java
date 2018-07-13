package Blocks;

abstract public class Wall {
    protected int x;
    protected int y;

    protected int toShowX;
    protected int toShowY;

    protected int imageRadius;

    protected boolean exist;

    protected int type;

    public int getToShowX () {
        return toShowX;
    }

    public int getToShowY () {
        return toShowY;
    }

    public boolean isExist () {
        return exist;
    }

    public int getType () {
        return type;
    }

    public Wall (int x, int y) {
        this.x = x;
        this.y = y;
        exist = true;
    }

    public void calToShow () {
        toShowX = x - imageRadius;
        toShowY = y - imageRadius;
    }
}
