package seedamart.korapat.lab10;

/*
 * PlayerFormV9 Programm :
 * - Player Form V9 is extends from Player Form V8 and implement ChangeListener.
 * - Overrides the method addListeners() such that the appropriate listener is added 
 *   to the JSllider previously defined in PlayerFormV4 in Lab8.
 * - Implement the method stateChanged() that will handle when the marker of 
 *   the slider is moved. When the marker is moved
 *  
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 23 February 2024
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Extending PlayerFormV8 and implementing ChangeListener interface
public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {

    // Constructor taking a title parameter
    public PlayerFormV9(String title) {
        super(title); // Calling superclass constructor
    }

    // Method to add listeners, overriding superclass method
    @Override
    public void addListeners() {
        super.addListeners(); // Calling superclass method
        sportSlider.addChangeListener(this); // Adding ChangeListener to sportSlider
    }

    // Handling state change events
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == sportSlider) { // Checking if event source is the sportSlider
            JSlider source = (JSlider) e.getSource(); // Casting event source to JSlider
            if (!source.getValueIsAdjusting()) { // Checking if the value adjustment is finished
                int age = (int) source.getValue(); // Getting the value of the slider
                // Displaying a message dialog with the current value
                JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + age);
            }
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
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9"); // Creating an instance of PlayerFormV9
        msw.addComponents(); // Adding components to the frame
        msw.setFrameFeatures(); // Setting frame features
        msw.addMenus(); // Adding menus
    }
}
