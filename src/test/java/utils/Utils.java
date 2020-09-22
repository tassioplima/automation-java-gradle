package utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import model.JSON;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;

public class Utils {

    public static JSON pathToJSON() {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<JSON>(){}.getType();
            return gson.fromJson(new FileReader(new File("src/test/java/jsons/data.json").getAbsolutePath()), type);
        } catch (Exception e) {
            System.out.println("Error archive not found");
        }
        return null;
    }

}
