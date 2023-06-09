package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Represents a report library with a title and a list of reports
public class ReportLibrary implements Writable {
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
        EventLog.getInstance().logEvent(new Event("Added Report for " + info.getPersonName() + " to: "
                + getTitle()));
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns the arrayList of reports in the libary
    public ArrayList<Report> getReportList() {
        EventLog.getInstance().logEvent(new Event("Displaying all reports in: " + getTitle()));
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
                EventLog.getInstance().logEvent(new Event("Displaying Report for: " + report.getPersonName()));
                return report;
            }
        }
        return null;
    }



    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("reportList", reportsToJson());
        return json;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns reports in the reportLibrary as a JSON array
    public JSONArray reportsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Report r : reportList) {
            jsonArray.put(r.toJson());
        }
        return jsonArray;
    }
}
