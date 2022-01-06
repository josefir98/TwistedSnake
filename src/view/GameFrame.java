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

    public GameFrame(int width, int height) {

        // Setup menu bar
        this.menuBar = new SnakeMenuBar();
        this.menuBar.exitItem.addActionListener(this);
        this.menuBar.resolutionItem.addActionListener(this);
        this.menuBar.r480pItem.addActionListener(this);
        this.menuBar.r720pItem.addActionListener(this);
        this.menuBar.r1080pItem.addActionListener(this);
        this.menuBar.r1440pItem.addActionListener(this);
        this.menuBar.fullScreenItem.addActionListener(this);
        this.setJMenuBar(menuBar);

        // Setup game panel
        this.width = width;
        this.height = height;
        this.gamePanel = new GamePanel(width, height);
        this.add(gamePanel);

        // Setup game frame
        this.setTitle("Twisted Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.getContentPane().setPreferredSize(new Dimension(width, height));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuBar.exitItem) {
            System.exit(0);
        }

        // 640 x 480   (480p)
        if (e.getSource() == menuBar.r480pItem) {
            this.width = 640;
            this.height = 480;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            gamePanel.sizeAdjust(640, 480);
            this.setVisible(true);
        }

        // 1280 x 720  (720p)
        if (e.getSource() == menuBar.r720pItem) {
            this.width = 1280;
            this.height = 720;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            gamePanel.sizeAdjust(1280, 720);
            this.setVisible(true);
        }
        // 1920 x 1080 (1080p)
        if (e.getSource() == menuBar.r1080pItem) {
            this.width = 1920;
            this.height = 1080;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            gamePanel.sizeAdjust(1920, 1080);
            this.setVisible(true);
        }
        // 2560 x 1440 (1440p)
        if (e.getSource() == menuBar.r1440pItem) {
            this.width = 2560;
            this.height = 1440;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            gamePanel.sizeAdjust(2560, 1440);
            this.setVisible(true);
        }
    }
}

//System.out.println();