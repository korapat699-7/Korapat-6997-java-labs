// Package declaration for the class
package seedamart.korapat.lab7;

/* 
 * PlayerFormV1 Program:
 * PlayerFormV1 extends from class MySimpleWindow.
 * The left part contains JLabel and then The right part contains JTextField whose length is 15.
 * JLabel it's contain Name, Nationality, Date of Birth and Gender.
 * In radio button gender "Female " is default.
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 2 February 2024
 */

// Importing necessary Java AWT and Swing classes
import javax.swing.*;
import java.awt.*;

// Defining a class named PlayerFormV1 that extends MySimpleWindow
class PlayerFormV1 extends MySimpleWindow {
    // Declaring instance variables for labels, panels, text fields, and radio buttons
    protected JLabel nameLabel, dateBirthLabel, nationalityLabel, genderLabel;
    protected JPanel radioPanel, genderPanel, rightPanel, leftPanel, combinePanel;
    protected static JTextField nameTextField;
    protected JTextField nationalityTextField;
    protected JTextField dateBirthTextField;
    protected JRadioButton maleRadioButton, femaleRadioButton;
    protected ButtonGroup genderButtonGroup;

    // Main method to invoke the GUI creation in the event dispatch thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Constructor for PlayerFormV1 class
    public PlayerFormV1(String title) {
        super(title);
        // Initializing panel and label objects
        mainPanel = new JPanel(new GridLayout(1, 2));
        leftPanel = new JPanel(new GridLayout(4, 1));
        rightPanel = new JPanel(new GridLayout(4, 1));
        radioPanel = new JPanel();

        // Initializing label objects
        nameLabel = new JLabel("Name:");
        nationalityLabel = new JLabel("Nationality:");
        dateBirthLabel = new JLabel("Date of Birth (eg.,31-01-2005):");
        genderLabel = new JLabel("Gender:");

        // Initializing radio button objects
        genderButtonGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setSelected(true);
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        radioPanel.add(maleRadioButton);
        radioPanel.add(femaleRadioButton);

        // Initializing text field objects
        int length = 15;
        nameTextField = new JTextField(length);
        dateBirthTextField = new JTextField(length);
        nationalityTextField = new JTextField(length);
    }

    // Method to add components (labels, text fields, and panels) to the frame
    protected void addComponents() {
        // Add labels to leftPanel
        leftPanel.add(nameLabel);
        leftPanel.add(nationalityLabel);
        leftPanel.add(dateBirthLabel);
        leftPanel.add(genderLabel);

        // Add text fields to rightPanel
        rightPanel.add(nameTextField);
        rightPanel.add(nationalityTextField);
        rightPanel.add(dateBirthTextField);
        rightPanel.add(radioPanel);

        // Add buttons to buttonPanel
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        // Add panels to mainPanel
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Add mainPanel and buttonPanel to the content pane
        getContentPane().add(mainPanel);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    // Static method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
