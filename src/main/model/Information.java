package model;

public class Information {

    private String personName;
    private int age;
    private String countryName;
    private String vaccineInfo;

    public Information(String personName, Integer age, String countryName, String vaccineInfo) {
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


}
