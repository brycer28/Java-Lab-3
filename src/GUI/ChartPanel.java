package GUI;

import javax.swing.*;
import java.awt.*;

// display data or subset in a chart
public class ChartPanel extends JPanel {
    public ChartPanel() {
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridBagLayout());

        // could not implement JFreeChart - ran out of time :(

        JLabel label = new JLabel("Could not implement chart :(");
        add(label);
    }
}
