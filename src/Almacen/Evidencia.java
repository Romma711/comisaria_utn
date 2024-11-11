package Almacen;

import Enums.T_Material;
import Interfaces.IJson;
import org.json.JSONObject;

import java.util.UUID;


public class Evidencia implements IJson<Evidencia> {
    private static Integer cont = 0;
    private Integer idEvidencia;
    private T_Material tipo;
    private String paradero, analisis;

    public Evidencia(T_Material tipo, String paradero, String analisis) {
        cont++;
        idEvidencia = cont;
        this.tipo = tipo;
        this.paradero = paradero;
        this.analisis = analisis;
    }
    public Evidencia() {
        cont++;
    }

    ///region GETTERS & SETTERS
    public Integer getIdEvidencia() {
        return idEvidencia;
    }
    public T_Material getTipo() {
        return tipo;
    }
    public void setTipo(T_Material tipo) {
        this.tipo = tipo;
    }
    public String getParadero() {
        return paradero;
    }
    public void setParadero(String paradero) {
        this.paradero = paradero;
    }
    public String getAnalisis() {
        return analisis;
    }
    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }
    private void setIdEvidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }
    ///endregion

    public Evidencia jsonToThisClass(JSONObject jason) {
        Evidencia evidencia = new Evidencia();

        evidencia.setTipo(jason.getEnum(T_Material.class,"tipo"));
        evidencia.setParadero(jason.getString("paradero"));
        evidencia.setAnalisis(jason.getString("analisis"));
        evidencia.setIdEvidencia(jason.getInt("idEvidencia"));

        return evidencia;
    }

    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("analisis",this.getAnalisis());
        json.put("paradero",this.getParadero());
        json.put("id_evidencia",this.getIdEvidencia());
        json.put("tipo",this.getTipo().getClass());
        return json;
    }

    @Override
    public String toString() {
        return "Evidencia:" +
                "\n    ID de la evidencia: " + idEvidencia +
                "\n    Tipo: " + tipo +
                "\n    Lugar: " + paradero +
                "\n    Analisis: " + analisis + "\n    ------------------------------------\n";
    }
}
