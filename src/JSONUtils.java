import Almacen.*;
import Entidades.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONUtils <T>{
    public static void guardarArchivo(JSONArray array, String json){
        try{
            FileWriter file = new FileWriter(json);
            file.write(array.toString());
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

    //region convertir a json
    private static void convertirModificacion(JSONObject json, Modificacion obj){

    }


    //endregion

}
