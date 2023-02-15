package model;

import java.util.HashMap;

//Represents a vaccine having a name, dosage, and frequency
public class VaccineMap {


    private HashMap<String, String> vaccines;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Creates a VaccineMap object, with vaccine name as the key
    public VaccineMap() {
        vaccines = new HashMap<>();
        vaccines.put("Hepatitis A", "Hepatitis A \n Dosage: 1ml \n Frequency: Zero and 6 months");
        vaccines.put("Typhoid", "Typhoid \n Dosage: 0.5ml \n Frequency: Single dose");
        vaccines.put("Rabies", "Rabies \n Dosage: 1ml \n Frequency: Day 0, 7, and 21");
        vaccines.put("Yellow Fever", "Yellow Fever \n Dosage: 0.5ml \n Frequency: Single dose");

    }

    // REQUIRES: vaccineTyped exists in the map as a key
    // MODIFIES:
    // EFFECTS: produces the string value which contains all the appropriate vaccine info
    public String getSpecificVaccine(String vaccineTyped) {
        if (vaccines.containsKey(vaccineTyped)) {
            return vaccines.get(vaccineTyped);
        }
        return null;
    }


}