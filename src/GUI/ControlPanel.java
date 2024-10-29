package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

//panel to hold controls for interacting with data set
public class ControlPanel extends JPanel {
    public ContainerPanel containerPanel;
    public JComboBox yearSelector;
    public JCheckBox filter1;
    public JCheckBox filter2;
    public JCheckBox filter3;
    public final String[] YEARS = Arrays.stream(Constants.YEARS)
            .mapToObj(String::valueOf).toArray(String[]::new);

    // create a control panel to navigate the data
    // takes in a mainPanel object for action listeners to call updateDisplay
    public ControlPanel(DataPanel dataPanel) {
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.CTRL_PNL_HEIGHT));
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 40 ));

        //create yearSelector and three filters
        yearSelector = new JComboBox<>(YEARS);
        yearSelector.setSize(new Dimension(40, 20));
        filter1 = new JCheckBox("Filter 1");
        filter2 = new JCheckBox("Filter 2");
        filter3 = new JCheckBox("Filter 3");

        //add components to controlPanel
        add(yearSelector);
        add(filter1);
        add(filter2);
        add(filter3);

        //add action listener to year selector to updateDisplay
        yearSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    containerPanel.updateDisplay();
                } catch (NullPointerException npe) {
                    throw npe;
                }
            }
        });
    }

    // return the selected year
    public int getSelectedYear() {
        String strYear = yearSelector.getSelectedItem().toString();
        return (int) Integer.parseInt(strYear);
    }

    // set this objects containerPanel to pass down updateDisplay method
    public void setContainerPanel(ContainerPanel containerPanel) {
        this.containerPanel = containerPanel;
    }
}
