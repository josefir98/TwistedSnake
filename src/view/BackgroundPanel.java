package view;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    int width;
    int height;
    GamePanel gamePanel;
    public BackgroundPanel(int width, int height) {
        this.width = width;
        this.height = height;
        // Setup game panel
        setupGamePanel();
        setupBackgroundPanel();
    }

    private void setupBackgroundPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setBackground(Color.GRAY);
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(width, height));
    }

    private void setupGamePanel() {
        this.gamePanel = new GamePanel(width, height);
        this.add(gamePanel);
    }

    public void sizeAdjust(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        this.revalidate();
        gamePanel.sizeAdjust(width, height);
    }
}
