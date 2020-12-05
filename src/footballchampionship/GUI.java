package footballchampionship;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        getContentPane().add(new JScrollPane(table));

        // Navbar Set Up
        JPanel navBar = new NavBar();
        getContentPane().add(navBar, BorderLayout.SOUTH);



        // Add components
//        c.add(sidebar, BorderLayout.SOUTH);
        //        c.add(new tableTemplate(clubsList), BorderLayout.EAST);

    }

    // Methods for displaying content
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

