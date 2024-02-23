package seedamart.korapat.lab10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import seedamart.korapat.lab9.PlayerFormV7;

public class PlayerFormV8 extends PlayerFormV7 implements ActionListener, ListSelectionListener{
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV8(String title) {
        super(title);
        sportList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sportList.addListSelectionListener(this);
        
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (sportList.getSelectedIndices().length > 0) {
                StringBuilder selectedItems = new StringBuilder();
                for (int index : sportList.getSelectedIndices()) {
                    selectedItems.append(sportList.getModel().getElementAt(index)).append("  ");
                }
                selectedItems.setLength(selectedItems.length() - 2); // Remove trailing comma and space
                JOptionPane.showMessageDialog(this, "Selected sports are " + selectedItems.toString());
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
        PlayerFormV8 msw = new PlayerFormV8("Player Form V7");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }

}
