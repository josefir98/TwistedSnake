package model;

import java.util.Random;

public class GameLogic {

    public int screenWidth;
    public int screenHeight;
    public int unitRatio;
    public int unitSize;
    public int gameUnits;

    public int DELAY = 1000;

    Random random = new Random();

    Snake snake;
    MainFood food;

    public GameLogic(int width, int height, int unitRatio, Snake snake, MainFood food) {
        this.screenWidth = width;
        this.screenHeight = height;
        this.unitRatio = unitRatio;
        unitSize = width / unitRatio;
        gameUnits = (width * height) / (unitSize * unitSize);

        this.snake = snake;
        this.snake.x = new int[gameUnits];
        this.snake.y = new int[gameUnits];
        this.snake.bodyParts = 6;
        this.snake.direction = 'R';
        this.food = food;
    }

    public void newFood() {
        food.x = random.nextInt(screenWidth / unitSize) * unitSize;
        food.y = random.nextInt(screenHeight / unitSize) * unitSize;
    }

    public void move() {
        for (int i = snake.bodyParts; i > 0; i--) {
            snake.x[i] = snake.x[i - 1];
            snake.y[i] = snake.y[i - 1];
        }

        switch (snake.direction) {
            case 'U' -> snake.y[0] -= unitSize;
            case 'D' -> snake.y[0] += unitSize;
            case 'L' -> snake.x[0] -= unitSize;
            case 'R' -> snake.x[0] += unitSize;
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
        } else if (snake.y[0] >= screenHeight) {
            return true;
        } else if (snake.x[0] < 0) {
            return true;
        } else if (snake.x[0] >= screenWidth) {
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

    public void sizeAdjust(int width, int height) {
        float factorX = (float) width / screenWidth;
        float factorY = (float) height / screenHeight;
        snake.updateLocation(factorX, factorY);
        food.updateLocation(factorX, factorY);
        this.screenWidth = width;
        this.screenHeight = height;
        unitSize = width / unitRatio;
    }
}

//System.out.println();