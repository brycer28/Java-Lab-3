package GUI;

import DataHandling.PlayerStats;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;

// shows a table of major stats for all players
public class TablePanel extends JPanel {
    private JTable table;
    private JScrollPane scrollPane;

    public TablePanel(ArrayList<PlayerStats> data) {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(Constants.SUB_PNL_WIDTH , Constants.SUB_PNL_HEIGHT));

        //create table and its models
        DefaultTableModel tableModel = new DefaultTableModel(Constants.COLUMN_NAMES, 0) {};
        table = new JTable(tableModel);
        tableModel.setColumnIdentifiers(Constants.COLUMN_NAMES);
        TableColumnModel columnModel = table.getColumnModel();

        //set column sizes
        final int nameWidth = (int)(table.getPreferredSize().getWidth() * .15);
        final int remWidth = (1-nameWidth)/(Constants.COLUMN_NAMES.length-1);
        table.getColumnModel().getColumn(0).setPreferredWidth(nameWidth);
        for (int i = 1; i < Constants.COLUMN_NAMES.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(remWidth);
        }

        //add rows to table
        for (PlayerStats player : data) {
            Object[] rowData = getRowData(player);
            tableModel.addRow(rowData);
        }

        //add scroll pane
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(Constants.SUB_PNL_WIDTH, Constants.SUB_PNL_HEIGHT));
        add(scrollPane);
    }

    public Object[] getRowData(PlayerStats player) {
        Object[] rowData = new Object[Constants.COLUMN_NAMES.length];
        for (int i = 0; i < Constants.COLUMN_NAMES.length; i++) {
            rowData[1] = Constants.COLUMN_NAMES[i];
        }
        return rowData;
    }
}
