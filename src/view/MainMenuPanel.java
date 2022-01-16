package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    private int width;
    private int height;

    JPanel buttonPanel;
    JPanel sliderPanel;


    public MainMenuPanel(int width, int height) {
        setupMainMenuPanel(width, height);

        int buttonGap = (int) (height * 0.1);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonGap)));
        setupPlayButton();
        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonGap)));
        setupOptionButton();
        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonGap)));
        setupAboutButton();

        int sliderGap = (int) (width * 0.2);
        sliderPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
        setupMusicSlider();
        sliderPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
        setupEffectsSlider();
        sliderPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
    }

    private void setupMainMenuPanel(int width, int height) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GREEN);
        this.setFocusable(true);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBounds(0, 0, width, (int) (height * 0.7));
        buttonPanel.setBackground(Color.YELLOW);
        this.add(buttonPanel);

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.X_AXIS));
        sliderPanel.setBounds(0, (int) (height * 0.7), width, (int) (height * 0.3));
        sliderPanel.setBackground(Color.ORANGE);
        this.add(sliderPanel);
    }

    private void setupPlayButton() {
        JButton playButton = new JButton("PLAY");
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
        playButton.setFocusable(false);
        buttonPanel.add(playButton);
    }

    private void setupOptionButton() {
        JButton optionButton = new JButton("OPTIONS");
        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
        optionButton.setFocusable(false);
        buttonPanel.add(optionButton);
    }

    private void setupAboutButton() {
        JButton aboutButton = new JButton("ABOUT");
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
        aboutButton.setFocusable(false);
        buttonPanel.add(aboutButton);
    }

    private void setupMusicSlider() {
        JSlider musicSlider = new JSlider(0, 100, 50);
        musicSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        musicSlider.setFont(new Font("Times New Roman", Font.BOLD, 40));
        musicSlider.setFocusable(false);
        sliderPanel.add(musicSlider);
    }

    private void setupEffectsSlider() {
        JSlider effectsSlider = new JSlider(0, 100, 50);
        effectsSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        effectsSlider.setFont(new Font("Times New Roman", Font.BOLD, 40));
        effectsSlider.setFocusable(false);
        sliderPanel.add(effectsSlider);
    }

    public void sizeAdjust(int width, int height) {
    }
}
