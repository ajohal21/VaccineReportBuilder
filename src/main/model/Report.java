package model;

import java.util.ArrayList;

public class Report {

    private String personName;
    private int age;
    private String countryName;
    private ArrayList<String> vaccineInfo;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public Report(String personName, Integer age, String countryName) {
        this.personName = personName;
        this.age = age;
        this.countryName = countryName;
        vaccineInfo = new ArrayList<>();
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<String> getVaccineInfo() {
        return vaccineInfo;
    }

    public void addVaccineInfo(String vaccine) {
        vaccineInfo.add(vaccine);
    }

    @Override
    public String toString() {
        return "Travel Report for " +  personName + "\n Age: " + age + "\n Country: " + countryName + "\n Vaccines: " + vaccineInfo;
    }
}