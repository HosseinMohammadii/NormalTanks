package Bonuses;

import LogicGraphic.GameState;

//
public abstract class Bonus {
    protected int x;
    protected int y;
    protected int type;
    protected int capacity;


    protected int toShowX;
    protected int toShowY;

    private boolean exist;

    public Bonus(int x, int y) {
        this.x = x;
        this.y = y;
        exist = true;
        updateToShow();
    }

    public void eat() {
        exist = false;
    }
    private void updateToShow(){
        toShowX=x- GameState.frameStartX-25;
        toShowY=y- GameState.frameStartY-25;
    }

    public int getType() {
        return type;
    }

    public int giveBonus(){
        return capacity;
    }

    public int getToShowX() {
        return toShowX;
    }

    public int getToShowY() {
        return toShowY;
    }

    public boolean isExist() {
        return exist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
