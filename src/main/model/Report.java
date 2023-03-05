package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class Report implements Writable {

    private String personName;
    private int age;
    private String countryName;
    private ArrayList<String> vaccineInfo;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Creates report object
    public Report(String personName, Integer age, String countryName) {
        this.personName = personName;
        this.age = age;
        this.countryName = countryName;
        vaccineInfo = new ArrayList<>();
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Gets personName
    public String getPersonName() {
        return personName;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: sets personName
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Gets age
    public int getAge() {
        return age;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: sets age
    public void setAge(int age) {
        this.age = age;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: gets country name
    public String getCountryName() {
        return countryName;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: sets country name
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: gets vaccine titles
    public ArrayList<String> getVaccineInfo() {
        return vaccineInfo;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: adds titles to vaccine arrayList
    public void addVaccineInfo(String vaccine) {
        vaccineInfo.add(vaccine);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Returns a formatted string
    @Override
    public String toString() {
        return "Travel Report for "
                +  personName + "\n Age: " + age + "\n Country: " + countryName + "\n Vaccines: " + vaccineInfo;

    }

    //@Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", personName);
        json.put("age", age);
        json.put("country", countryName);
        json.put("vaccines", vaccinesToJson());
        return json;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns vaccines in this report as a JSON array
    public JSONArray vaccinesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (String v : vaccineInfo) {
            jsonArray.put(v);
        }
        return jsonArray;
    }

}