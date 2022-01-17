package view;

import view.menues.MainMenuPanel;
import view.menues.OptionsMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundPanel extends JPanel implements ActionListener {

    int width;
    int height;
    boolean fullscreen;

    MainMenuPanel mainMenuPanel;
    GamePanel gamePanel;
    OptionsMenuPanel optionsMenuPanel;

    private boolean game = false;
    private boolean options = false;

    public BackgroundPanel(int width, int height, boolean fullscreen) {
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
        // Setup main menu panel
        setupMainMenuPanel();
        // Setup background panel
        setupBackgroundPanel();

        Timer timer = new Timer(100, this);
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

    public void sizeAdjust(int width, int height, boolean fullscreen) {
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;

        this.setPreferredSize(new Dimension(width, height));
        if (game) {
            gamePanel.sizeAdjust(width, height);
        } else if (options) {
            optionsMenuPanel.sizeAdjust(width, height, fullscreen);
        } else {
            mainMenuPanel.sizeAdjust(width, height);
        }
        this.revalidate();
        this.repaint();
    }

    public void setupGamePanel() {
        game = true;
        this.gamePanel = new GamePanel(width, height);
        this.add(gamePanel);
        this.revalidate();
        this.repaint();
    }

    public void setupOptionsMenuPanel() {
        options = true;
        this.optionsMenuPanel = new OptionsMenuPanel(width, height, fullscreen);
        this.add(optionsMenuPanel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean update = !((game == mainMenuPanel.startGame) && (options == mainMenuPanel.startOptions));

        if (update) {
            if (mainMenuPanel.startGame) {
                this.removeAll();
                setupGamePanel();
            } else if (mainMenuPanel.startOptions) {
                this.removeAll();
                setupOptionsMenuPanel();
            }
            this.revalidate();
            this.repaint();
        }
        if (optionsMenuPanel != null) {
            this.fullscreen = optionsMenuPanel.fullscreenButton.isSelected();
        }
    }
}
