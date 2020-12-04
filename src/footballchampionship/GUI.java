package footballchampionship;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUI {

    public GUI(List<FootballClub> clubsList) {
        // Frame and Panels
        JFrame frame = new JFrame ("Football Championship Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        SidebarPanel sidebar = new SidebarPanel();
        sidebar.addSidebarListener(new SidebarListener() {
            public void sidebarEventOccurred(sidebarEvent event);
        });

        frame.setSize(900,500);
        frame.setVisible(true);

        // Adding components to  Content Pane
        Container c = frame.getContentPane();
        c.add(sidebar, BorderLayout.WEST);
        c.add(new tableTemplate(clubsList), BorderLayout.EAST);
    }

    // Methods for displaying content
}

