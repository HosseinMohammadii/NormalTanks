package Bonuses;
//
public abstract class Bonus {
    private int x;
    private int y;

    private int toShowX;
    private int toShowY;

    private boolean exist;

    public Bonus (int x, int y) {
        this.x = x;
        this.y = y;
        exist = true;
    }
}
