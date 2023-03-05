package persistence;

import model.Report;
import model.ReportLibrary;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            ReportLibrary rl = new ReportLibrary("Test");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testWriterEmptyReportLib() {
        try {
            ReportLibrary rl = new ReportLibrary("test");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyReportLibrary.json");
            writer.open();
            writer.write(rl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyReportLibrary.json");
            rl = reader.read();
            assertEquals("test", rl.getTitle());
            assertEquals(0, rl.getInfoListSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralReportLibrary() {
        try {
            ReportLibrary rl = new ReportLibrary("test");
            Report report = new Report("Aman", 29, "Mexico");
            report.addVaccineInfo("Hepatitis A");
            Report report1 = new Report("Eugene", 2, "England");
            report1.addVaccineInfo("Typhoid");
            report1.addVaccineInfo("Rabies");
            rl.addInfo(report);
            rl.addInfo(report1);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralReportLibrary.json");
            writer.open();
            writer.write(rl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralReportLibrary.json");
            rl = reader.read();
            assertEquals("test", rl.getTitle());

            ArrayList<Report> reports = new ArrayList<>();
            for (Report r : rl.getReportList()) {
                reports.add(r);
            }
            assertEquals(2, reports.size());
            checkReport("Aman", 29, "Mexico", "[Hepatitis A]", reports.get(0));
            checkReport("Eugene", 2, "England", "[Typhoid, Rabies]", reports.get(1));
        } catch (IOException e) {
            fail("Should not see exception");
        }
    }
}