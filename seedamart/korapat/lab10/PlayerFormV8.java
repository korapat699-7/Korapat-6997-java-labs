package seedamart.korapat.lab10;

/*
 * PlayerFormV8 Programm :
 * - Player Form V8 is extends from Player Form V7 and implement ListSelectionListener.
 * - Overrides the method addListeners() such that the appropriate listener is added to the list.
 * - Implement the method valueChanged() that will handle when items in a list are selected. 
 *   When one or more items in a list are selected, a dialog message.
 *  
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 23 February 2024
 */

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import seedamart.korapat.lab9.PlayerFormV7;
public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {

    // Constructor for PlayerFormV8 class
    public PlayerFormV8(String title) {
        super(title); // Call constructor of superclass PlayerFormV7
        sportList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Set selection mode for sportList
        addListeners(); // Call method to add listeners
    }

    // Method to add listeners to sportList
    public void addListeners() {
        sportList.addListSelectionListener(this); // Add ListSelectionListener to sportList
    }

    // Method to handle valueChanged event of list selection
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { // Check if the event is not still in the process of being adjusted
            if (sportList.getSelectedIndices().length > 0) { // Check if any items are selected in sportList
                StringBuilder selectedItems = new StringBuilder(); // StringBuilder to store selected items
                for (int index : sportList.getSelectedIndices()) { // Iterate through selected indices
                    selectedItems.append(sportList.getModel().getElementAt(index)).append("  "); // Append selected item to StringBuilder
                }
                selectedItems.setLength(selectedItems.length() - 2); // Remove trailing comma and space
                // Display a dialog message with selected sports centered to the PlayerFormV8 window
                JOptionPane.showMessageDialog(this, "Selected sports are " + selectedItems.toString(),
                        "Selected Sports", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // Main method to create and show the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Call method to create and show GUI
            }
        });
    }

    // Method to create and show the GUI
    public static void createAndShowGUI() {
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8"); // Create instance of PlayerFormV8
        msw.addComponents(); // Call method to add components
        msw.setFrameFeatures(); // Call method to set frame features
        msw.addMenus(); // Call method to add menus
    }
}
