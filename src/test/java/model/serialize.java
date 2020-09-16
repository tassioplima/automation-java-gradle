package model;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class serialize {

    public static void deserializeJson() throws FileNotFoundException {

        File file = new File("src/test/java/env/JSON.json");
        String path = file.getAbsolutePath();
        Gson gson = new Gson();
        gson.fromJson(new FileReader(path), JSON.class);
    }


}
