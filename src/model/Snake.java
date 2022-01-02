package model;

public class Snake {

    public int[] x;
    public int[] y;
    public int bodyParts = 6;
    public int foodEaten;
    public char direction;

    public Snake(int maxParts, char startDirection) {
        this.x = new int[maxParts];
        this.y = new int[maxParts];
        this.direction = startDirection;
    }
}
