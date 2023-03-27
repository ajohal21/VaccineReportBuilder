package ui;

import model.Report;
import model.ReportLibrary;
import model.VaccineMap;

import javax.swing.*;
import java.awt.*;

public class ViewAllReportsGUI {

    JFrame frame = new JFrame();

    ViewAllReportsGUI(ReportLibrary lib) {

        String txt = "<html>";
        for (Report report : lib.getReportList()) {
            txt = txt + "\n" + report.getPersonName() + "--" + report.getCountryName() + "<br>";
        }
        txt = txt + "</html>";


        JLabel label = new JLabel();
        label.setText(txt);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 10));



        frame.setSize(300,300);
        frame.setVisible(true);
        frame.add(label);


    }


}
