package view;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    int width;
    int height;

    MainMenuPanel mainMenuPanel;
    GamePanel gamePanel;

    public BackgroundPanel(int width, int height) {
        this.width = width;
        this.height = height;
        // Setup main menu panel
        setupMainMenuPanel();
        // Setup game panel
        //setupGamePanel();
        // Setup background panel
        setupBackgroundPanel();
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

    private void setupGamePanel() {
        this.gamePanel = new GamePanel(width, height);
        this.add(gamePanel);
    }

    public void sizeAdjust(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        this.revalidate();
        mainMenuPanel.sizeAdjust(width, height);
        //gamePanel.sizeAdjust(width, height);
    }
}
