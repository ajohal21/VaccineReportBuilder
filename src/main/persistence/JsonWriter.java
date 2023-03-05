package persistence;

import model.ReportLibrary;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Constructs writer
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: opens writer, throws FileNotFoundException if
    //          destination file cannot be opened
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public void write(ReportLibrary rl) {
        JSONObject json = rl.toJson();
        saveToFile(json.toString(TAB));
    }

    public void close() {
        writer.close();
    }

    private void saveToFile(String json) {
        writer.print(json);
    }

}
