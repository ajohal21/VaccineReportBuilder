package ui;

import model.Report;
import model.ReportLibrary;
import model.VaccineMap;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
//Credit to https://www.youtube.com/watch?v=Kmgo00avvEw for Java Swift Tutorial
// Represents the graphical user interface for the Travel Report Builder
public class GUI extends JFrame implements ActionListener {

    private JButton createButton;
    private JButton viewButton;
    private JButton viewAllButton;
    private JButton loadButton;
    private JButton saveButton;
    private ReportLibrary library;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/reportLib.json";

    //Initializes the Main screen and all the buttons and options
    public GUI() {
        runGui();
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Creates new JFrame with splash screen and creates buttons and adds them to JFrame
    @SuppressWarnings("methodlength")
    private void runGui() {
        library = new ReportLibrary("Set 1");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        createButton = new JButton();
        createButton.setBounds(125, 15, 100, 50);
        createButton.addActionListener(this);
        createButton.setText("Create Report");
        createButton.setFont(new Font("MV Boli", Font.BOLD, 10));

        viewButton = new JButton();
        viewButton.setBounds(125, 95, 100, 50);
        viewButton.addActionListener(this);
        viewButton.setText("View Report");
        viewButton.setFont(new Font("MV Boli", Font.BOLD, 10));

        viewAllButton = new JButton();
        viewAllButton.setBounds(125, 175, 100, 50);
        viewAllButton.addActionListener(this);
        viewAllButton.setText("View Library");
        viewAllButton.setFont(new Font("MV Boli", Font.BOLD, 10));

        loadButton = new JButton();
        loadButton.setBounds(300, 15, 100, 100);
        loadButton.addActionListener(this);
        loadButton.setText("Load");
        loadButton.setFont(new Font("MV Boli", Font.BOLD, 10));

        saveButton = new JButton();
        saveButton.setBounds(300, 125, 100, 100);
        saveButton.addActionListener(this);
        saveButton.setText("Save");
        saveButton.setFont(new Font("MV Boli", Font.BOLD, 10));


        ImageIcon logo = new ImageIcon("data/plane.png");

        JLabel logoLabel = new JLabel();

        logoLabel.setIcon(logo);


        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(0, 0, 500, 500);
        logoPanel.add(logoLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 500, 500, 300);
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setLayout(null);
        buttonPanel.add(createButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(viewAllButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);


        JFrame frame = new JFrame();
        frame.setTitle("Vaccine Report Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //prevent window resizing
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500, 800);
        frame.add(logoPanel);
        frame.add(buttonPanel);

    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Provides the user with prompts to help create a report, adds report to the library
    @SuppressWarnings("methodlength")
    private void makeReportGui() {
        VaccineMap vax = new VaccineMap();
        String name = JOptionPane.showInputDialog("Please Enter Patient Name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Patient age:"));
        String country = JOptionPane.showInputDialog("Please Enter Patient Destination(s):");

        Report report = new Report(name, age, country);

        JCheckBox hepA = new JCheckBox();
        hepA.setText("Hepatitis A");
        JCheckBox typhoid = new JCheckBox();
        typhoid.setText("Typhoid");
        JCheckBox rabies = new JCheckBox();
        rabies.setText("Rabies");
        JCheckBox yellowFever = new JCheckBox();
        yellowFever.setText("Yellow Fever");

        Object[] options = {hepA, typhoid, rabies, yellowFever};

        int result = JOptionPane.showConfirmDialog(null, options, "Select Vaccines", JOptionPane.DEFAULT_OPTION);
        ArrayList<String> selectedVaccines = new ArrayList<String>();
        if (result == JOptionPane.OK_OPTION) {

            for (Object checkBox : options) {
                JCheckBox checkBox1 = (JCheckBox) checkBox;
                if (checkBox1.isSelected()) {
                    selectedVaccines.add(checkBox1.getText());
                }
            }
        }
        for (String vaccine : selectedVaccines) {
            report.addVaccineInfo(vax.getSpecificVaccine(vaccine));
        }
        library.addInfo(report);
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Prompts the user to enter a name, will then make a new SpecificReportWindow to display report
                //if no name exists, user gets a Warning popup
    private void viewReport() {
        String name = JOptionPane.showInputDialog("Please Enter Patient Name:");
        Report report = library.getSpecificReport(name);

        if (report == null) {
            JOptionPane.showMessageDialog(null, "This patient does not have a report",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            SpecificReportWindowGUI reportWindow = new SpecificReportWindowGUI(report);
        }
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: makes a new viewAll window to display all reports in the library
    private void viewAllReports() {
        ViewAllReportsGUI viewAll = new ViewAllReportsGUI(library);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Saves the report library to a file
    private void saveLib() {
        try {
            jsonWriter.open();
            jsonWriter.write(library);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null,
                    "Saved " + library.getTitle() + " to " + JSON_STORE,
                    "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to write to file: " + JSON_STORE, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: loads the report library from a file
    private void loadLib() {
        try {
            library = jsonReader.read();
            JOptionPane.showMessageDialog(null,
                    "Loaded " + library.getTitle() + " from " + JSON_STORE, "Loaded",
                    JOptionPane.INFORMATION_MESSAGE);


        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
            JOptionPane.showMessageDialog(null,
                    "Unable to read from file: " + JSON_STORE, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Calls appropriate functions based on which button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            makeReportGui();
        } else if (e.getSource() == viewButton) {
            viewReport();

        } else if (e.getSource() == viewAllButton) {
            viewAllReports();

        } else if (e.getSource() == loadButton) {
            loadLib();

        } else if (e.getSource() == saveButton) {
            saveLib();
        }
    }
}
