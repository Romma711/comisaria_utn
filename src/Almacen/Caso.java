package Almacen;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Caso extends Registro {
    private String nombre;
    private final ArrayList<Evidencia> caja = new ArrayList<>();
    private String comentario;

    //region CONSTRUCTORES
    public Caso(String nombre,String comentario) {
        super();
        this.comentario = comentario;
        this.nombre = nombre;
    }
    public Caso() {
        super();
    }
    //endregion

    //region GETTERS & SETTERS
    public String getComentario() {
        return comentario;
    }
    public String getNombre() {
        return nombre;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //endregion

    //region AL
    public boolean agregarEvidencia(Evidencia dato) {
        return caja.add(dato);
    }
    public String lista() {
        String listado = "";
        int i = 0;
        for (Evidencia evidencia : caja) {
            i++;
            listado = listado.concat("    " + i + "- ");
            listado = listado.concat(evidencia.toString());
        }
        return listado;
    }
    //endregion

    //region IJSON
    @Override
    public Caso jsonToThisClass(JSONObject jason) {
        Caso caso = new Caso();
        caso.setId(jason.getInt("id"));
        caso.setComentario(jason.getString("comentario"));
        caso.setNombre(jason.getString("nombre"));

        JSONArray listado = jason.getJSONArray("evidencias");
        for (int i = 0; i < listado.length(); i++) {
            JSONObject evidenciaJSON = listado.getJSONObject(i);
            Evidencia evidencia = new Evidencia();
            evidencia = evidencia.jsonToThisClass(evidenciaJSON);

            caso.agregarEvidencia(evidencia);
        }

        listado = jason.getJSONArray("modificaciones");
        for (int i = 0; i < listado.length(); i++) {
            JSONObject modificacionJSON = listado.getJSONObject(i);
            Modificacion modificacion = new Modificacion();
            modificacion = modificacion.jsonToThisClass(modificacionJSON);

            caso.agregarMod(modificacion);
        }

        return caso;
    }
    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i = 0; i < caja.size(); i++){
            array.put(caja.get(i).classToJson());
        }
        json.put("evidencias",array);
        json.put("id",this.getId());
        json.put("nombre",this.getNombre());
        json.put("comentario",this.getComentario());
        JSONArray arrayMod = new JSONArray();
        for (int i = 0; i < retornarLenght(); i++){
            arrayMod.put(retornarPosicion(i).classToJson());
        }
        json.put("modificaciones",arrayMod);
        return json;
    }
    //endregion

    @Override
    public String toString() {
        return "Caso:" +
                "\n  ID del caso: " + super.getId() +
                "\n  Comentario del caso: " + comentario +
                "\n" + lista() +
                super.toString();
    }
}
