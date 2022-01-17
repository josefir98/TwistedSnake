package view.menues;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    JPanel buttonPanel;
    JButton playButton;
    JButton optionButton;
    JButton aboutButton;

    JPanel sliderPanel;
    JSlider musicSlider;
    JSlider effectsSlider;

    public boolean startGame = false;
    public boolean startOptions = false;

    public MainMenuPanel(int width, int height) {
        initElements();
        sizeAdjust(width, height);
        setupListeners();
    }

    private void initElements() {
        this.setLayout(null);
        this.setBackground(Color.GREEN);
        this.setFocusable(true);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.ORANGE);

        playButton = new JButton("PLAY");
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setFocusable(false);

        optionButton = new JButton("OPTIONS");
        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionButton.setFocusable(false);

        aboutButton = new JButton("ABOUT");
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setFocusable(false);

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.X_AXIS));
        sliderPanel.setBackground(Color.ORANGE);

        musicSlider = new JSlider(0, 100, 50);
        musicSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        musicSlider.setFocusable(false);

        effectsSlider = new JSlider(0, 100, 50);
        effectsSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        effectsSlider.setFocusable(false);
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

    private void setupListeners() {
        playButton.addActionListener((e) -> startGame = true);
        optionButton.addActionListener((e) -> startOptions = true);
    }
}
