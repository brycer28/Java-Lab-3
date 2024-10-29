package GUI;

import DataHandling.FileReader;
import DataHandling.PlayerStats;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// panel to display 4 data visualizations
public class DataPanel extends JPanel {
    private ArrayList<PlayerStats> data;
    private ContainerPanel containerPanel;
    private JPanel tablePanel;
    private JPanel detailsPanel;
    private JPanel statsPanel;
    private JPanel chartPanel;

    // create a data panel and update display
    public DataPanel(int year, PlayerStats detailData, ContainerPanel containerPanel) {
        //set up frame
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        setLayout(new GridLayout(2,2));

        //set up default data
        try {
            data = FileReader.readPlayerStats((Constants.CSV_HEADER + year + ".csv"));

            //if no playerName provided, default to first player (for default constructor)
            if (detailData == null) {
                detailData = data.getFirst();
            }

            //create each sub-panel
            tablePanel = new TablePanel(data, containerPanel);
            detailsPanel = new DetailsPanel(detailData, year);
            statsPanel = new StatsPanel(data, year);
            chartPanel = new ChartPanel();

            //add panels to this
            add(tablePanel);
            add(statsPanel);
            add(detailsPanel);
            add(chartPanel);

            //refresh display
            repaint();
            revalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // set an objects containerPanel to pass down updateDisplay method to table and control panels
    public void setContainerPanel(ContainerPanel containerPanel) {
        this.containerPanel = containerPanel;
    }

    // get the data set being used for this instance of dataPanel
    public ArrayList<PlayerStats> getData() {
        return data;
    }
}
