package footballchampionship;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarPanel extends JPanel {

    private EventListenerList listenerList = new EventListenerList();

    SidebarPanel() {
        Dimension size = getPreferredSize();
        size.height = 200;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Premier League Details"));

        JLabel leagueLabel = new JLabel("Display League table by:");

        JButton btnPoints = new JButton("Total Points");
        btnPoints.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String action = "RankingByPoints";
                System.out.println("action was fired");
                fireSidebarEvent(new SidebarEvent(this, action));
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

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(leagueLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(btnPoints, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(btnGoals, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(btnWins, gbc);
    }

    public void fireSidebarEvent(SidebarEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==SidebarListener.class) {
                ((SidebarListener)listeners[i+1]).sidebarEventOccurred(event);
            }
        }
    }

    public void addSidebarListener(SidebarListener listener) {
        listenerList.add(SidebarListener.class, listener);
    }

    public void removeSidebarListener(SidebarListener listener) {
        listenerList.remove(SidebarListener.class, listener);
    }
}
