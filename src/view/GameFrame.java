package view;

import javax.swing.*;
import java.awt.*;
import model.GameLogic;

public class GameFrame extends JFrame {

    public GameFrame(){
        GameLogic gameLogic = new GameLogic();
        this.add(new GamePanel(gameLogic));
        this.setLayout(new GridBagLayout());
        this.setTitle("Twisted Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
