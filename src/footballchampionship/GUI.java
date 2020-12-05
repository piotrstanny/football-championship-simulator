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
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    public GUI(List<FootballClub> clubsList, String title){
        super(title);

        // Table Set Up
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        getContentPane().add(new JScrollPane(table));

        // Navbar Set Up
        JPanel navBar = new NavBar();
        getContentPane().add(navBar, BorderLayout.SOUTH);


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

        // Sort
        TableRowSorter<TableModel> tableSorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(tableSorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(clubsList.size());
        sortKeys.add(new RowSorter.SortKey(7, SortOrder.DESCENDING));
        tableSorter.setSortKeys(sortKeys);
    }
}

class NavBar extends JPanel {

    public NavBar() {
        Dimension size = getPreferredSize();
        size.height = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Premier League Details"));

        JLabel leagueLabel = new JLabel("Display League table by:");

        JButton btnPoints = new JButton("Total Points");
        btnPoints.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("action was fired");
            }
        });

        JButton btnExit = new JButton("Exit Program");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton btnGoals = new JButton("Goals Scored");
        JButton btnWins = new JButton("Number of Wins");
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(leagueLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnPoints, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnGoals, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnWins, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(btnExit, gbc);
    }
}

