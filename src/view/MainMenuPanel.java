package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    private int width;
    private int height;


    public MainMenuPanel(int width, int height) {
        setupMainMenuPanel(width, height);

        this.add(Box.createRigidArea(new Dimension(0, 70)));
        setupPlayButton();
        this.add(Box.createRigidArea(new Dimension(0, 70)));
        setupOptionButton();
    }

    private void setupMainMenuPanel(int width, int height) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.YELLOW);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(width, height));
    }

    private void setupPlayButton() {
        JButton playButton = new JButton("PLAY");
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
        playButton.setFocusable(false);
        this.add(playButton);
    }

    private void setupOptionButton() {
        JButton optionButton = new JButton("OPTIONS");
        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
        optionButton.setFocusable(false);
        this.add(optionButton);
    }

    public void sizeAdjust(int width, int height) {
    }
}
