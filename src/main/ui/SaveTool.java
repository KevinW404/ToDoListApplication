package ui;

import model.ToDoList;
import persistence.JsonWriter;

import java.io.FileNotFoundException;

public class SaveTool {
    private static final String JSON_STORE = "./data/ToDoList.json";

    JsonWriter jsonWriter;
    ToDoList toDo;

    public SaveTool(ToDoList toDo) {
        jsonWriter = new JsonWriter(JSON_STORE);
        this.toDo = toDo;
    }


    // EFFECTS: saves the todolist to file
    private void saveToDoList() {
        try {
            jsonWriter.open();
            jsonWriter.write(toDo);
            jsonWriter.close();
            System.out.println("Saved " + toDo.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

}