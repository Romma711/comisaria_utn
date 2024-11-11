package Almacen;

import Interfaces.AL;
import Interfaces.IJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class Caso extends Registro implements AL<Evidencia>, IJson<Caso> {
    private ArrayList<Evidencia> caja;
    private String comentario;

    public Caso(String comentario) {
        super();
        caja = new ArrayList<>();
        this.comentario = comentario;
    }
    public Caso() {
        super();
    }

    ///region GETTERS & SETTERS
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    ///endregion

    public int retornarLength(){
        return caja.size();
    }
    public Evidencia retornarEvidencia(int i){
        return caja.get(i);
    }

    @Override
    public Caso jsonToThisClass(JSONObject jason) {
        Caso caso = new Caso();
        caso.setId(jason.getInt("id"));
        caso.setComentario(jason.getString("comentario"));

        JSONArray listado = jason.getJSONArray("caja");
        for (int i = 0; i < listado.length(); i++) {
            JSONObject evidenciaJSON = listado.getJSONObject(i);
            Evidencia evidencia = new Evidencia();
            evidencia = evidencia.jsonToThisClass(evidenciaJSON);

            caso.agregarNoModifcable(evidencia);
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
        for(int i=0; i<caja.size();i++){
            ;
            array.put(caja.get(i).classToJson());
        }
        json.put("comentarios",this.getComentario());
        json.put("evidencias",array);
        return json;
    }

    ///region AL
    @Override
    public boolean agregarNoModifcable(Evidencia dato) {
        return caja.add(dato);
    }

    @Override
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
    ///endregion

    @Override
    public String toString() {
        return "Caso:" +
                "\n  ID del caso: " + super.getId() +
                "\n  Comentario del caso: " + comentario +
                "\n" + lista() +
                super.toString();
    }
}

//TODO revisar listar() con pruebas en consola.
