package model;

import java.util.ArrayList;


public class ReportLibrary {
    private String title;
    private ArrayList<Report> reportList;

    public ReportLibrary(String title) {
        this.title = title;
        reportList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addInfo(Report info) {
        reportList.add(info);
    }

    public void removeInfo(Report info) {
        reportList.remove(info);
    }

    public int getInfoListSize() {
        return reportList.size();
    }


    public String printReport() {
        String str = "";
        for (Report info : reportList) {
            str = info.getPersonName() + info.getAge() + info.getCountryName() + info.getVaccineInfo() + str;
        }
        return str;
    }

    public Report getSpecificReport(String s) {
        for (Report report : reportList) {
            if (report.getPersonName().equals(s)) {
                return report;
            }
        }
        return null;
    }
}
