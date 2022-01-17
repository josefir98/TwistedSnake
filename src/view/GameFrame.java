package view;

import view.menues.SnakeMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class GameFrame extends JFrame implements ActionListener {

    SnakeMenuBar menuBar;

    Action exitAction;
    Action fullscreenAction;

    JRadioButtonMenuItem previousRes;
    public boolean fullscreen = false;

    //System.out.println();
    BackgroundPanel backgroundPanel;
    int width;
    int height;

    public GameFrame(int width, int height) {
        this.width = width;
        this.height = height;
        // Setup menu bar
        setupMenuBar();
        // Setup Background panel
        setupBackgroundPanel();
        // Setup game frame
        setupGameFrame();
        setupKeyBinds();

        Timer timer = new Timer(100, e -> {
            if (backgroundPanel.fullscreen != fullscreen) {
                toggleFullscreen();
            }
        });
        timer.start();
    }

    private void setupKeyBinds() {
        // Setup exit key binding
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        this.exitAction = new ExitAction();
        this.backgroundPanel.getInputMap(condition).put(KeyStroke.getKeyStroke("control Q"), "exitAction");
        this.backgroundPanel.getActionMap().put("exitAction", exitAction);
        // Setup fullscreen key binding
        this.fullscreenAction = new FullscreenAction();
        this.backgroundPanel.getInputMap(condition).put(KeyStroke.getKeyStroke("control F"), "fullscreenAction");
        this.backgroundPanel.getActionMap().put("fullscreenAction", fullscreenAction);
    }

    private void setupGameFrame() {
        this.setTitle("Twisted Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.getContentPane().setPreferredSize(new Dimension(width, height));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setupBackgroundPanel() {
        this.backgroundPanel = new BackgroundPanel(width, height, fullscreen);
        this.add(backgroundPanel);
    }

    private void setupMenuBar() {
        this.menuBar = new SnakeMenuBar();

        this.menuBar.exitItem.addActionListener(this);

        this.menuBar.fullscreenItem.addActionListener(this);
        this.menuBar.r480pItem.addActionListener(this);
        this.menuBar.r480pItem.setSelected(true);
        this.menuBar.r720pItem.addActionListener(this);
        this.menuBar.r1080pItem.addActionListener(this);
        this.menuBar.r1440pItem.addActionListener(this);
        this.menuBar.r100sItem.addActionListener(this);
        this.menuBar.r200sItem.addActionListener(this);
        this.menuBar.r300sItem.addActionListener(this);
        this.menuBar.r400sItem.addActionListener(this);
        this.menuBar.r500sItem.addActionListener(this);
        this.menuBar.r600sItem.addActionListener(this);
        this.menuBar.r700sItem.addActionListener(this);
        this.menuBar.r800sItem.addActionListener(this);
        this.menuBar.r900sItem.addActionListener(this);
        this.menuBar.r1000sItem.addActionListener(this);

        this.setJMenuBar(menuBar);
    }

    public void toggleFullscreen() {
        if (fullscreen) {
            fullscreen = false;
            this.dispose();
            menuBar.setVisible(true);
            this.setUndecorated(false);
            previousRes.doClick();
            this.pack();
        } else {
            fullscreen = true;
            previousRes = (JRadioButtonMenuItem) getSelectedButton(menuBar.resolutionGroup);
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            this.width = size.width;
            this.height = size.height;
            this.dispose();
            this.setUndecorated(true);
            this.getContentPane().setPreferredSize(size);
            this.pack();
            backgroundPanel.sizeAdjust(width, height, fullscreen);
            menuBar.setVisible(false);
        }
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private AbstractButton getSelectedButton(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button;
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Exit
        if (e.getSource() == menuBar.exitItem) {
            System.exit(0);
        }
        // Fullscreen
        if (e.getSource() == menuBar.fullscreenItem) {
            System.out.println("ddd");
            toggleFullscreen();
        }
        // 640 x 480   (480p)
        if (e.getSource() == menuBar.r480pItem) {
            this.width = 640;
            this.height = 480;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(640, 480, fullscreen);
            this.setVisible(true);
        }

        // 1280 x 720  (720p)
        if (e.getSource() == menuBar.r720pItem) {
            this.width = 1280;
            this.height = 720;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(1280, 720, fullscreen);
            this.setVisible(true);
        }
        // 1920 x 1080 (1080p)
        if (e.getSource() == menuBar.r1080pItem) {
            this.width = 1920;
            this.height = 1080;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(1920, 1080, fullscreen);
            this.setVisible(true);
        }
        // 2560 x 1440 (1440p)
        if (e.getSource() == menuBar.r1440pItem) {
            this.width = 2560;
            this.height = 1440;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(2560, 1440, fullscreen);
            this.setVisible(true);
        }
        // 100 x 100
        if (e.getSource() == menuBar.r100sItem) {
            this.width = 100;
            this.height = 100;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(100, 100, fullscreen);
            this.setVisible(true);
        }
        // 200 x 200
        if (e.getSource() == menuBar.r200sItem) {
            this.width = 200;
            this.height = 200;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(200, 200, fullscreen);
            this.setVisible(true);
        }
        // 300 x 300
        if (e.getSource() == menuBar.r300sItem) {
            this.width = 300;
            this.height = 300;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(300, 300, fullscreen);
            this.setVisible(true);
        }
        // 400 x 400
        if (e.getSource() == menuBar.r400sItem) {
            this.width = 400;
            this.height = 400;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(400, 400, fullscreen);
            this.setVisible(true);
        }
        // 500 x 500
        if (e.getSource() == menuBar.r500sItem) {
            this.width = 500;
            this.height = 500;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(500, 500, fullscreen);
            this.setVisible(true);
        }
        // 600 x 600
        if (e.getSource() == menuBar.r600sItem) {
            this.width = 600;
            this.height = 600;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(600, 600, fullscreen);
            this.setVisible(true);
        }
        // 700 x 700
        if (e.getSource() == menuBar.r700sItem) {
            this.width = 700;
            this.height = 700;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(700, 700, fullscreen);
            this.setVisible(true);
        }
        // 800 x 800
        if (e.getSource() == menuBar.r800sItem) {
            this.width = 800;
            this.height = 800;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(800, 800, fullscreen);
            this.setVisible(true);
        }
        // 900 x 900
        if (e.getSource() == menuBar.r900sItem) {
            this.width = 900;
            this.height = 900;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(900, 900, fullscreen);
            this.setVisible(true);
        }
        // 1000 x 1000
        if (e.getSource() == menuBar.r1000sItem) {
            this.width = 1000;
            this.height = 1000;
            this.dispose();
            this.getContentPane().setPreferredSize(new Dimension(width, height));
            this.pack();
            backgroundPanel.sizeAdjust(1000, 1000, fullscreen);
            this.setVisible(true);
        }
    }

    public class FullscreenAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            toggleFullscreen();
        }
    }

    public static class ExitAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

//System.out.println();