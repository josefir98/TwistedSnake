package model;

public class MainFood {

    public int x;
    public int y;

    public void updateLocation(int factorX, int factorY) {
        x *= factorX;
        y *= factorY;
    }
}
