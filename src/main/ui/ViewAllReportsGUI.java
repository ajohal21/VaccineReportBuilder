package ui;

import model.Report;
import model.ReportLibrary;
import model.VaccineMap;

import javax.swing.*;
import java.awt.*;

//Represents a JFrame window to display all reports in library
public class ViewAllReportsGUI {

    JFrame frame = new JFrame();

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Creates a JLabel with Name--Destination for every report in the library
    ViewAllReportsGUI(ReportLibrary lib) {

        String txt = "<html>";
        for (Report report : lib.getReportList()) {
            txt = txt + "\n" + report.getPersonName() + "--" + report.getCountryName() + "<br>";
        }
        txt = txt + "</html>";


        JLabel label = new JLabel();
        label.setText(txt);
        label.setFont(new Font("MV Boli", Font.BOLD, 16));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);




        frame.setSize(300,300);
        frame.setVisible(true);
        frame.add(label);


    }


}
