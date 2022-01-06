package model;

public class Snake {

    public int[] x;
    public int[] y;
    public int bodyParts;
    public int foodEaten;
    public char direction;

    public void updateLocation(float factorX, float factorY) {
        for (int i = 0; i < bodyParts; i++) {
            x[i] *= factorX;
            y[i] *= factorY;
        }
    }
}
