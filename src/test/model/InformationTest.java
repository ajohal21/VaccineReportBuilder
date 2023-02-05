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

}