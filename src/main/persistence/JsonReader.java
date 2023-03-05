package persistence;

import jdk.jfr.Category;
import model.Report;
import model.ReportLibrary;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public ReportLibrary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseReportLibrary(jsonObject);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private ReportLibrary parseReportLibrary(JSONObject jsonObject) {
        String name = jsonObject.getString("title");
        ReportLibrary rl = new ReportLibrary(name);
        addReports(rl, jsonObject);

        return rl;
    }

    private void addReports(ReportLibrary rl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("reportList");
        for (Object json : jsonArray) {
            JSONObject nextReport = (JSONObject) json;
            addReport(rl, nextReport);

        }
    }

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
