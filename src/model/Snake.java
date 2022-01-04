package model;

public class Snake {

    public int[] x;
    public int[] y;
    public int bodyParts;
    public int foodEaten;
    public char direction;

    public void updateLocation(int factorX, int factorY) {
        for (int i = 0; i < bodyParts; i++) {
            x[i] *= factorX;
            y[i] *= factorY;
        }
    }
}
