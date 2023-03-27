package ui;

import model.Report;

import javax.swing.*;
import java.awt.*;

//Represents a JFrame window to display a specific report
public class SpecificReportWindowGUI {

    JFrame frame = new JFrame();

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Creates a JLabel with full report details for a given patient
    SpecificReportWindowGUI(Report report) {

        ImageIcon bg = new ImageIcon("data/bg.png");

        JLabel label = new JLabel();
        label.setText("<html>" + report.toString().replace("\n", "<br>") + "</html>");
        label.setFont(new Font("MV Boli", Font.BOLD, 16));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        label.setIcon(bg);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
    }
}
