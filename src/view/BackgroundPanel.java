package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundPanel extends JPanel implements ActionListener {

    int width;
    int height;

    MainMenuPanel mainMenuPanel;
    GamePanel gamePanel;

    private Timer timer;
    private boolean game = false;

    public BackgroundPanel(int width, int height) {
        this.width = width;
        this.height = height;
        // Setup main menu panel
        setupMainMenuPanel();
        // Setup background panel
        setupBackgroundPanel();

        timer = new Timer(100, this);
        timer.start();
    }

    private void setupMainMenuPanel() {
        this.mainMenuPanel = new MainMenuPanel(width, height);
        this.add(mainMenuPanel);
    }

    private void setupBackgroundPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setBackground(Color.GRAY);
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(width, height));
    }

    public void setupGamePanel() {
        game = true;
        this.gamePanel = new GamePanel(width, height);
        this.add(gamePanel);
        this.revalidate();
        this.repaint();
        gamePanel.setFocusable(true);
    }

    public void sizeAdjust(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        this.revalidate();
        if (game) {
            gamePanel.sizeAdjust(width, height);
        } else {
            mainMenuPanel.sizeAdjust(width, height);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (mainMenuPanel.startGame) {
            timer.stop();
            this.removeAll();
            setupGamePanel();
            this.revalidate();
            this.repaint();
        }
    }
}
