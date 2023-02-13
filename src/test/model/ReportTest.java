package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    private Report info1;
    private Report info2;


    @BeforeEach
    public void setup() {
        info1 = new Report("name", 0 , "country");

    }

    @Test
    public void testInformationConstructor() {
        assertEquals("name", info1.getPersonName());
        assertEquals(0, info1.getAge());
        assertEquals("country", info1.getCountryName());
        assertEquals(0, info1.getVaccineInfo().size());
    }

    @Test
    public void testSetters() {
        assertEquals("name", info1.getPersonName());
        assertEquals(0, info1.getAge());
        assertEquals("country", info1.getCountryName());
        assertEquals(0, info1.getVaccineInfo().size());

        info1.setPersonName("new name");
        info1.setAge(20);
        info1.setCountryName("new country");


        assertEquals("new name", info1.getPersonName());
        assertEquals(20, info1.getAge());
        assertEquals("new country", info1.getCountryName());


    }

    @Test
    public void testAddingVaccines() {
        assertEquals(0, info1.getVaccineInfo().size());
        info1.addVaccineInfo("test");
        assertEquals(1, info1.getVaccineInfo().size());
    }

    @Test
    public void testToString() {
        assertEquals("Travel Report for " +  info1.getPersonName() + "\n Age: " + info1.getAge() + "\n Country:" +
                " " + info1.getCountryName() + "\n Vaccines: " + info1.getVaccineInfo(),info1.toString());
    }

}