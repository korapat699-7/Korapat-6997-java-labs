package seedamart.korapat.lab10;

/*
 * PlayerFormV11 Programm :
 * - Player Form V11 is extends from Player Form V10.
 * - Add one menu item called "Custom".
 *   user selects the menu item "Custom", In the dialog the color on the bottom should be 
 *   the color of the current color of the text field. When the user chooses a new color, apply that color to all text fields 
 *   "Name", "Nationality", and "Date of Birth".
 * - Overrides the method actionPerformed() that will handle when the menu items "Open" and "Save" are selected.
 * - Adding shortcut keys and mnemonic keys:
 *      CTRL + N = New
 *      CTRL + O = Open
 *      CTRL + S = Save 
 *      CTRL + X = Exit
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 23 February 2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Extending PlayerFormV10
public class PlayerFormV11 extends PlayerFormV10 {

    // Constructor taking a title parameter
    public PlayerFormV11(String title) {
        super(title); // Calling superclass constructor
        enableKeyboard(); // Enabling keyboard shortcuts
    }

    // Method to add custom menu item
    @Override
    public void addMenus() {
        super.addMenus(); // Calling superclass method to add existing menus
        // Add "Custom" menu item under the "Color" menu
        JMenuItem customMenu = new JMenuItem("Custom");
        customMenu.setMnemonic(KeyEvent.VK_C); // Setting mnemonic key
        colorMenu.add(customMenu); // Adding to the colorMenu

        // Adding action listener to the "Custom" menu item
        customMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show color chooser dialog
                Color selectedColor = JColorChooser.showDialog(PlayerFormV11.this, "Choose a Color", Color.BLACK);
                if (selectedColor != null) {
                    // Apply the selected color to text fields
                    changeTextFieldFontColor(selectedColor);
                }
            }
        });
    }

    // Handling action events
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // Calling superclass method
        JMenuItem source = (JMenuItem)e.getSource(); // Getting the source of the event
        String menuItemText = source.getText(); // Getting the text of the menu item

        // Handle actions for different menu items
        switch (menuItemText) {
            // Existing menu items handling from PlayerFormV10
            case "Red":
                changeTextFieldFontColor(Color.RED);
                break;
            case "Green":
                changeTextFieldFontColor(Color.GREEN);
                break;
            case "Blue":
                changeTextFieldFontColor(Color.BLUE);
                break;
            case "16":
                changeTextAreaFont(16);
                break;
            case "20":
                changeTextAreaFont(20);
                break;
            case "24":
                changeTextAreaFont(24);
                break;
            case "New":
                JOptionPane.showMessageDialog(this, "You click menu New");
                break;
            case "Open":
                // Handle "Open" menu item action
                handleOpenMenu();
                break;
            case "Save":
                // Handle "Save" menu item action
                handleSaveMenu();
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    // Enabling keyboard shortcuts
    @SuppressWarnings("deprecation")
    protected void enableKeyboard() {
        // Set mnemonic key for the file menu
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // Set mnemonic keys for other menus
        newMenu.setMnemonic(KeyEvent.VK_N);
        openMenu.setMnemonic(KeyEvent.VK_O);
        saveMenu.setMnemonic(KeyEvent.VK_S);
        exitMenu.setMnemonic(KeyEvent.VK_X);

        // Set accelerator keys for menu items
        int acceleratorMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        newMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, acceleratorMask));
        openMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, acceleratorMask));
        saveMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, acceleratorMask));
        exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, acceleratorMask));
    }

    // Handling "Open" menu item action
    public void handleOpenMenu() {
        // Display open file dialog
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file and display a message dialog
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Opening file " + filePath );
        }
    }

    // Handling "Save" menu item action
    public void handleSaveMenu() {
        // Display save file dialog
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file and display a message dialog
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Saving in file " + filePath);
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Invoking method to create and show the GUI
            }
        });
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11"); // Creating an instance of PlayerFormV11
        msw.addComponents(); // Adding components to the frame
        msw.setFrameFeatures(); // Setting frame features
        msw.addMenus(); // Adding menus
    }
}
