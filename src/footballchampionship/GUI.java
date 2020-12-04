package footballchampionship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI {

    public GUI(List<FootballClub> clubsList) {
        // Frame and Panel
        JFrame frame = new JFrame ("Football Championship Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        frame.setSize(900,500);
        frame.setVisible(true);
        // Button component
        JButton button = new JButton("Show all played matches");
        frame.getContentPane().add(button);
        button.addActionListener(new MyActionListener());
        // Form fields
        JLabel label = new JLabel("Name of the club: ");
        JTextField field = new JTextField(25);
        Container c = frame.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.add(label);
        c.add(field);
        // Insert table
        frame.getContentPane().add(new tableTemplate(clubsList));
    }
}
// button event handler class
class MyActionListener implements ActionListener {
    private int i = 1;

    public void actionPerformed(ActionEvent e) {
        System.out.println(" Pressed Button " + i ++ + " th time ! " );
    }
}

