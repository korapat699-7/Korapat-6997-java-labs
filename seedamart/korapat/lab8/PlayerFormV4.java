package seedamart.korapat.lab8;

/* 
 * PlayerFormV4 Program:
 * PlayerFormV4 class extends from PlayerFormV3
 * In this program adds checkboxes, a list, and a slider.
 * 
 * In checkboxes for hobbies have four items:
 *  1. Reading
 *  2. Browsing
 *  3. Sleeping
 *  4. Traveling
 * 
 *  (Sleeping is default.)
 * 
 * In list for sport have four items:
 *  1. Badminton
 *  2. Boxing
 *  3. Football
 *  4. Running
 * 
 *  (Football is default.)
 * 
 * slider for the number of years have a range from 1 to 20.
 * 
 * Author: Korapat Seedamart
 * ID: 653040699-7
 * Sec: 2
 * Date: 16 February 2024
 */


import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {
    protected JLabel hobbiesLabel, sportLabel, yearLabel;
    protected JPanel hobbiesPanel, propPanel, checkboxPanel, sportlistPanel, yearPanel, boxPanel;
    protected JCheckBox readCheckBox, browsCheckBox, sleepingCheckBox, travelingCheckBox;
    protected ButtonGroup hobbiesButtonGroup;
    protected JList<String> sportList;
    protected JSlider sportSlider;
    protected JPanel allPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV4(String title) {
        super(title);
        hobbiesPanel = new JPanel(new GridLayout(2, 1));
        hobbiesLabel = new JLabel("Hobbies :");

        checkboxPanel = new JPanel(new FlowLayout());

        readCheckBox = new JCheckBox("Reading");
        browsCheckBox = new JCheckBox("Browsing");
        sleepingCheckBox = new JCheckBox("Sleeping");
        travelingCheckBox = new JCheckBox("Traveling");
        hobbiesButtonGroup = new ButtonGroup();
        sleepingCheckBox.setSelected(true);
        propPanel = new JPanel(new GridLayout(4, 2));

        sportLabel = new JLabel("Sport :");
        sportlistPanel = new JPanel(new GridLayout(1, 2));
        String[] data = { "Batminton", "Boxing", "Football", "Running" };
        sportList = new JList<>(data);
        sportList.setSelectedValue("Football", true);

        yearPanel = new JPanel(new GridLayout(2, 1));
        yearLabel = new JLabel("Year of experience in this sport:");

        sportSlider = new JSlider(0, 20, 0);
        sportSlider.setPaintTicks(true);
        sportSlider.setMinorTickSpacing(1);
        sportSlider.setPaintTrack(true);
        sportSlider.setMajorTickSpacing(5);
        sportSlider.setPaintLabels(true);

        yearPanel.add(yearLabel);
        yearPanel.add(sportSlider);

        hobbiesButtonGroup.add(readCheckBox);
        hobbiesButtonGroup.add(browsCheckBox);
        hobbiesButtonGroup.add(sleepingCheckBox);
        hobbiesButtonGroup.add(travelingCheckBox);

        checkboxPanel.add(readCheckBox);
        checkboxPanel.add(browsCheckBox);
        checkboxPanel.add(sleepingCheckBox);
        checkboxPanel.add(travelingCheckBox);

        hobbiesPanel.add(hobbiesLabel);
        hobbiesPanel.add(checkboxPanel);
        sportlistPanel.add(sportLabel);
        sportlistPanel.add(sportList);
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
        scrollPane = new JScrollPane(noteTextArea);
        notePanel.add(scrollPane);

        // Combining leftPanel and rightPanel in mainPanel
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Adding buttons to buttonPanel
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        propPanel.add(hobbiesPanel);
        propPanel.add(sportlistPanel);
        propPanel.add(yearPanel);
        propPanel.add(notePanel);
        // Adding mainPanel, notePanel, and buttonPanel to the content pane with
        // specified layout
        getContentPane().add(mainPanel, BorderLayout.NORTH);
        getContentPane().add(propPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addMenus();

    }

}