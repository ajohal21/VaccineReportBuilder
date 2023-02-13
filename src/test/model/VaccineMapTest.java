package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VaccineMapTest {

    private VaccineMap vaxMap;


    @BeforeEach
    public void setup() {
        vaxMap = new VaccineMap();
    }

    @Test
    public void testGetSpecificVaccine() {
        assertEquals("Hepatitis A \n Dosage: 1ml \n Frequency: Zero and 6 months",
                vaxMap.getSpecificVaccine("Hepatitis A"));

        assertEquals("Rabies \n Dosage: 1ml \n Frequency: Day 0, 7, and 21",
                vaxMap.getSpecificVaccine("Rabies"));

    }

    @Test
    public void testGetSpecificVaccineVoid() {
        assertNull(vaxMap.getSpecificVaccine(""));
    }
}
