package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import model.GameLogic;

public class GameFrame extends JFrame {

    int width;
    int height;
    double curLongestSide;

    GamePanel gamePanel = new GamePanel();

    public GameFrame() {

        this.add(gamePanel);
        this.width = gamePanel.screenWidth;
        this.height = gamePanel.screenHeight;
        this.curLongestSide = Math.min(width, height);

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


                double newShortestSide = Math.max(getContentPane().getWidth(), getContentPane().getHeight());
                setBestSize(newShortestSide, curLongestSide, e);
            }
        });
    }

    //(shortest side of new) / (longest side of old)
    //= multiplier for both of the component's dimensions.
    private void setBestSize(double newShortestSide, double curLongestSide, ComponentEvent e) {
        //System.out.println(newShortestSide + " " + curLongestSide);
        double multiplier = newShortestSide / curLongestSide;
        System.out.println("multiplier " + multiplier);
        System.out.println("b width " + width);
        System.out.println("b height " + height);
        width = closestDivisible((int) (width * multiplier), 10);
        height = closestDivisible((int) (height * multiplier), 10);
        System.out.println("a width " + width);
        System.out.println("a height " + height);
        this.curLongestSide = Math.min(width, height);
        gamePanel.setPreferredSize(new Dimension(width, height));
        //this.setSize(e.getComponent().getSize());
        this.pack();
        gamePanel.resize = true;
    }

    private int closestDivisible(int a, int b) {
        return a - (a % b);
    }
}
