package view;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    JPanel buttonPanel;
    JPanel sliderPanel;

    JButton playButton;
    JButton optionButton;
    JButton aboutButton;
    JSlider musicSlider;
    JSlider effectsSlider;

    boolean startGame = false;

    public MainMenuPanel(int width, int height) {
        initElements();
        sizeAdjust(width, height);
        setupListeners();
    }

    private void setupListeners() {
        playButton.addActionListener((e) -> startGame = true);
    }

    private void initElements() {
        this.setLayout(null);
        this.setBackground(Color.GREEN);
        this.setFocusable(true);

        buttonPanel = new JPanel();
        sliderPanel = new JPanel();
        playButton = new JButton("PLAY");
        optionButton = new JButton("OPTIONS");
        aboutButton = new JButton("ABOUT");
        musicSlider = new JSlider(0, 100, 50);
        effectsSlider = new JSlider(0, 100, 50);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.ORANGE);

        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.X_AXIS));
        sliderPanel.setBackground(Color.ORANGE);

        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setFocusable(false);

        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionButton.setFocusable(false);

        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setFocusable(false);

        musicSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        musicSlider.setFocusable(false);

        effectsSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        effectsSlider.setFocusable(false);
    }

    private void addElements(int width, int height) {
        int buttonGap = (int) (height * 0.1);
        int sliderGap = (int) (width * 0.2);

        this.add(buttonPanel);
        this.add(sliderPanel);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonGap)));
        buttonPanel.add(playButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonGap)));
        buttonPanel.add(optionButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonGap)));
        buttonPanel.add(aboutButton);

        sliderPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
        sliderPanel.add(musicSlider);
        sliderPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
        sliderPanel.add(effectsSlider);
        sliderPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
    }

    public void sizeAdjust(int width, int height) {
        this.removeAll();
        buttonPanel.removeAll();
        sliderPanel.removeAll();

        this.setPreferredSize(new Dimension(width, height));
        buttonPanel.setBounds(0, 0, width, (int) (height * 0.8));
        sliderPanel.setBounds(0, (int) (height * 0.8), width, (int) (height * 0.2));

        int fontRatio = (int) (height * 0.08);
        playButton.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));
        optionButton.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));
        aboutButton.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));
        musicSlider.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));
        effectsSlider.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));

        buttonPanel.revalidate();
        sliderPanel.revalidate();

        addElements(width, height);
        this.revalidate();
        this.repaint();
    }
}
