package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.GameLogic;
import model.MainFood;
import model.Snake;

public class GamePanel extends JPanel implements ActionListener {

    //System.out.println();
    boolean running = false;
    private Timer timer;
    boolean resize = false;

    GameLogic gameLogic;
    int screenWidth;
    int screenHeight;
    int unitSize;
    Snake snake;
    MainFood food;

    int newWidth;
    int newHeight;

    boolean canTurn = true;

    public GamePanel(int width, int height) { //mb add params for snake and food in future?
        this.snake = new Snake();
        this.food = new MainFood();
        sizeAdjustDo(width, height);
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        setupKeyBinds();
        startGame();
    }

    private void setupKeyBinds() {
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        this.getInputMap(condition).put(KeyStroke.getKeyStroke("UP"), "UpAction");
        this.getActionMap().put("UpAction", new SnakeKeyHandler('U'));

        this.getInputMap(condition).put(KeyStroke.getKeyStroke("DOWN"), "DownAction");
        this.getActionMap().put("DownAction", new SnakeKeyHandler('D'));

        this.getInputMap(condition).put(KeyStroke.getKeyStroke("LEFT"), "LeftAction");
        this.getActionMap().put("LeftAction", new SnakeKeyHandler('L'));

        this.getInputMap(condition).put(KeyStroke.getKeyStroke("RIGHT"), "RightAction");
        this.getActionMap().put("RightAction", new SnakeKeyHandler('R'));
    }

    public void startGame() {
        gameLogic.newFood();
        running = true;
        timer = new Timer(gameLogic.DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            //draw grid
            for (int i = 0; i < screenHeight / unitSize; i++) {
                g.drawLine(i * unitSize, 0, i * unitSize, screenHeight);
                g.drawLine(0, i * unitSize, screenWidth, i * unitSize);
            }
            //draw food
            g.setColor(Color.RED);
            g.fillOval(food.x, food.y, unitSize, unitSize);
            //draw snake
            for (int i = 0; i < snake.bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(snake.x[i], snake.y[i], unitSize, unitSize);
                } else {
                    g.setColor(Color.YELLOW);
                    g.fillRect(snake.x[i], snake.y[i], unitSize, unitSize);
                }
            }
            canTurn = true;
        } else {
            gameOver(g);
        }
    }

    public void gameOver(Graphics g) {
        //Score
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + snake.foodEaten, (screenWidth - metrics1.stringWidth("Score: " + snake.foodEaten)) / 2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (screenWidth - metrics2.stringWidth("Game Over")) / 2, screenHeight / 2);
    }

    private void sizeAdjustDo(int width, int height) {
        int newDimension = Math.min(width, height);
        if (resize) {
            gameLogic.sizeAdjust(newDimension, newDimension);
        } else {
            this.gameLogic = new GameLogic(newDimension, newDimension, 10, this.snake, this.food);
        }
        this.screenWidth = newDimension;
        this.screenHeight = newDimension;
        this.unitSize = gameLogic.unitSize;
        this.setPreferredSize(new Dimension(newDimension, newDimension));
        this.revalidate();
        resize = false;
    }

    public void sizeAdjust(int width, int height) {
        this.newWidth = width;
        this.newHeight = height;
        resize = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            gameLogic.move();
            gameLogic.checkFood();
            if (gameLogic.checkCollisions()) {
                running = false;
                timer.stop();
            }
        }
        if (resize) {
            sizeAdjustDo(newWidth, newHeight);
        }
        repaint();
    }

    public class SnakeKeyHandler extends AbstractAction {
        char dir;

        public SnakeKeyHandler(char dir) {
            this.dir = dir;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (canTurn) {
                switch (dir) {
                    case 'U':
                        if (snake.direction != 'D') {
                            snake.direction = 'U';
                        }
                        break;
                    case 'D':
                        if (snake.direction != 'U') {
                            snake.direction = 'D';
                        }
                        break;
                    case 'L':
                        if (snake.direction != 'R') {
                            snake.direction = 'L';
                        }
                        break;
                    case 'R':
                        if (snake.direction != 'L') {
                            snake.direction = 'R';
                        }
                        break;
                }
            }
            canTurn = false;
        }
    }
}

//System.out.println();