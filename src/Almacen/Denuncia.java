package Almacen;

import Interfaces.IJson;
import org.json.JSONArray;
import org.json.JSONObject;

public class Denuncia extends Registro implements IJson<Denuncia> {
    private String dniDenunciante, dniDenunciado, declaracion;

    public Denuncia(String dniDenunciante, String dniDenunciado, String declaracion) {
        super();
        this.dniDenunciante = dniDenunciante;
        this.dniDenunciado = dniDenunciado;
        this.declaracion = declaracion;
    }
    public Denuncia() {
    }

    ///region GETTERS & SETTERS
    public String getDniDenunciante() {
        return dniDenunciante;
    }
    public void setDniDenunciante(String dniDenunciante) {
        this.dniDenunciante = dniDenunciante;
    }
    public String getDniDenunciado() {
        return dniDenunciado;
    }
    public void setDniDenunciado(String dniDenunciado) {
        this.dniDenunciado = dniDenunciado;
    }
    public String getDeclaracion() {
        return declaracion;
    }
    public void setDeclaracion(String declaracion) {
        this.declaracion = declaracion;
    }
    ///endregion

    @Override
    public Denuncia jsonToThisClass(JSONObject jason) {
        Denuncia denuncia = new Denuncia();
        denuncia.setId(jason.getInt("id"));
        denuncia.setDeclaracion(jason.getString("declaracion"));
        denuncia.setDniDenunciado(jason.getString("dniDenunciado"));
        denuncia.setDniDenunciante(jason.getString("dniDenunciante"));

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
        json.put("denunciante",this.getDniDenunciante());
        json.put("denunciado",this.getDniDenunciado());
        json.put("declaracion",this.getDeclaracion());
        return json;
    }

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


//TODO revisar toString() con pruebas en consola.