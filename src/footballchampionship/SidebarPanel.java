package footballchampionship;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    SidebarPanel() {
        Dimension size = getPreferredSize();
        size.width = 300;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Premier League Details"));

    }
}
