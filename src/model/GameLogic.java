package model;

import java.util.Random;

public class GameLogic {

    public int screenWidth = 600;
    public int screenHeight = 600;
    public int unitSize = 25;
    public int gameUnits = (screenWidth * screenHeight) / (unitSize * unitSize);
    public int DELAY = 100;

    Random random = new Random();

    public Snake snake = new Snake(gameUnits,'R');
    public MainFood food = new MainFood();

    public void newFood() {
        food.x = random.nextInt((int) screenWidth / unitSize) * unitSize;
        food.y = random.nextInt((int) screenHeight / unitSize) * unitSize;
    }

    public void move() {
        for (int i = snake.bodyParts; i > 0; i--) {
            snake.x[i] = snake.x[i - 1];
            snake.y[i] = snake.y[i - 1];
        }

        switch (snake.direction) {
            case 'U':
                snake.y[0] -= unitSize;
                break;
            case 'D':
                snake.y[0] += unitSize;
                break;
            case 'L':
                snake.x[0] -= unitSize;
                break;
            case 'R':
                snake.x[0] += unitSize;
                break;
        }
    }

    public boolean checkCollisions() {
        //checks for collision with body
        for (int i = snake.bodyParts; i > 0; i--) {
            if (snake.x[0] == snake.x[i] && snake.y[0] == snake.y[i]) {
                return true;
            }
        }
        //checks for collision with walls
        if (snake.y[0] < 0) {
            return true;
        }
        if (snake.y[0] >= screenHeight) {
            return true;
        }
        if (snake.x[0] < 0) {
            return true;
        }
        if (snake.x[0] >= screenWidth) {
            return true;
        }
        return false;
    }

    public void checkFood() {
        if (snake.x[0] == food.x && snake.y[0] == food.y) {
            snake.bodyParts++;
            snake.foodEaten++;
            newFood();
        }
    }
}
