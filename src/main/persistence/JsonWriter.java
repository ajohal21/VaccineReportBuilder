package persistence;

import model.ReportLibrary;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Credit to: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git for data preservence code structure

//Represents a writer that writes a JSON representation of ReportLibrary to file
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

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: writes JSON representation of reportLibrary to file
    public void write(ReportLibrary rl) {
        JSONObject json = rl.toJson();
        saveToFile(json.toString(TAB));
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

}
