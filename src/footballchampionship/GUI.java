package footballchampionship;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI {

    public GUI(List<FootballClub> clubsList) {

//        SwingUtilities.invokeLater(new Runnable())
        JFrame frame = new JFrame ("Football Championship Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        JButton button = new JButton("Show all played matches");
        frame.getContentPane().add(button);
        button.addActionListener(new MyActionListener());

        JLabel label = new JLabel("Name of the club: ");
        JTextField field = new JTextField(25);
        Container c = frame.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.add(label);
        c.add(field);

        // Insert table into main window
        frame.getContentPane().add(new tableTemplate(clubsList));

        frame.setSize(900,500);
        frame.setVisible(true);
    }
}
// button event handler class
class MyActionListener implements ActionListener {
    private int i = 1;

    public void actionPerformed(ActionEvent e) {
        System.out.println(" Pressed Button " + i ++ + " th time ! " );
    }
}

// Class for building a table
class tableTemplate extends JPanel {

    public tableTemplate(List<FootballClub> clubsList) {

        String[] columnNames = {
            "Club Name",
            "Matches played",
            "Wins",
            "Draws",
            "Losses",
            "Goals scored",
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
        table.getColumnModel().getColumn(7).setPreferredWidth(150);

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