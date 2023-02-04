package model;

import java.util.ArrayList;
import java.util.List;

//Represents a country having a name and a list of vaccines needed
public class Country {
    private String countryName;
    private ArrayList<Vaccine> neededVaccines;

    public Country(String countryName) {
        this.countryName = countryName;
        neededVaccines = new ArrayList<>();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAllVaccine() {
        String printOut = "";
        for (Vaccine item : neededVaccines) {
            printOut =  printOut  + item.getName() + " " + item.getDose() + "ml " + "Frequency: "
                    + item.getFrequency() + "\n";
        }
        return printOut;
    }

    public void addVaccineToList(Vaccine vaccine) {
        neededVaccines.add(vaccine);
    }


}
