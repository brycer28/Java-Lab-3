package GUI;

import DataHandling.PlayerStats;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// calculate leaders in various statistics categories
public class StatsPanel extends JPanel {

    // show team averages for major stats
    public StatsPanel(ArrayList<PlayerStats> data, int year) {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(Constants.SUB_PNL_WIDTH, Constants.SUB_PNL_HEIGHT));
        setLayout(new GridLayout(Constants.COLUMN_NAMES.length, 1));

        //for each stat showed on the table panel, use streams to calculate the team average
        double avgPts = data.stream().mapToDouble(PlayerStats::PTS).average().orElse(0);
        double avgReb = data.stream().mapToDouble(PlayerStats::TRB).average().orElse(0);
        double avgAst = data.stream().mapToDouble(PlayerStats::AST).average().orElse(0);
        double avgStl = data.stream().mapToDouble(PlayerStats::STL).average().orElse(0);
        double avgBlk = data.stream().mapToDouble(PlayerStats::BLK).average().orElse(0);
        double avgTov = data.stream().mapToDouble(PlayerStats::TOV).average().orElse(0);

        //add text to panels
        add(new JLabel("Team Averages for " + year + "-" + (year+1) + " Season: "));
        add(new JLabel(" "));
        add(new JLabel("Avg PTS: " + formatTwoDecimals(avgPts)));
        add(new JLabel("Avg Reb: " + formatTwoDecimals(avgReb)));
        add(new JLabel("Avg Ast: " + formatTwoDecimals(avgAst)));
        add(new JLabel("Avg Stl: " + formatTwoDecimals(avgStl)));
        add(new JLabel("Avg Blk: " + formatTwoDecimals(avgBlk)));
        add(new JLabel("Avg Tov: " + formatTwoDecimals(avgTov)));
    }

    // formats averages to 2 decimal points
    // i have no idea why java doesn't have an easier way to do this like setPrecision() in C++
    public static double formatTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
