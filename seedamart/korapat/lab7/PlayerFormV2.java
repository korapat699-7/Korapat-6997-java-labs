package seedamart.korapat.lab7;
/* 
 * PlayerFormV2 Program:
 * PlayerFormV2 extends from class PlayerFormV1.
 * It's just add Player Type and note.
 * Player Type is comboBox it contain by diffcult [beginer, Amateur, Professional].
 * notePanel is contain noteLabel and noteTextArea by row = 3, columns = 35.
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 2 February 2024
 */

// Importing necessary Java AWT and Swing classes
import java.awt.*;
import javax.swing.*;

// Defining a class named PlayerFormV2 that extends PlayerFormV1
public class PlayerFormV2 extends PlayerFormV1 {
    // Declaring instance variables for JComboBox, JTextArea, JLabel, JScrollPane, and additional panels
    protected JComboBox<String> DifficultcomboBox;
    protected JTextArea noteTextArea;
    protected JLabel noteLabel, playerLabel;
    protected JScrollPane scrollPane;
    protected JPanel notePanel, leftPanel;

    // Main method to invoke the GUI creation in the event dispatch thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Constructor for PlayerFormV2 class
    public PlayerFormV2(String title) {
        super(title);

        // Initializing panels and label objects
        mainPanel = new JPanel(new GridLayout(1, 2));
        leftPanel = new JPanel(new GridLayout(5, 1));
        rightPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        radioPanel = new JPanel(new FlowLayout());
        notePanel = new JPanel(new GridLayout(2, 1));

        // Initializing label objects
        playerLabel = new JLabel("Player Type:");
        noteLabel = new JLabel("Note:");

        // Initializing JTextArea object
        noteTextArea = new JTextArea(3, 35);
        noteTextArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");
        noteTextArea.setLineWrap(true);
        noteTextArea.setWrapStyleWord(true);

        // Initializing JComboBox object
        DifficultcomboBox = new JComboBox<>(new String[]{"Beginner", "Amateur", "Professional"});
        DifficultcomboBox.setSelectedItem("Amateur");

        // Reusing the genderButtonGroup and radio buttons from the superclass
        genderButtonGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setSelected(true);
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        radioPanel.add(maleRadioButton);
        radioPanel.add(femaleRadioButton);
    }

    // Method to add components (labels, text fields, combo box, text area, and panels) to the frame
    protected void addComponents() {
        // Adding labels to leftPanel
        leftPanel.add(nameLabel);
        leftPanel.add(nationalityLabel);
        leftPanel.add(dateBirthLabel);
        leftPanel.add(genderLabel);
        leftPanel.add(playerLabel);

        // Adding text fields and combo box to rightPanel
        rightPanel.add(nameTextField);
        rightPanel.add(nationalityTextField);
        rightPanel.add(dateBirthTextField);
        rightPanel.add(radioPanel);
        rightPanel.add(DifficultcomboBox);

        // Adding text area to notePanel
        notePanel.add(noteLabel);
        scrollPane = new JScrollPane(noteTextArea);
        notePanel.add(scrollPane);

        // Combining leftPanel and rightPanel in mainPanel
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Adding buttons to buttonPanel
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        // Adding mainPanel, notePanel, and buttonPanel to the content pane with specified layout
        getContentPane().add(mainPanel, BorderLayout.NORTH);
        getContentPane().add(notePanel);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    // Static method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
