package view;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {


    public MainMenuPanel(int width, int height) {
        setupMainMenuPanel(width, height);
    }

    private void setupMainMenuPanel(int width, int height) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setBackground(Color.YELLOW);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(width, height));
    }

    public void sizeAdjust(int width, int height) {
    }
}
