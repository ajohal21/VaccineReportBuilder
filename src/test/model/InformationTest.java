package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InformationTest {

    private Information info1;
    private Information info2;


    @BeforeEach
    public void setup(){
        info1 = new Information("name", 0 , "country", "vaccine");

    }

    @Test
    public void testInformationConstructor(){
        assertEquals("name", info1.getPersonName());
        assertEquals(0, info1.getAge());
        assertEquals("country", info1.getCountryName());
        assertEquals("vaccine", info1.getVaccineInfo());
    }

    @Test
    public void testSetters(){
        assertEquals("name", info1.getPersonName());
        assertEquals(0, info1.getAge());
        assertEquals("country", info1.getCountryName());
        assertEquals("vaccine", info1.getVaccineInfo());

        info1.setPersonName("new name");
        info1.setAge(20);
        info1.setCountryName("new country");
        info1.setVaccineInfo("new vaccine");

        assertEquals("new name", info1.getPersonName());
        assertEquals(20, info1.getAge());
        assertEquals("new country", info1.getCountryName());
        assertEquals("new vaccine", info1.getVaccineInfo());


    }

}