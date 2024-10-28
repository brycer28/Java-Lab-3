package GUI;

import DataHandling.PlayerStats;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
// shows a table of major stats for all players
public class TablePanel extends JPanel {
    private JTable table;
    private JScrollPane scrollPane;
    static String[] columnNames = {
            "Player","Games","PTS","AST","REB","STL","BLK","TOV"
    };

    public TablePanel(ArrayList<PlayerStats> data) {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(400 , 300));

        //create table and its models
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {};
        table = new JTable(tableModel);
        tableModel.setColumnIdentifiers(columnNames);
        TableColumnModel columnModel = table.getColumnModel();

        //set column sizes
        final int nameWidth = (int)(table.getPreferredSize().getWidth() * .15);
        final int remWidth = (1-nameWidth)/(columnNames.length-1);
        table.getColumnModel().getColumn(0).setPreferredWidth(nameWidth);
        for (int i = 1; i < columnNames.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(remWidth);
        }

        //add rows to table
        for (PlayerStats player : data) {
            Object[] rowData = getRowData(player);
            tableModel.addRow(rowData);
        }

        //add scroll pane
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        add(scrollPane);
    }

    public Object[] getRowData(PlayerStats player) {
        Object[] rowData = new Object[columnNames.length];
        rowData[0] = player.name();
        rowData[1] = player.GP();
        rowData[2] = player.PTS();
        rowData[3] = player.AST();
        rowData[4] = player.TRB();
        rowData[5] = player.STL();
        rowData[6] = player.BLK();
        rowData[7] = player.TOV();
        return rowData;
    }
}
