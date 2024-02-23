package seedamart.korapat.lab9;

/* 
 * PlayerFormV7 Program :
 * 
 * - Class PlayerFormV7 extends PlayerFormV6 from the lab8 package and implementation of ItemListener.
 * 
 * - When the user clicks at a radio button, the program displays the message dialog showing the update in the format 
 *   "Gender is updated to <selected gender>"
 * 
 * - When the user selects a checkbox, the program displays the dialog "<hobby> is one of the hobbies". 
 * - When the user deselects a checkbox, the program displays the dialog "<hobby> is no longer one of the hobbies".
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 16 February 2024
 */

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV7(String title) {
        super(title);
        readCheckBox.addActionListener(this);
        maleRadioButton.addActionListener(this);
        femaleRadioButton.addActionListener(this);
        browsCheckBox.addActionListener(this);
        sleepingCheckBox.addActionListener(this);
        travelingCheckBox.addActionListener(this);
    }

    public void handleCheckboxUpdate(JCheckBox checkbox) {
        String hobby = checkbox.getText();
        if (checkbox.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, hobby + " is one of the hobbies");
        } else {
            JOptionPane.showMessageDialog(rootPane, hobby + " is no longer one of the hobbies");
        }
    }

    public void handleGenderUpdate(String gender) {
        JOptionPane.showMessageDialog(rootPane, "Gender is updated to " + gender);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        
        if (source == readCheckBox || source == browsCheckBox || source == sleepingCheckBox || source == travelingCheckBox) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                handleCheckboxUpdate((JCheckBox) source);
            } else {
                handleCheckboxUpdate((JCheckBox) source);
            }
        }
    }


    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            handleSubmitButton();
        } else if (src == resetButton) {
            handleResetButton();
        } else if (src instanceof JTextField) {
            handleTextField((JTextField) src);
        } else if (src instanceof JCheckBox) {
            handleCheckboxUpdate((JCheckBox) src);
        } else if (src == maleRadioButton) {
            handleGenderUpdate("Male");
        } else if (src == femaleRadioButton) {
            handleGenderUpdate("Female");
        }
    }


    public static void createAndShowGUI() {
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }

}
