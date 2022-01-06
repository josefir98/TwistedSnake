package view;

import javax.swing.*;

public class SnakeMenuBar extends JMenuBar {

    public JMenu fileMenu;
    public JMenuItem exitItem;

    public JMenu displayMenu;
    public JMenu resolutionItem;
    public JMenuItem r480pItem;
    public JMenuItem r720pItem;
    public JMenuItem r1080pItem;
    public JMenuItem r1440pItem;
    public JMenuItem fullScreenItem;

    public JMenu soundMenu;
    public JMenuItem muteItem;

    public SnakeMenuBar() {

        // Setup File
        fileMenu = new JMenu("File");
        exitItem = new JMenuItem("Exit");
        this.add(fileMenu);
        fileMenu.add(exitItem);

        // Setup Display
        displayMenu = new JMenu("Display");
        resolutionItem = new JMenu("Resolution");
        r480pItem = new JMenuItem("640 x 480        (480p)");
        r720pItem = new JMenuItem("1280 x 720      (720p)");
        r1080pItem = new JMenuItem("1920 x 1080    (1080p)");
        r1440pItem = new JMenuItem("2560 x 1440    (1440p)");
        fullScreenItem = new JMenuItem("Fullscreen");
        this.add(displayMenu);
        displayMenu.add(resolutionItem);
        resolutionItem.add(r480pItem);
        resolutionItem.add(r720pItem);
        resolutionItem.add(r1080pItem);
        resolutionItem.add(r1440pItem);
        displayMenu.add(fullScreenItem);

        // Setup Sound
        soundMenu = new JMenu("Sound");
        muteItem = new JMenuItem("Toggle Mute");
        this.add(soundMenu);
        displayMenu.add(muteItem);
    }

}
