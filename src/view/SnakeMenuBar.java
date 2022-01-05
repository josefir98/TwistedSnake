package view;

import javax.swing.*;

public class SnakeMenuBar extends JMenuBar {

    public JMenu fileMenu;
    public JMenuItem exitItem;

    public JMenu displayMenu;
    public JMenu resolutionItem;
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
        // 640 x 480   (480p)
        // 1280 x 720  (720p)
        // 1920 x 1080 (1080p)
        // 2560 x 1440 (1440p)
        fullScreenItem = new JMenuItem("Fullscreen");
        this.add(displayMenu);
        displayMenu.add(resolutionItem);
        displayMenu.add(fullScreenItem);

        // Setup Sound
        soundMenu = new JMenu("Sound");
        muteItem = new JMenuItem("Toggle Mute");
        this.add(soundMenu);
        displayMenu.add(muteItem);
    }

}
