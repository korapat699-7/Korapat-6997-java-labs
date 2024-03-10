package seedamart.korapat.lab11;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;

public class PlayerFormV13 extends PlayerFormV12 {
    PrintWriter filenamePrintWriter;
    String sportListSaved;

    public PlayerFormV13(String title) {
        super(title);
        enableKeyboard();
    }

    @Override
    public void handleSaveMenu() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Saving in file " + filePath);
            try {
                PrintWriter writer = new PrintWriter(filePath);
                writer.println(nameTextField.getText() + " has nationality as " + nationalityTextField.getText() + " and was born on " + dateBirthTextField.getText()
                        + ", has gender as " + gender
                        + ", is a " + playertype + " player, has hobbies as " + hobbies + "and plays " + sportListSaved);
                writer.close();
                JOptionPane.showMessageDialog(this,
                        "File saved successfully!", "Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    @Override
    public void handleOpenMenu() {

        // Display open file dialog
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                
                while((line = reader.readLine()) != null) {
                    JOptionPane.showMessageDialog(this, "Data Read form file " + filePath + " is\n" + line);
                }   
                

                
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { 
            if (sportList.getSelectedIndices().length > 0) { 
                StringBuilder selectedItems = new StringBuilder(); 
                for (int index : sportList.getSelectedIndices()) { 
                    selectedItems.append(sportList.getModel().getElementAt(index)).append("  "); 
                }
                selectedItems.setLength(selectedItems.length() - 2); 
                JOptionPane.showMessageDialog(this, "Selected sports are " + selectedItems.toString(),
                        "Selected Sports", JOptionPane.INFORMATION_MESSAGE);
                        sportListSaved = selectedItems.toString();
            }
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        PlayerFormV13 msw = new PlayerFormV13("Player Form V13");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }

}
