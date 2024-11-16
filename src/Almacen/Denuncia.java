package Almacen;

import org.json.JSONArray;
import org.json.JSONObject;

public class Denuncia extends Registro {
    private String dniDenunciante, dniDenunciado, declaracion;

    //region CONSTRUCTORES
    public Denuncia(String dniDenunciante, String dniDenunciado, String declaracion) {
        super();
        this.dniDenunciante = dniDenunciante;
        this.dniDenunciado = dniDenunciado;
        this.declaracion = declaracion;
    }
    public Denuncia() {
    }
    //endregion

    ///region GETTERS & SETTERS
    public String getDniDenunciante() {
        return dniDenunciante;
    }
    public String getDniDenunciado() {
        return dniDenunciado;
    }
    public String getDeclaracion() {
        return declaracion;
    }

    public void setDniDenunciado(String dniDenunciado) {
        this.dniDenunciado = dniDenunciado;
    }
    public void setDniDenunciante(String dniDenunciante) {
        this.dniDenunciante = dniDenunciante;
    }
    public void setDeclaracion(String declaracion) {
        this.declaracion = declaracion;
    }
    ///endregion

    //region IJSON
    @Override
    public Denuncia jsonToThisClass(JSONObject jason) {
        Denuncia denuncia = new Denuncia();
        denuncia.setId(jason.getInt("id"));
        denuncia.setDeclaracion(jason.getString("declaracion"));
        denuncia.setDniDenunciado(jason.getString("dni_denunciado"));
        denuncia.setDniDenunciante(jason.getString("dni_denunciante"));

        JSONArray listado = jason.getJSONArray("modificaciones");
        for (int i = 0; i < listado.length(); i++) {
            JSONObject modificacionJSON = listado.getJSONObject(i);
            Modificacion modificacion = new Modificacion();
            modificacion = modificacion.jsonToThisClass(modificacionJSON);

            denuncia.agregarMod(modificacion);
        }

        return denuncia;
    }
    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("id",this.getId());
        json.put("dni_denunciante",this.getDniDenunciante());
        json.put("dni_denunciado",this.getDniDenunciado());
        json.put("declaracion",this.getDeclaracion());
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
        return "Denuncia:" +
                "\n  ID de la denuncia: " + super.getId() +
                "\n  DNI del denunciante: " + dniDenunciante +
                "\n  DNI del denunciado: " + dniDenunciado +
                "\n  Declaracion: " + declaracion +
                super.toString();
    }
}
