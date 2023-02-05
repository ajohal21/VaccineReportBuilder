package model;

import java.util.ArrayList;
import java.util.List;

public class ReportSet {
    private String title;
    private List<Information> informationList;

    public ReportSet(String title) {
        this.title = title;
        informationList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addInfo(Information info) {
        informationList.add(info);
    }

    public void removeInfo(Information info) {
        informationList.remove(info);
    }

    public int getInfoListSize() {
        return informationList.size();
    }


    public String printReport() {
        String str = "";
        for (Information info : informationList) {
            str = info.getPersonName() + info.getAge() + info.getCountryName() + info.getVaccineInfo() + str;
        }
        return str;
    }
}
