package footballchampionship;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class oldGUI {

    public oldGUI(List<FootballClub> clubsList) {
        // Frame and Panels
        JFrame frame = new JFrame ("Football Championship Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Container c = frame.getContentPane();
        SidebarPanel sidebar = new SidebarPanel();
        c.add(new tableTemplate(clubsList), BorderLayout.EAST);

        sidebar.addSidebarListener(new SidebarListener() {
            public void sidebarEventOccurred(SidebarEvent event) {
                // action to execute depending on event received
                String action = event.getAction();
                System.out.println(action);
                c.add(new tableTemplate(clubsList), BorderLayout.EAST);
//                if (action.equals("RankingByPoints")) {
//                    c.add(new tableTemplate(clubsList), BorderLayout.EAST);
//                }
            }
        });

        frame.setSize(900,500);
        frame.setVisible(true);

        // Adding components to  Content Pane
        c.add(sidebar, BorderLayout.WEST);
    }

    // Methods for displaying content
}
