package seedamart.korapat.lab11;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

public class PlayerFormV14 extends PlayerFormV13 {
    public static JMenu fillJMenu;
    public static JMenuItem yesJMenu, noJMenu;
    public static JRadioButtonMenuItem selectorFill;

    public PlayerFormV14(String title) {
        super(title);
        fillJMenu = new JMenu("Fill");
        yesJMenu = new JMenuItem("Yes");
        noJMenu = new JMenuItem("No");
        selectorFill = new JRadioButtonMenuItem();
    }

    public void addMenus() {
        super.addMenus();
        menuBar.add(fillJMenu);
        
        // Set "No" menu item as selected
        noJMenu.setSelected(true);

        fillJMenu.add(yesJMenu);
        fillJMenu.add(noJMenu);

        this.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        PlayerFormV14 msw = new PlayerFormV14("Player Form V14");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }
}
