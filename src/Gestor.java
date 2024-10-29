import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gestor {

    public static void guardarArchivo(JSONObject obj, String json){
        try{
            FileWriter file = new FileWriter(json);
            file.write(obj.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONTokener leerArchivo(String json){
        JSONTokener token=null;
        try{
            token= new JSONTokener(new FileReader(json));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return token;
    }
}
