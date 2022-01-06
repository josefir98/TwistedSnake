package model;

public class MainFood {

    public int x;
    public int y;

    public void updateLocation(float factorX, float factorY) {
        x *= factorX;
        y *= factorY;
    }
}
