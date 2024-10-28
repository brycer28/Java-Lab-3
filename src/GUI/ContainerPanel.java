package GUI;

import javax.swing.*;

public class ContainerPanel extends JPanel {
    private DataPanel dataPanel;
    private ControlPanel controlPanel;

    public ContainerPanel() {
        dataPanel = new DataPanel();
        controlPanel = new ControlPanel(dataPanel);


    }
}
