package GUI;

import DataHandling.PlayerStats;

import javax.swing.*;
import java.awt.*;

// show a detailed list of all stats for a specific player
public class DetailsPanel extends JPanel {
    final int NUM_ROWS = 5;

    public DetailsPanel(PlayerStats playerStats) {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(Constants.SUB_PNL_WIDTH, Constants.SUB_PNL_HEIGHT));
        setLayout(new GridLayout(NUM_ROWS, 2));

        //add text to panel
        add(new JLabel("Summary: "));
        add(new JLabel(playerStats.name()));

        add(new JLabel("Field Goals (Made / Att. / %):"));
        add(new JLabel(playerStats.FG() + " / " + playerStats.FGA() + " / " + playerStats.FGP()));

        add(new JLabel("Field Goals (2-pt): "));
        add(new JLabel(playerStats.FG2() + " / " + playerStats.FG2A() + " / " + playerStats.FG2P()));

        add(new JLabel("Field Goals (3-pt): "));
        add(new JLabel(playerStats.FG3() + " / " + playerStats.FG3A() + " / " + playerStats.FG3P()));

        add(new JLabel("Free Throws: "));
        add(new JLabel(playerStats.FT() + " / " + playerStats.FTA() + " / " + playerStats.FTP()));

    }
}
