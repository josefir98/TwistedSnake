package model;

public class MainFood {

    public int x;
    public int y;

    public void updateLocation(int factor) {
        x *= factor;
        y *= factor;
    }
}
