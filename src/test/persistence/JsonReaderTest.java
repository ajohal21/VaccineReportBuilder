package persistence;

import model.ReportLibrary;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {

        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ReportLibrary reportLibrary = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyReportLibrary() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyReportLibrary.json");
        try {
            ReportLibrary rl = reader.read();
            assertEquals("test", rl.getTitle());
            assertEquals(0, rl.getInfoListSize());

        } catch (IOException e) {
            fail("Could not read from file");
        }
    }
}
