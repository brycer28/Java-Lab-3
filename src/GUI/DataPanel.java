package GUI;

import DataHandling.FileReader;
import DataHandling.PlayerStats;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// panel to display 4 data visualizations
public class DataPanel extends JPanel {
    private JPanel containerPanel = new JPanel();
    private JPanel tablePanel;
    private JPanel detailsPanel;
    private JPanel statsPanel;
    private JPanel chartPanel;
    private ArrayList<PlayerStats> data;

    // create a data panel and update display
    public DataPanel() {
        //set up frame
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        setLayout(new GridLayout(2,2));

        //set up default data
        updateDisplay(Constants.YEARS[0]);
    }

    // takes in a year (from 2023-2018) and updates data panels accordingly
    public void updateDisplay(int year) {
        this.removeAll();

        String csvPath = "C:\\Users\\User\\INTELLIJ\\Lab 3\\Data\\UARK_Basketball_Stats_" + year + ".csv";
        System.out.println(csvPath);

        try {
            data = FileReader.readPlayerStats(csvPath);

            //create each sub-panel
            tablePanel = new TablePanel(data);
            detailsPanel = new DetailsPanel(data.get(1));
            statsPanel = new StatsPanel(data);
            chartPanel = new ChartPanel();

            //add panels to this
            add(tablePanel);
            add(statsPanel);
            add(detailsPanel);
            add(chartPanel);

            repaint();
            revalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
