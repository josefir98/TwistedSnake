package view.menues;

import javax.swing.*;
import java.awt.*;

public class OptionsMenuPanel extends JPanel{

    JPanel upperPanel;
    public JCheckBox fullscreenButton;

    JPanel lowerPanel;
    JSlider musicSlider;
    JSlider effectsSlider;

    public OptionsMenuPanel(int width, int height, boolean fullscreen) {
        initElements();
        sizeAdjust(width, height, fullscreen);
        setupListeners();
    }

    private void initElements() {
        this.setLayout(null);
        this.setBackground(Color.GREEN);
        this.setFocusable(true);

        upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        upperPanel.setBackground(Color.ORANGE);

        fullscreenButton = new JCheckBox("Fullscreen");
        fullscreenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        fullscreenButton.setFocusable(false);

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
        lowerPanel.setBackground(Color.ORANGE);

        musicSlider = new JSlider(0, 100, 50);
        musicSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        musicSlider.setFocusable(false);

        effectsSlider = new JSlider(0, 100, 50);
        effectsSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        effectsSlider.setFocusable(false);
    }

    public void sizeAdjust(int width, int height, boolean fullscreen) {
        this.removeAll();
        upperPanel.removeAll();
        lowerPanel.removeAll();

        this.setPreferredSize(new Dimension(width, height));
        upperPanel.setBounds(0, 0, width, (int) (height * 0.8));
        lowerPanel.setBounds(0, (int) (height * 0.8), width, (int) (height * 0.2));

        int fontRatio = (int) (height * 0.08);
        fullscreenButton.setSelected(fullscreen);
        fullscreenButton.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));
        musicSlider.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));
        effectsSlider.setFont(new Font("Times New Roman", Font.BOLD, fontRatio));

        upperPanel.revalidate();
        lowerPanel.revalidate();

        addElements(width, height);
        this.revalidate();
        this.repaint();
    }

    private void addElements(int width, int height) {
        int buttonGap = (int) (height * 0.1);
        int sliderGap = (int) (width * 0.2);

        this.add(upperPanel);
        this.add(lowerPanel);

        upperPanel.add(Box.createRigidArea(new Dimension(0, buttonGap)));
        upperPanel.add(fullscreenButton);

        lowerPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
        lowerPanel.add(musicSlider);
        lowerPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
        lowerPanel.add(effectsSlider);
        lowerPanel.add(Box.createRigidArea(new Dimension(sliderGap, 0)));
    }

    private void setupListeners() {
        //fullscreenButton.addActionListener((e) -> {});
    }
}
