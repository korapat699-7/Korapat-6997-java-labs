package seedamart.korapat.lab11;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PlayerFormV14 extends PlayerFormV13 {
    public static JMenu fillJMenu;
    public static JRadioButtonMenuItem yesJMenu, noJMenu;
    public static ButtonGroup selectedButtonGroup;
    public static String genderGroup;

    public PlayerFormV14(String title) {
        super(title);
        fillJMenu = new JMenu("Fill");
        yesJMenu = new JRadioButtonMenuItem("Yes");
        noJMenu = new JRadioButtonMenuItem("No");
        selectedButtonGroup = new ButtonGroup();
        selectedButtonGroup.add(yesJMenu);
        selectedButtonGroup.add(noJMenu);
        
    }

    @Override
    public void handleSaveMenu() {
        if (femaleRadioButton.isSelected()) {
            genderGroup = "Female";
        } else if (maleRadioButton.isSelected()) {
            genderGroup = "Male";
        }
        String nameString = nameTextField.getText();
        String nationString = nationalityTextField.getText();
        String dateString = dateBirthTextField.getText();

        if (yesJMenu.isSelected()) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSave))) {
                    oos.writeObject(new Credential(nameString, nationString, dateString, genderGroup, playertype, hobbies, sports));
                    JOptionPane.showMessageDialog(this, "Data saved successfully");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving data");
                }
            }
        } else {
            super.handleSaveMenu();
        }
    }

   @Override
public void handleOpenMenu() {
    if (yesJMenu.isSelected()) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileToOpen))) {
                Object obj = ois.readObject();
                if (obj instanceof Credential) {
                    Credential credential = (Credential) obj;
                    nameTextField.setText(credential.getName());
                    nationalityTextField.setText(credential.getNationality());
                    dateBirthTextField.setText(credential.getDate());

                    if(credential.getGender().equals("Female")) {
                        femaleRadioButton.setSelected(true);
                    } else if (credential.getGender().equals("Male")) {
                        maleRadioButton.setSelected(true);
                    }

                    String playerType = credential.getPlayer();
                    if (playerType.equals("Amateur")) {
                        DifficultcomboBox.setSelectedItem("Amateur");
                    } else if (playerType.equals("Professional")) {
                        DifficultcomboBox.setSelectedItem("Professional");
                    } else if (playerType.equals("Beginner")) {
                        DifficultcomboBox.setSelectedItem("Beginner");
                    }

                    String hobbies = credential.getHobbies();
                    String[] hobbyArray = hobbies.split(" ");
                    for (String hobby : hobbyArray) {
                        switch (hobby) {
                            case "Reading":
                                readCheckBox.setSelected(true);
                                break;
                            case "Browsing":
                                browsCheckBox.setSelected(true);
                                break;
                            case "Sleeping":
                                sleepingCheckBox.setSelected(true);
                                break;
                            case "Traveling":
                                travelingCheckBox.setSelected(true);
                                break;
                        }
                    }

                    



                    JOptionPane.showMessageDialog(this, "Data loaded successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid data format");
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading data");
            }
        }
    } else {
        super.handleOpenMenu();
    }
}

    public void addMenus() {
        super.addMenus();
        menuBar.add(fillJMenu);
        
        // Set "No" menu item as selected
        noJMenu.setSelected(true);

        fillJMenu.add(yesJMenu);
        fillJMenu.add(noJMenu);

        this.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        PlayerFormV14 msw = new PlayerFormV14("Player Form V14");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }

    private static class Credential implements Serializable {
        private String name;
        private String nationality;
        private String date;
        private String gender;
        private String playertype;
        private String hobbies;
        private String sports;

 
        public Credential(String name, String nationality, String date, String gender, String playertype,String hobbies, String sports) {
            this.name = name;
            this.nationality = nationality;
            this.date = date;
            this.gender = gender;
            this.playertype = playertype;
            this.hobbies = hobbies;
            this.sports = sports;
        }

        public String getName() {
            return name;
        }

        public String getNationality() {
            return nationality;
        }
        public String getDate() {
            return date;
        }
        public String getGender() {
            return gender;
        }
        public String getPlayer() {
            return playertype;
        }

        public String getHobbies() {
            return hobbies;
        }
        public String getSport() {
            return sports;
        }


    }
}
