package Almacen;

import Interfaces.IJson;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

public class Modificacion implements IJson<Modificacion> {
    private UUID idOperador;
    private String fechaModificacion, razon;

    public Modificacion(UUID idOperador, String fechaModificacion, String comentario) {
        this.idOperador = idOperador;
        this.fechaModificacion = fechaModificacion;
        this.razon = comentario;
    }
    public Modificacion() {
    }

    ///region GETTERS & SETTERS
    public UUID getIdOperador() {
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
    private void setIdOperador(UUID idOperador) {
        this.idOperador = idOperador;
    }
    private void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    ///endregion

    public Modificacion jsonToThisClass(JSONObject jason) {
        Modificacion modificacion = new Modificacion();
        modificacion.setIdOperador(UUID.fromString(jason.getString("idOperador")));
        modificacion.setFechaModificacion(jason.getString("fechaModificacion"));
        modificacion.setRazon(jason.getString("razon"));
        return modificacion;
    }

    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("id_operador",this.getIdOperador());
        json.put("fecha_modificacion",this.getFechaModificacion());
        json.put("razon",this.getRazon());
        return json;
    }

    @Override
    public String toString() {
        return "Modificacion:" +
                "\nFecha de la modificacion: " + fechaModificacion +
                "\nID del operador: " + idOperador +
                "\nRazón: " + razon + '\n';
    }
}

