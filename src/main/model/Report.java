package model;

public class Report {

    private String personName;
    private int age;
    private String countryName;
    private String vaccineInfo;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public Report(String personName, Integer age, String countryName, String vaccineInfo) {
        this.personName = personName;
        this.age = age;
        this.countryName = countryName;
        this.vaccineInfo = vaccineInfo;
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

    public String getVaccineInfo() {
        return vaccineInfo;
    }

    public void setVaccineInfo(String vaccineInfo) {
        this.vaccineInfo = vaccineInfo;
    }

//    @Override
//    public String toString() {
//        return "Report{" + "personName='" + personName + '\'' + ", age=" + age + ", countryName='" + countryName + '\'' + ", vaccineInfo='" + vaccineInfo + '\'' + '}';
//    }
}
