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

    public GUI(List<FootballClub> clubsList, List<Match> matchesList, String title){
        super(title);

        // Layout Set Up
        JTable table = loadClubsTable(clubsList);
        JScrollPane tableScroll = new JScrollPane(table);
        getContentPane().add(tableScroll);
        JPanel navBar = new NavBar();
        getContentPane().add(navBar, BorderLayout.SOUTH);

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
        JButton btnMatches = new JButton("Display all matches played");
        btnMatches.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("action was fired");
                // Remove current and create new table
                getContentPane().remove(tableScroll);
                JTable table = loadMatchesTable(matchesList);
                JScrollPane tableScroll = new JScrollPane(table);
                getContentPane().add(tableScroll);
                // Refresh GUI
                getContentPane().repaint();
                getContentPane().revalidate();
            }
        });

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
        navBar.add(btnMatches, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        navBar.add(btnExit, gbc);
    }

    JTable loadClubsTable(List<FootballClub> clubsList) {
        String[] clubsListColumns = {
                "Club Name",
                "Matches played",
                "Wins",
                "Draws",
                "Losses",
                "Goals Scored",
                "Goals Received",
                "TOTAL POINTS"
        };

        DefaultTableModel tableModel = new DefaultTableModel(clubsListColumns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) return Integer.class;
                return super.getColumnClass(columnIndex);
            }
        };

        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(180);
        populateClubsList(clubsList, tableModel);
        return table;
    }

    JTable loadMatchesTable(List<Match> matchesList) {
        String[] matchesColumns = {"Club 1","Score","Date", "Score", "Club 2"};
        DefaultTableModel tableModel = new DefaultTableModel(matchesColumns, 0);
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        for (int i=0;i< matchesList.size();i++) {
            String date = matchesList.get(i).getDate();
            String club1Name = matchesList.get(i).getClub1Name();
            String club2Name = matchesList.get(i).getClub2Name();
            int club1Score = matchesList.get(i).getClub1Score();
            int club2Score = matchesList.get(i).getClub2Score();
            Object[] data = {club1Name, club1Score, date, club2Score, club2Name};
            tableModel.addRow(data);
        }
        return table;
    }

    void populateClubsList(List<FootballClub> clubsList, DefaultTableModel tableModel) {
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

            Object[] data = {clubName, matchesPlayed, wins, draws, defeats, goalsScored, goalsReceived, points};
            tableModel.addRow(data);
        }
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

