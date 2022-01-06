package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class SnakeMenuBar extends JMenuBar {

    public JMenu fileMenu;
    public JMenuItem exitItem;

    public JMenu displayMenu;
    public JMenu resolutionItem;
    public ButtonGroup resolutionGroup;
    public JMenuItem fullScreenItem;
    public JRadioButtonMenuItem r480pItem;
    public JRadioButtonMenuItem r720pItem;
    public JRadioButtonMenuItem r1080pItem;
    public JRadioButtonMenuItem r1440pItem;
    public JRadioButtonMenuItem r100sItem;
    public JRadioButtonMenuItem r200sItem;
    public JRadioButtonMenuItem r300sItem;
    public JRadioButtonMenuItem r400sItem;
    public JRadioButtonMenuItem r500sItem;
    public JRadioButtonMenuItem r600sItem;
    public JRadioButtonMenuItem r700sItem;
    public JRadioButtonMenuItem r800sItem;
    public JRadioButtonMenuItem r900sItem;
    public JRadioButtonMenuItem r1000sItem;

    public JMenu soundMenu;
    public JMenuItem muteItem;

    public SnakeMenuBar() {

        // Setup File
        fileMenu = new JMenu("File");
        exitItem = new JMenuItem("Exit");
        exitItem.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        this.add(fileMenu);
        fileMenu.add(exitItem);


        // Setup Display
        displayMenu = new JMenu("Display");
        resolutionItem = new JMenu("Resolution");
        fullScreenItem = new JMenuItem("Fullscreen");
        fullScreenItem.setAccelerator(KeyStroke.getKeyStroke("control F"));
        r480pItem = new JRadioButtonMenuItem("640 x 480");
        r720pItem = new JRadioButtonMenuItem("1280 x 720");
        r1080pItem = new JRadioButtonMenuItem("1920 x 1080");
        r1440pItem = new JRadioButtonMenuItem("2560 x 1440");
        r100sItem = new JRadioButtonMenuItem("100 x 100");
        r200sItem = new JRadioButtonMenuItem("200 x 200");
        r300sItem = new JRadioButtonMenuItem("300 x 300");
        r400sItem = new JRadioButtonMenuItem("400 x 400");
        r500sItem = new JRadioButtonMenuItem("500 x 500");
        r600sItem = new JRadioButtonMenuItem("600 x 600");
        r700sItem = new JRadioButtonMenuItem("700 x 700");
        r800sItem = new JRadioButtonMenuItem("800 x 800");
        r900sItem = new JRadioButtonMenuItem("900 x 900");
        r1000sItem = new JRadioButtonMenuItem("1000 x 1000)");

        resolutionGroup = new ButtonGroup();
        resolutionGroup.add(r480pItem);
        resolutionGroup.add(r720pItem);
        resolutionGroup.add(r1080pItem);
        resolutionGroup.add(r1440pItem);
        resolutionGroup.add(r100sItem);
        resolutionGroup.add(r200sItem);
        resolutionGroup.add(r300sItem);
        resolutionGroup.add(r400sItem);
        resolutionGroup.add(r500sItem);
        resolutionGroup.add(r600sItem);
        resolutionGroup.add(r700sItem);
        resolutionGroup.add(r800sItem);
        resolutionGroup.add(r900sItem);
        resolutionGroup.add(r1000sItem);

        this.add(displayMenu);
        displayMenu.add(fullScreenItem);
        displayMenu.add(new JSeparator());
        displayMenu.add(resolutionItem);
        resolutionItem.add(r480pItem);
        resolutionItem.add(r720pItem);
        resolutionItem.add(r1080pItem);
        resolutionItem.add(r1440pItem);
        resolutionItem.add(new JSeparator());
        resolutionItem.add(r100sItem);
        resolutionItem.add(r200sItem);
        resolutionItem.add(r300sItem);
        resolutionItem.add(r400sItem);
        resolutionItem.add(r500sItem);
        resolutionItem.add(r600sItem);
        resolutionItem.add(r700sItem);
        resolutionItem.add(r800sItem);
        resolutionItem.add(r900sItem);
        resolutionItem.add(r1000sItem);

        // Setup Sound
        soundMenu = new JMenu("Sound");
        muteItem = new JMenuItem("Toggle Mute");
        this.add(soundMenu);
        soundMenu.add(muteItem);
    }

}
