package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

//panel to hold controls for interacting with data set
public class ControlPanel extends JPanel {
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
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //create yearSelector and three filters
        yearSelector = new JComboBox<>(YEARS);
        yearSelector.setSelectedIndex(0);
        yearSelector.setSize(new Dimension(40, 20));
        filter1 = new JCheckBox("Filter 1");
        filter2 = new JCheckBox("Filter 2");
        filter3 = new JCheckBox("Filter 3");

        //add action listeners to year selector
        yearSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String strYear = (String) yearSelector.getSelectedItem();
                    int year = Integer.parseInt(strYear);
                    dataPanel.updateDisplay(year);
                } catch (NullPointerException npe) {
                    System.out.println(npe);
                    yearSelector.setSelectedIndex(0);
                    throw npe;
                }
            }
        });

        //add components to controlPanel
        add(yearSelector);
        add(filter1);
        add(filter2);
        add(filter3);

    }
}
