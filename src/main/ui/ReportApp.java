package ui;

import model.Report;
import model.ReportLibrary;
import model.VaccineMap;

import java.util.Locale;
import java.util.Scanner;


//Credit to: https://github.students.cs.ubc.ca/CPSC210/TellerApp.git teller app for the code structure
//Report Application
public class ReportApp {

    private Report report;
    private ReportLibrary lib;
    private VaccineMap vax;
    private Scanner input;

    public ReportApp() {
        runApplication();
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Runs the report Application
    private void runApplication() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase(Locale.ROOT);

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommond(command);
            }
        }

        System.out.println("Thank you for using the Report Builder");
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: runs the user command
    private void processCommond(String command) {
        if (command.equals("m")) {
            makeReport();
        } else if (command.equals("p")) {
            printInfo();
        } else if (command.equals("v")) {
            viewReports();
        } else if (command.equals("s")) {
            printSpecificReport();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: initializes the report library, vaccineMap, and the scanner
    private void init() {
        lib = new ReportLibrary("Set 1");
        vax = new VaccineMap();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Shows menus options to the user
    private void displayMenu() {
        System.out.println("\nWelcome to the Travel Report Builder");
        System.out.println("\nSelect from:");
        System.out.println("\tm -> Make new report");
        System.out.println("\tv -> View Reports");
        System.out.println("\ts -> Print Specific Report");
        System.out.println("\tp -> Print Report Library");
        System.out.println("\tq -> quit");
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: user is guided through the process of making a new report
    private void makeReport() {
        //Information info = new Information();
        System.out.println("Enter the patient's name");
        String personName = input.next();
        System.out.println("Enter the patient's age");
        Integer age = input.nextInt();
        System.out.println("Enter the travel destination(s)");
        String countryNames = input.next();

        Report report1 = new Report(personName, age, countryNames);

        boolean keepGoing = true;
        String vaccinesNeeded = "";
        System.out.println("Enter the vaccine name (or q to finish report)");
        while (keepGoing) {
            vaccinesNeeded = input.next();
            if (vaccinesNeeded.equals("q")) {
                keepGoing = false;

            } else {
                report1.addVaccineInfo(vax.getSpecificVaccine(vaccinesNeeded));
                System.out.println("Enter the vaccine name (or q to finish report)");
            }
        }


        lib.addInfo(report1);

        System.out.println("\nReport Created! Report saved to Report Library!");

    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Prints all reports
    private void printInfo() {

        System.out.println(lib.printReport());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Shows the user all reports in the form name -- destination
    private void viewReports() {
        System.out.println("Viewing All Reports: \n");
        for (Report reports : lib.getReportList()) {
            System.out.println(reports.getPersonName() + "--" + reports.getCountryName());

        }

    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: prompts user to enter a name and prints the corresponding report
    private void printSpecificReport() {
        System.out.println("Please Enter a Patient's name to print their report (or q to return to menu");
        boolean keepGoing = true;
        //String printName = input.next();
        String printName = input.next();
        while (keepGoing) {
            if (printName.equals("q")) {
                keepGoing = false;

            } else {
                System.out.println(lib.getSpecificReport(printName).toString());
                keepGoing = false;
            }
        }
    }
}




