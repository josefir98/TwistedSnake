package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    SnakeMenuBar menuBar;

    //System.out.println();
    GamePanel gamePanel;
    int width;
    int height;

    public GameFrame() {

        // Setup menu bar
        this.menuBar = new SnakeMenuBar();
        this.menuBar.exitItem.addActionListener(this);
        this.menuBar.resolutionItem.addActionListener(this);
        this.menuBar.fullScreenItem.addActionListener(this);
        this.setJMenuBar(menuBar);

        // Setup game panel
        this.gamePanel = new GamePanel();
        this.add(gamePanel);
        this.width = gamePanel.screenWidth;
        this.height = gamePanel.screenHeight;

        // Setup game frame
        this.setTitle("Twisted Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menuBar.exitItem) {
            System.exit(0);
        }
    }
}

//System.out.println();