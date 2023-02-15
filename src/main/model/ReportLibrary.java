package model;

import java.util.ArrayList;

//Represents a report library with a title and a list of reports
public class ReportLibrary {
    private String title;
    private ArrayList<Report> reportList;



    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Creates a report library object
    public ReportLibrary(String title) {
        this.title = title;
        reportList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Adds a report to the Report library
    public void addInfo(Report info) {
        reportList.add(info);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns the arrayList of reports in the libary
    public ArrayList<Report> getReportList() {
        return reportList;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: remove a report from the reportLib
    public void removeInfo(Report info) {
        reportList.remove(info);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Returns the size of the reportList
    public int getInfoListSize() {
        return reportList.size();
    }


    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Prints all reports in a report library
    public String printReport() {
        String str = "";
        for (Report info : reportList) {
            str = info.toString() + "\n" + str;
        }
        return str;
    }

    // REQUIRES: A name that exists in a report
    // MODIFIES:
    // EFFECTS: Takes a name as a string and searches all reports and returns the report that has the matching name
    public Report getSpecificReport(String s) {
        for (Report report : reportList) {
            if (report.getPersonName().equals(s)) {
                return report;
            }
        }
        return null;
    }
}
