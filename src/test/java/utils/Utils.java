package utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import model.JSON;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;

public class Utils {

    String path = "src/test/java/jsons/data.json";

    public static JSON pathToJSON() {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<JSON>(){}.getType();
            JSON json = gson.fromJson(new FileReader(new File("src/test/java/jsons/data.json").getAbsolutePath()), JSON.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
