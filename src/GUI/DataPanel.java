package GUI;

import DataHandling.FileReader;
import DataHandling.PlayerStats;
import GUI.TablePanel;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// panel to display 4 data visualizations
public class DataPanel extends JPanel {
    private ArrayList<PlayerStats> data;
    private PlayerStats detailData;
    private JPanel tablePanel;
    private JPanel detailsPanel;
    private JPanel statsPanel;
    private JPanel chartPanel;


    // create a data panel and update display
    public DataPanel() {
        //set up frame
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        setLayout(new GridLayout(2,2));

        //set up default data
        updateDisplay(Constants.YEARS[0], "");
    }

    public interface DisplayUpdater {
        void updateDisplay(int year, String playerName);
    }

    // takes in a year (from 2023-2018) and updates data panels accordingly
    public void updateDisplay(int year, String playerName) {
        this.removeAll();

        String csvPath = "C:\\Users\\User\\INTELLIJ\\Lab 3\\Data\\UARK_Basketball_Stats_" + year + ".csv";
        System.out.println(csvPath);

        try {
            data = FileReader.readPlayerStats(csvPath);

            //if no playerName provided, default to first player
            //NOTE: this is because the controlPanel doesn't have access to selecting player, but table listener
            //should be able to update using the same method.
            if (playerName == "") {
                playerName = data.get(0).name();
            }

            //get playerStats based on name
            for (PlayerStats playerStats : data) {
                if (playerStats.name().equals(playerName)){
                    detailData = playerStats;
                } else {
                    detailData = data.get(0);
                }
            }

            //create each sub-panel
            tablePanel = new TablePanel(data);
            detailsPanel = new DetailsPanel(detailData);
            statsPanel = new StatsPanel(data);
            chartPanel = new ChartPanel();

            //create details panel based on table contents

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
