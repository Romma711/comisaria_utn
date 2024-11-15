package Almacen;

import Enums.T_Material;
import Interfaces.IJson;
import org.json.JSONObject;

public class Evidencia {
    private static Integer cont = 0;
    private Integer idEvidencia;
    private T_Material tipo;
    private String paradero, nota;

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
    public String getNota() {
        return nota;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }
    private void setIdEvidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }
    ///endregion


    @Override
    public String toString() {
        return "Evidencia:" +
                "\n    ID de la evidencia: " + idEvidencia +
                "\n    Tipo: " + tipo +
                "\n    Lugar: " + paradero +
                "\n    Analisis: " + nota + "\n    ------------------------------------\n";
    }
}
