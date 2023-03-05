package persistence;

import org.json.JSONObject;


//Credit to: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git for data preservence code structure

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}