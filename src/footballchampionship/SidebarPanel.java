package footballchampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarPanel extends JPanel {

    SidebarPanel() {
        Dimension size = getPreferredSize();
        size.width = 300;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Premier League Details"));

        JLabel leagueLabel = new JLabel("Display League table by:");

        JButton btnPoints = new JButton("Total Points");
        btnPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sort by total points");
            }
        });

        JButton btnGoals = new JButton("Goals Scored");
        JButton btnWins = new JButton("Number of Wins");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        ///// Display League Table section //////

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

    }
}
