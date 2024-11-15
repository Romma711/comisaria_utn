import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONUtils <T>{
    public static void guardarArchivo(JSONObject ogt, String json){
        try{
            FileWriter file = new FileWriter(json);
            file.write(ogt.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject jsonDeArchivo(String json){
        JSONTokener token = null;
        try{
            token= new JSONTokener(new FileReader(json));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new JSONObject(token);
    }
}
