package ui;

import model.Report;

import javax.swing.*;

public class SpecificReportWindowGUI {

    JFrame frame = new JFrame();



    SpecificReportWindowGUI(Report report) {

        JLabel label = new JLabel();
        label.setText("<html>" + report.toString().replace("\n", "<br>") + "</html>");
        //label.setBounds(100, 100, 25, 25);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
    }
}
