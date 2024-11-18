import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONUtils <T>{
    public static void guardarArchivo(JSONObject obj, String json) {
        try{
            FileWriter file = new FileWriter(json);
            file.write(obj.toString());
            file.flush();
            file.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }catch (IOException e) {
            e.getMessage();
        }
    }

    public static JSONObject leerArchivo(String json) {
        JSONTokener token=null;
        try{
            token= new JSONTokener(new FileReader(json));
        } catch (IOException e) {
            e.getMessage();
        }
        return new JSONObject(token);
    }
}
