package seedamart.korapat.lab8;

/* 
 * PlayerFormV3 Program:
 * PlayerFormV3 class extends from PlayerFormV2
 * 
 * In this programm is implement method addMenus() 
 * 
 * In menu bar have 2 Items
 * 1. <File> "New", "Open", "Save" and Exit.
 * 2. <Comfig> Color and Size.
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 16 February 2024
 */

import javax.swing.*;
import seedamart.korapat.lab7.PlayerFormV2;

public class PlayerFormV3 extends PlayerFormV2 {
    JMenuBar menuBar;
    JMenu fileMenu, configMenu, colorMenu, sizMenu;
    JMenuItem redMenu, greenMenu, blueMenu, newMenu, openMenu, saveMenu, size16, size20, size24, exitMenu;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV3(String title) {
        super(title);
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        sizMenu = new JMenu("Size");
        redMenu = new JMenuItem("Red");
        greenMenu = new JMenuItem("Green");
        blueMenu = new JMenuItem("Blue");
        newMenu = new JMenuItem("New");
        openMenu = new JMenuItem("Open");
        saveMenu = new JMenuItem("Save");
        size16 = new JMenuItem("16");
        size20 = new JMenuItem("20");
        size24 = new JMenuItem("24");
        exitMenu = new JMenuItem("Exit");

    }

    protected void addMenus() {
        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        sizMenu.add(size16);
        sizMenu.add(size20);
        sizMenu.add(size24);
        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        configMenu.add(sizMenu);
        configMenu.add(colorMenu);
        colorMenu.add(redMenu);
        colorMenu.add(greenMenu);
        colorMenu.add(blueMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenu);

        this.setJMenuBar(menuBar);

    }

    protected void addComponents() {
        super.addComponents();

    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();

    }

}
