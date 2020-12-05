package footballchampionship;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

    String[] columnNames = {
            "Club Name",
            "Matches played",
            "Wins",
            "Draws",
            "Losses",
            "Goals Scored",
            "Goals Received",
            "TOTAL POINTS"
    };
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) return Integer.class;
            return super.getColumnClass(columnIndex);
        }
    };

    /////// CONSTRUCTOR STARTS HERE ///////
    public GUI(List<FootballClub> clubsList, String title){
        super(title);

        // Table Set Up
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);

        // Access clubs data and load to the table
        for (int i = 0; i < clubsList.size(); i++) {
            String clubName = (clubsList.get(i)).getName();
            int matchesPlayed = (clubsList.get(i)).getMatchesPlayed();
            int wins = (clubsList.get(i)).getWins();
            int draws = (clubsList.get(i)).getDraws();
            int defeats = (clubsList.get(i)).getDefeats();
            int goalsScored = (clubsList.get(i)).getGoalsScored();
            int goalsReceived = (clubsList.get(i)).getGoalsReceived();
            int points = (clubsList.get(i)).getPoints();

            Object[] data = {
                    clubName,
                    matchesPlayed,
                    wins,
                    draws,
                    defeats,
                    goalsScored,
                    goalsReceived,
                    points
            };
            tableModel.addRow(data);
        }


        // Navbar buttons
        JLabel leagueLabel = new JLabel("Display League table by:");
        JButton btnPoints = new JButton("Total Points");
        btnPoints.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("action was fired");
                int columnIndex = 7;
                sortTable(columnIndex, clubsList, table);
            }
        });
        JButton btnGoals = new JButton("Goals Scored");
        btnGoals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("action was fired");
                int columnIndex = 5;
                sortTable(columnIndex, clubsList, table);
            }
        });
        JButton btnWins = new JButton("Number of Wins");
        btnWins.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("action was fired");
                int columnIndex = 2;
                sortTable(columnIndex, clubsList, table);
            }
        });
        JButton btnExit = new JButton("Exit Program");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Layout Set Up
        getContentPane().add(new JScrollPane(table));
        JPanel navBar = new NavBar();
        getContentPane().add(navBar, BorderLayout.SOUTH);


        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.anchor = GridBagConstraints.PAGE_START;
//        gbc.insets = new Insets(20,10,10,10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        navBar.add(leagueLabel, gbc);
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        navBar.add(btnPoints, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        navBar.add(btnGoals, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        navBar.add(btnWins, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        navBar.add(btnExit, gbc);
    }

    void sortTable(int columnIndex, List<FootballClub> clubsList, JTable table) {
        TableRowSorter<TableModel> tableSorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(tableSorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(clubsList.size());
        sortKeys.add(new RowSorter.SortKey(columnIndex, SortOrder.DESCENDING));
        tableSorter.setSortKeys(sortKeys);
    }

}

class NavBar extends JPanel {

    public NavBar() {
        Dimension size = getPreferredSize();
        size.height = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Premier League Details"));
        setLayout(new GridBagLayout());
    }
}

