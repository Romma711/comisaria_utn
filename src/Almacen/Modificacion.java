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
        idModificacion = UUID.randomUUID();
        this.idOperador = idOperador;
        this.fechaModificacion = fechaModificacion;
        this.razon = comentario;
    }
    public Modificacion() {
        idModificacion = UUID.randomUUID();
    }
    ///endregion

    ///region GETTERS & SETTERS
    private String getIdModificacion() {
        return idModificacion.toString();
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

    //region IJSON
    public Modificacion jsonToThisClass(JSONObject jason) {
        Modificacion modificacion = new Modificacion();
        modificacion.setIdModificacion(UUID.fromString(jason.getString("id_modificacion")));
        modificacion.setIdOperador(jason.getInt("id_operador"));
        modificacion.setFechaModificacion(jason.getString("fecha_modificacion"));
        modificacion.setRazon(jason.getString("razon"));
        return modificacion;
    }
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("id_operador",this.getIdOperador());
        json.put("id_modificacion",this.getIdModificacion());
        json.put("fecha_modificacion",this.getFechaModificacion());
        json.put("razon",this.getRazon());
        return json;
    }
    //endregion

    @Override
    public String toString() {
        return "Modificacion:" +
                "\nID: " + idModificacion +
                "\nFecha de la modificacion: " + fechaModificacion +
                "\nID del operador: " + idOperador +
                "\nRazón: " + razon + '\n';
    }
}
