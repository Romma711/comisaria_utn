package Almacen;

import Interfaces.IJson;
import org.json.JSONObject;
import java.util.UUID;

public class Modificacion {
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

    @Override
    public String toString() {
        return "Modificacion:" +
                "\nFecha de la modificacion: " + fechaModificacion +
                "\nID del operador: " + idModificacion +
                "\nRazón: " + razon + '\n';
    }
}

