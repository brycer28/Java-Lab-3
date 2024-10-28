package GUI;

import DataHandling.FileReader;
import DataHandling.PlayerStats;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DataVisualizer {
    public static void main(String[] args) {
        //set up frame
        JFrame frame = new JFrame("UARK Basketball Statistics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        DataPanel dataPanel = new DataPanel();
        ControlPanel controlPanel = new ControlPanel(dataPanel);
        frame.add(dataPanel, BorderLayout.NORTH);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
