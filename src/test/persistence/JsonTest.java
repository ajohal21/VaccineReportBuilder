package persistence;

import model.Report;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkReport(String name, int age, String country, String vaccine, Report report) {
        assertEquals(name, report.getPersonName());
        assertEquals(age, report.getAge());
        assertEquals(country, report.getCountryName());
        assertEquals(vaccine, report.getVaccineInfo().toString());
    }
}
