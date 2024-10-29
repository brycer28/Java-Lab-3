package GUI;

import DataHandling.PlayerStats;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// panel to hold dataPanel and controlPanel
public class ContainerPanel extends JPanel {
    private DataPanel dataPanel;
    private ControlPanel controlPanel;
    private ArrayList<PlayerStats> data;

    // panel to hold dataPanel and controlPanel
    public ContainerPanel() {
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        setLayout(new BorderLayout());

        //set up default data (dataPanel will set default details in the constructor)
        dataPanel = new DataPanel(Constants.YEARS[0], null, this);
        controlPanel = new ControlPanel(dataPanel);

        dataPanel.setContainerPanel(this);// this lets them call updateDisplay
        controlPanel.setContainerPanel(this);

        //add subpanels
        add(dataPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
    }

    // method to update display
    // gets state of controlPanel's JComboBox and tablePanel's selected row to redraw table and details
    public void updateDisplay() {
        data = dataPanel.getData();

        // get year to update table to
        int year = controlPanel.getSelectedYear();

        // get player details to update details panel to
        int selectedRow = TablePanel.getSelectedRow();
        if (selectedRow < 0) {selectedRow = 0;}

        String playerName = TablePanel.getTable().getModel().getValueAt(selectedRow, 0).toString();
        PlayerStats detailStats = null;
        for (PlayerStats p : data) {
            if (p.name().equals(playerName)) {
                detailStats = p;
            }
        }

        // remove all components and redraw according to new parameters
        this.removeAll();

        // create new components
        dataPanel = new DataPanel(year, detailStats, this);
        controlPanel = new ControlPanel(dataPanel);

        // resets the container panel each time display is refreshed
        // otherwise filter could only be changed once, then 'this' is irrelevant
        controlPanel.setContainerPanel(this);

        // add new components and refresh display
        add(dataPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        repaint();
        revalidate();
    }
}
