package persistence;


import model.Report;
import model.ReportLibrary;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Stream;

//Credit to: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git for data preservence code structure

//Represents a reader that reads a reportLibrary from JSON data stored in file

public class JsonReader  {
    private String source;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Reads reportLibrary from file and returns it
    //Throws IOException if an error occurs reading data from file
    public ReportLibrary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseReportLibrary(jsonObject);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Reads source file as strings and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: parses ReportLibrary from JSON object and returns it
    private ReportLibrary parseReportLibrary(JSONObject jsonObject) {
        String name = jsonObject.getString("title");
        ReportLibrary rl = new ReportLibrary(name);
        addReports(rl, jsonObject);

        return rl;
    }

    // REQUIRES:
    // MODIFIES: reportLibrary
    // EFFECTS: parses reports from JSon object and adds them to reportLibrary
    private void addReports(ReportLibrary rl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("reportList");
        for (Object json : jsonArray) {
            JSONObject nextReport = (JSONObject) json;
            addReport(rl, nextReport);

        }
    }

    // REQUIRES:
    // MODIFIES: reportLibrary
    // EFFECTS: parses report info from JSon object and adds them to reportLibrary
    private void  addReport(ReportLibrary rl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Integer age = jsonObject.getInt("age");
        String country = jsonObject.getString("country");
        Report report = new Report(name, age, country);

        JSONArray jsonArray = jsonObject.getJSONArray("vaccines");
        for (Object json : jsonArray) {
            report.addVaccineInfo(json.toString());
        }

        rl.addInfo(report);

    }



}
