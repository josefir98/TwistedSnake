package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import model.GameLogic;

public class GameFrame extends JFrame {

    public GameFrame(){

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        //this.setLayout(new GridBagLayout());
        this.setTitle("Twisted Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //super.componentResized(e);
                int newSize = Math.max(getContentPane().getWidth(), getContentPane().getHeight());
                gamePanel.setPreferredSize(new Dimension(newSize, newSize));
                pack();
                gamePanel.resize(newSize);
            }
        });
    }
}
