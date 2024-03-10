package seedamart.korapat.lab11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginFileGUI extends JFrame {
    private JTextField usernameField, passwordField;

    public LoginFileGUI() {
        setTitle("Login File");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);
        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        panel.add(saveButton);

        JButton openButton = new JButton("Open");
        openButton.addActionListener(new OpenButtonListener());
        panel.add(openButton);

        add(panel);
    }

    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(LoginFileGUI.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    PrintWriter writer = new PrintWriter(file + ".txt");
                    writer.println("user is " + username + " pass is " + password);
                    writer.close();
                    JOptionPane.showMessageDialog(LoginFileGUI.this,
                            "File saved successfully!", "Saved", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(LoginFileGUI.this,
                            "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    private class OpenButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(LoginFileGUI.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    StringBuilder content = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    reader.close();
                    
                    // Split the content by space and extract username and password
                    String[] parts = content.toString().split(" ");
                    String username = parts[2];
                    String password = parts[6];
                    
                    // Update textfields with retrieved username and password
                    usernameField.setText(username);
                    passwordField.setText(password);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(LoginFileGUI.this,
                            "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFileGUI().setVisible(true);
        });
    }
}
