package seedamart.korapat.lab11;
import javax.swing.*;

import seedamart.korapat.lab10.PlayerFormV11;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PlayerFormV12 extends PlayerFormV11 {

    public PlayerFormV12(String title) {
        super(title);
        enableKeyboard();
    }

    // @Override
    // public void addListeners() {
    //     super.addListeners();
    //     if (nameTextField != null) {
    //         nameTextField.addKeyListener(new KeyAdapter() {
    //             @Override
    //             public void keyPressed(KeyEvent e) {
    //                 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    //                     handleTextField(nameTextField);
    //                 }
    //             }
    //         });
    //     }
    //     if (nationalityTextField != null) {
    //         nationalityTextField.addKeyListener(new KeyAdapter() {
    //             @Override
    //             public void keyReleased(KeyEvent e) {
    //                 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    //                     handleTextField(nationalityTextField);
    //                 }
    //             }
    //         });
    //     }
    //     if (dateBirthTextField != null) {
    //         dateBirthTextField.addKeyListener(new KeyAdapter() {
    //             @Override
    //             public void keyReleased(KeyEvent e) {
    //                 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    //                     handleTextField(dateBirthTextField);
    //                 }
    //             }
    //         });
    //     }
    // }


    @Override 
    public void handleTextField(JTextField textField) {
        if (textField == nameTextField)
            handleValidate(nameTextField, nationalityTextField);
        else if (textField == nationalityTextField)
            handleValidate(nationalityTextField, dateBirthTextField);
        else if (textField == dateBirthTextField)
            handleValidateDate(dateBirthTextField);
        
        // String text = textField.getText().trim();
        // Component nextComponent = getNextComponent(textField);
        // if (text.isEmpty()) {
        //     JOptionPane.showMessageDialog(this, "Please enter some data in " + textField.getName(), "Empty Field", JOptionPane.ERROR_MESSAGE);
        //     textField.requestFocusInWindow();
            
        //     if (nextComponent != null) {
        //         nextComponent.setEnabled(false);
        //     }
        // } else {
        //     JOptionPane.showMessageDialog(this, textField.getName() + " is changed to " + text, "Field Change", JOptionPane.INFORMATION_MESSAGE);
        //     if (nextComponent != null) {
        //         nextComponent.setEnabled(true);
        //     }
        // }
    }

    protected void handleValidate(JTextField currentTextField, JTextField nextTextField) {
        if (currentTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + currentTextField.getName(), "Empty Field", JOptionPane.ERROR_MESSAGE);
            currentTextField.requestFocusInWindow();
            nextTextField.setEnabled(false);
            nextTextField.setEnabled(false);
            
        } else {
            super.handleTextField(currentTextField);
            nextTextField.setEnabled(true);
            nextTextField.requestFocusInWindow();
        }
    }

    protected void handleValidateDate(JTextField dateField) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
            formatter.parse(dateField.getText());
            super.handleTextField(dateField);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid date in " + dateField.getName(), "Invalid Field", JOptionPane.ERROR_MESSAGE);
        }
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }
}
