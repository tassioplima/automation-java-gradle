package utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import model.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class Utils {

    String path = "src/test/java/jsons/data.json";

    public static JSON pathToJSON() throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader("src/test/java/jsons/data.json"), JSON.class);
    }

}
