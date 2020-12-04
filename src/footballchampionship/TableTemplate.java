package footballchampionship;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// Class for building a table
class tableTemplate extends JPanel {

    tableTemplate(List<FootballClub> clubsList) {

        Dimension size = getPreferredSize();
        size.width = 600;
        setPreferredSize(size);

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
        final JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        table.getColumnModel().getColumn(0).setPreferredWidth(350);
        table.getColumnModel().getColumn(5).setPreferredWidth(250);
        table.getColumnModel().getColumn(6).setPreferredWidth(250);
        table.getColumnModel().getColumn(7).setPreferredWidth(250);

        // Access clubs data and add to the table
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
    }
}