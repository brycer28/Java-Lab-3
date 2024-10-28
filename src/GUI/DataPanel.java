package GUI;

import DataHandling.FileReader;
import DataHandling.PlayerStats;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DataPanel extends JPanel {
    private JPanel containerPanel = new JPanel();
    private JPanel tablePanel;
    private JPanel detailsPanel;
    private JPanel statsPanel;
    private JPanel chartPanel;
    private ArrayList<PlayerStats> data;

    public DataPanel() {
        String defaultPath = "C::\\Users\\User\\INTELLIJ\\Lab 3\\Data\\UARK_Basketball_Stats_2018.csv";

        //set up frame
        setPreferredSize(new Dimension(800, 600));
        setLayout(new GridLayout(2,2));
        //set up default data
        updateDisplay(2019);
    }

    // takes in a year (from
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

}
