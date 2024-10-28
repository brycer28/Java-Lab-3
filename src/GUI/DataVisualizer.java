package GUI;

import javax.swing.*;
import java.awt.*;

// runner class for data visualization
public class DataVisualizer {
    public static void main(String[] args) {
        //set up frame
        JFrame frame = new JFrame("UARK Basketball Statistics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //set up components
        DataPanel dataPanel = new DataPanel();
        ControlPanel controlPanel = new ControlPanel(dataPanel);
        frame.add(dataPanel, BorderLayout.NORTH);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}

class Constants {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int CTRL_PNL_HEIGHT = 100;
    public static final int SUB_PNL_WIDTH = 400;
    public static final int SUB_PNL_HEIGHT = 300;
    public static final int[] YEARS = {
            2023, 2022, 2021, 2020, 2019, 2018
    };
    static String[] COLUMN_NAMES = {
            "Player","Games","PTS","AST","REB","STL","BLK","TOV"
    };
}