package seedamart.korapat.lab10;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class MultiSelectionJListExample extends JFrame implements ListSelectionListener {
    private JList<String> itemList;

    public MultiSelectionJListExample() {
        super("Multi Selection JList Example");

        String[] items = {"Football", "Badminton", "Hockey"};
        itemList = new JList<>(items);
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        itemList.addListSelectionListener(this);

        JScrollPane scrollPane = new JScrollPane(itemList);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (itemList.getSelectedIndices().length > 0) {
                StringBuilder selectedItems = new StringBuilder();
                for (int index : itemList.getSelectedIndices()) {
                    selectedItems.append(itemList.getModel().getElementAt(index)).append(", ");
                }
                selectedItems.setLength(selectedItems.length() - 2); // Remove trailing comma and space
                JOptionPane.showMessageDialog(this, "Selected items: " + selectedItems.toString());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MultiSelectionJListExample();
            }
        });
    }
}
