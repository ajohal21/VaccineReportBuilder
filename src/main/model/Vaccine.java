package model;

//Represents a vaccine having a name, dosage, and frequency
public class Vaccine {

    private String name;
    private double dose;
    private String frequency;


    public Vaccine(String name, double dose, String frequency) {
        this.name = name;
        this.dose = dose;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
