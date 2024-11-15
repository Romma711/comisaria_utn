package Almacen;

import Interfaces.IJson;
import org.json.JSONObject;
import java.util.UUID;

public class Modificacion implements IJson<Modificacion> {
    private UUID idModificacion;
    private Integer idOperador;
    private String fechaModificacion, razon;

    ///region CONSTRUCTORES
    public Modificacion(Integer idOperador, String fechaModificacion, String comentario) {
        this.idOperador = idOperador;
        this.fechaModificacion = fechaModificacion;
        this.razon = comentario;
    }
    public Modificacion() {
    }
    ///endregion

    ///region GETTERS & SETTERS
    private UUID getIdModificacion() {
        return idModificacion;
    }
    public Integer getIdOperador() {
        return idOperador;
    }
    public String getFechaModificacion() {
        return fechaModificacion;
    }
    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }
    private void setIdModificacion(UUID idModificacion) {
        this.idModificacion = idModificacion;
    }
    private void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    ///endregion

    ///region JSON
    public Modificacion jsonToThisClass(JSONObject jason) {
        Modificacion modificacion = new Modificacion();
        modificacion.setIdModificacion(UUID.fromString(jason.getString("id_modificacion")));
        modificacion.setIdOperador(jason.getInt("id_operador"));
        modificacion.setFechaModificacion(jason.getString("fecha_modificacion"));
        modificacion.setRazon(jason.getString("razon"));
        return modificacion;
    }
    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("id_operador",this.getIdOperador());
        json.put("id_modificacion",this.getIdModificacion());
        json.put("fecha_modificacion",this.getFechaModificacion());
        json.put("razon",this.getRazon());
        return json;
    }
    ///endregion

    @Override
    public String toString() {
        return "Modificacion:" +
                "\nFecha de la modificacion: " + fechaModificacion +
                "\nID del operador: " + idModificacion +
                "\nRazón: " + razon + '\n';
    }
}

