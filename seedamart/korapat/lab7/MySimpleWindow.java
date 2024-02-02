package seedamart.korapat.lab7;

/* 
 * My simple Window Program:
 * MySimpleWindow extends from class JFrame.
 * 
 * -four variables (two panels: one for buttons and one for main, and two buttons) 
 * as instance variables with the access level as protected so that these variables 
 * can be reused in their subclasses which may be  in different packages.
 * 
 * -Implement the protected void addComponents().
 * -Implement method protected  protected void setFrameFeatures()
 * -For all methods except method createAndShowGUI
 * 
 * Implement method protected  protected void setFrameFeatures() which 	performs these tasks
 *  -Set the window location at the center of the screen
 *  -Set the window visible
 *  -Exit the application using the System exit method when the user initiates a "close" on this frame
 *  -Pack all components of the frame.
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 2 February 2024
 */

// Importing necessary Java AWT and Swing classes
import java.awt.*;
import javax.swing.*;

// Defining a class named MySimpleWindow that extends JFrame
class MySimpleWindow extends JFrame {
    // Declaring instance variables for panels and buttons
    protected JPanel buttonPanel;
    protected JPanel mainPanel;
    protected JButton resetButton;
    protected JButton submitButton;

    // Constructor for MySimpleWindow class
    public MySimpleWindow(String title) {
        super(title);
        // Initializing panel and button objects
        buttonPanel = new JPanel(new FlowLayout());
        mainPanel = new JPanel();
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
    }

    // Method to add components (buttons) to the panels and main panel
    protected void addComponents() {
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel);
        getContentPane().add(mainPanel);
    }

    // Method to set various features of the frame
    protected void setFrameFeatures() {
        setLocationRelativeTo(null); // Set the window location at the center of the screen
        setVisible(true); // Set the window visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application on close
        pack(); // Pack all components of the frame
    }

    // Static method to create and show the GUI
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    // Main method to invoke the GUI creation in the event dispatch thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
