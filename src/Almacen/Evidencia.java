package Almacen;

import Enums.T_Material;
import Interfaces.IJson;
import org.json.JSONObject;

public class Evidencia implements IJson<Evidencia> {
    private static Integer cont = 0;
    private Integer idEvidencia;
    private T_Material tipo;
    private String paradero, nota;

    //region CONSTRUCTORES
    public Evidencia(T_Material tipo, String paradero, String nota) {
        cont++;
        idEvidencia = cont;
        this.tipo = tipo;
        this.paradero = paradero;
        this.nota = nota;
    }
    public Evidencia() {
        cont++;
    }
    //endregion

    ///region GETTERS & SETTERS
    public Integer getIdEvidencia() {
        return idEvidencia;
    }
    public T_Material getTipo() {
        return tipo;
    }
    public String getParadero() {
        return paradero;
    }
    public String getNota() {
        return nota;
    }
    public static Integer getCont() {
        return cont;
    }

    public static void setCont(Integer cont) {
        Evidencia.cont = cont;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }
    public void setParadero(String paradero) {
        this.paradero = paradero;
    }
    public void setTipo(T_Material tipo) {
        this.tipo = tipo;
    }
    private void setIdEvidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }
    ///endregion

    //region IJSON
    public Evidencia jsonToThisClass(JSONObject jason) {
        Evidencia evidencia = new Evidencia();
        evidencia.setTipo(jason.getEnum(T_Material.class,"tipo"));
        evidencia.setParadero(jason.getString("paradero"));
        evidencia.setNota(jason.getString("analisis"));
        evidencia.setIdEvidencia(jason.getInt("id_evidencia"));
        return evidencia;
    }
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("analisis",this.getNota());
        json.put("paradero",this.getParadero());
        json.put("id_evidencia",this.getIdEvidencia());
        json.put("tipo",this.getTipo());
        return json;
    }
    //endregion

    @Override
    public String toString() {
        return "Evidencia:" +
                "\n    ID de la evidencia: " + idEvidencia +
                "\n    Tipo: " + tipo +
                "\n    Lugar: " + paradero +
                "\n    Analisis: " + nota + "\n    ------------------------------------\n";
    }
}
