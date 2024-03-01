package seedamart.korapat.lab10;

/*
 * PlayerFormV10 Programm :
 * - Player Form V10 is extends from Player Form V9.
 * - Overrides the method addListeners() such that the appropriate listeners 
 *   are added to all the JMunuItem previously defined in PlayerFormV3 in Lab8.
 * - Overrides the method actionPerformed() that will handle when the menu items are selected.

 *  
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 23 February 2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Extending PlayerFormV9
public class PlayerFormV10 extends PlayerFormV9 {

    // Constructor taking a title parameter
    public PlayerFormV10(String title) {
        super(title); // Calling superclass constructor
    }

    // Method to add listeners, overriding superclass method
    @Override
    public void addListeners() {
        super.addListeners(); // Calling superclass method
        // Adding action listeners to menu items
        redMenu.addActionListener(this);
        greenMenu.addActionListener(this);
        blueMenu.addActionListener(this);
        size16.addActionListener(this);
        size20.addActionListener(this);
        size24.addActionListener(this);
        newMenu.addActionListener(this);
        openMenu.addActionListener(this);
        saveMenu.addActionListener(this);
        exitMenu.addActionListener(this);
    }

    // Method to handle menu item actions
    public void handleMenuItem(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource(); // Getting the source of the event
        String menuItemText = source.getText(); // Getting the text of the menu item

        // Handling actions for different menu items
        switch (menuItemText) {
            case "Red":
                changeTextFieldFontColor(Color.RED); // Changing font color of text fields to red
                break;
            case "Green":
                changeTextFieldFontColor(Color.GREEN); // Changing font color of text fields to green
                break;
            case "Blue":
                changeTextFieldFontColor(Color.BLUE); // Changing font color of text fields to blue
                break;
            case "16":
                changeTextAreaFont(16); // Changing font size of text area to 16
                break;
            case "20":
                changeTextAreaFont(20); // Changing font size of text area to 20
                break;
            case "24":
                changeTextAreaFont(24); // Changing font size of text area to 24
                break;
            case "New":
                JOptionPane.showMessageDialog(this, "You click menu New"); // Displaying a message dialog for "New" menu item
                break;
            case "Open":
                JOptionPane.showMessageDialog(this, "You click menu Open "); // Displaying a message dialog for "Open" menu item
                break;
            case "Save":
                JOptionPane.showMessageDialog(this, "You click menu Save"); // Displaying a message dialog for "Save" menu item
                break;
            case "Exit":
                System.exit(0); // Exiting the application for "Exit" menu item
                break;
        }
    }

    // Handling action events
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // Calling superclass method
        if (e.getSource() instanceof JMenuItem) { // Checking if the event source is a JMenuItem
            handleMenuItem(e); // Handling menu item actions
        }
    }

    // Method to change font color of text fields
    void changeTextFieldFontColor(Color color) {
        nameTextField.setForeground(color);
        nationalityTextField.setForeground(color);
        dateBirthTextField.setForeground(color);
    }

    // Method to change font size of text area
    protected void changeTextAreaFont(int size) {
        noteTextArea.setFont(new Font("Serif", Font.BOLD, size));
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
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10"); // Creating an instance of PlayerFormV10
        msw.addComponents(); // Adding components to the frame
        msw.setFrameFeatures(); // Setting frame features
        msw.addMenus(); // Adding menus
    }
}
