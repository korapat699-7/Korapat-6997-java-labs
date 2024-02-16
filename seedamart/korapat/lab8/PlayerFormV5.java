package seedamart.korapat.lab8;

/* 
 * PlayerFormV5 Program:
 * PlayerFormV5 class extends from PlayerFormV4
 * 
 * In this program just add component icon and image from other directory 
 * to set icon for menu and put "Football.jpg" between notePanel and buttonPanel
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 16 February 2024
 */
import javax.swing.*;
import java.awt.*;;
public class PlayerFormV5 extends PlayerFormV4 {
    protected ImageIcon newIcon, saveIcon, openIcon;
    protected JPanel jpgPanel, midPanel;
    protected JButton resetButton, submitButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV5(String title) {
        super(title);
        propPanel = new JPanel(new GridLayout(4, 1));
        midPanel = new JPanel(new BorderLayout());
        jpgPanel = new JPanel(new BorderLayout());

        ReadImage read = new ReadImage();
        newIcon = new ImageIcon("seedamart/korapat/lab8/images/New-icon.png");
        saveIcon = new ImageIcon("seedamart/korapat/lab8/images/Save-icon.png");
        openIcon = new ImageIcon("seedamart/korapat/lab8/images/Open-icon.png");

        newMenu.setIcon(newIcon);
        saveMenu.setIcon(saveIcon);
        openMenu.setIcon(openIcon);
        jpgPanel.add(read);

        // Initialize buttons
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        // Adding buttons to buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
    }

    protected void addComponents() {
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
        JScrollPane scrollPane = new JScrollPane(noteTextArea);
        notePanel.add(scrollPane);

        // Combining leftPanel and rightPanel in mainPanel
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Adding components to midPanel
        propPanel.add(hobbiesPanel);
        propPanel.add(sportlistPanel);
        propPanel.add(yearPanel);
        propPanel.add(notePanel);

        midPanel.add(propPanel, BorderLayout.NORTH);
        midPanel.add(jpgPanel, BorderLayout.CENTER);
        midPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adding mainPanel, midPanel, and buttonPanel to the content pane with specified layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.NORTH);
        getContentPane().add(midPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();
    }
}
