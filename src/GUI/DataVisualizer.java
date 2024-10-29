package GUI;

import javax.swing.*;
import java.awt.*;

// runner class for data visualization
public class DataVisualizer {
    public static void main(String[] args) {
        //set up frame
        JFrame frame = new JFrame("UARK Basketball Statistics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //set up components
        ContainerPanel containerPanel = new ContainerPanel();

        frame.add(containerPanel);

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
    public static final int FRAME_WIDTH = WIDTH + 100;
    public static final int FRAME_HEIGHT = HEIGHT + 100;
    public static final int[] YEARS = {
            2023, 2022, 2021, 2020, 2019, 2018
    };
    public static final String[] COLUMN_NAMES = {
            "Player","Games","PTS","AST","REB","STL","BLK","TOV"
    };
    public static final String CSV_HEADER =
            "Data/UARK_Basketball_Stats_"; // for clarity, just need to add year and file extension
}