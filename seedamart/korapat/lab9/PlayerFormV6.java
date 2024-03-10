package seedamart.korapat.lab9;

/* 
 * PlayerFormV6 Programm :
 * 
 * - Class PlayerFormV6 that extends from PlayerFormV5 in package lab8 and implements ActionListener
 * - When the user enters the top three text fields and clicks the Submit button
 *   then the program displays the message in the message dialog.
 * 
 * - The program displays the values of name, nationality, date of birth, gender, player type, hobbies, and sports in the format:
 *    <name> has nationality as <nationality> and was born on <date of birth>, has gender as <gender>, 
 *    is a <playertype> player, has hobbies as <hobbies> and plays <sports> 
 * 
 * - When the user clicks the Reset button, the program resets the name, nationality, and date of birth text fields.
 * - When the user changes any text field (name, nationality, or date of birth) and press Enter on the keyboard (not the Submit Button), the program 
 * - displays the message dialog showing that text field is updated, in the format "<Textfield Name> is changed to <Textfield Value>"
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 16 February 2024
 */

import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import seedamart.korapat.lab8.PlayerFormV5;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {
    // Member variables declaration
    public String name, nationality, date, gender, playertype, hobbies, sports;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV6(String title) {
        super(title);
        // Set name for each textfield
        nameTextField.setName("Name");
        nationalityTextField.setName("Nationality");
        dateBirthTextField.setName("Date of Birth");
    }

    protected void addComponents() {
        super.addComponents();
        // Add action listener for buttons and text fields
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        nameTextField.addActionListener(this);
        nationalityTextField.addActionListener(this);
        dateBirthTextField.addActionListener(this);
    }

    // Method to handle text field changes
    public void handleTextField(JTextField textField) {
        String fieldName = textField.getName();
        String fieldValue = textField.getText();
        JOptionPane.showMessageDialog(rootPane, fieldName + " is changed to " + fieldValue);

    }

    public void handleSubmitButton() {
        // Retrieve values from text fields, radio buttons, checkboxes, etc.
        // and store them in respective variables
        // Display the gathered information in a dialog box
        name = nameTextField.getText();
        nationality = nationalityTextField.getText();
        date = dateBirthTextField.getText();
        hobbies = "";

        if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (maleRadioButton.isSelected()) {
            gender = "Male";
        }

        Object diff = DifficultcomboBox.getSelectedItem();
        if (diff.equals("Amateur")) {
            playertype = "Amateur";
        } else if (diff.equals("Professional")) {
            playertype = "Professional";
        } else if (diff.equals("Beginner")) {
            playertype = "Beginner";
        }

        if (readCheckBox.isSelected()) {
            hobbies += readCheckBox.getText() + " ";
        }

        if (browsCheckBox.isSelected()) {
            hobbies += browsCheckBox.getText() + " ";
        }

        if (sleepingCheckBox.isSelected()) {
            hobbies += sleepingCheckBox.getText() + " ";
        }

        if (travelingCheckBox.isSelected()) {
            hobbies += travelingCheckBox.getText() + " ";
        }

        List<String> sports = sportList.getSelectedValuesList();
        JOptionPane.showMessageDialog(rootPane,
                name + " has nationality as " + nationality + " and was born on " + date + ", has gender as " + gender
                        + ", is a " + playertype + " player, has hobbies as " + hobbies + "and plays " + sports);

    }

    public void handleResetButton() {
        // Reset text fields
        nameTextField.setText(null);
        nationalityTextField.setText(null);
        dateBirthTextField.setText(null);
    }

    // ActionListener interface implementation
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            handleSubmitButton();
        } else if (src == resetButton) {
            handleResetButton();
        } else if (src instanceof JTextField) {
            handleTextField((JTextField) src);
        }
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }

}
