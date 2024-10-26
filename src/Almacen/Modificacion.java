package Almacen;

import java.util.Date;
import java.util.UUID;


public class Modificacion {
    private UUID idOperador;
    private Date fechaModificacion;
    private String razon;

    public Modificacion(UUID idOperador, Date fechaModificacion, String comentario) {
        this.idOperador = idOperador;
        this.fechaModificacion = fechaModificacion;
        this.razon = comentario;
    }

    ///region GETTERS
    public UUID getIdOperador() {
        return idOperador;
    }
    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    public String getRazon() {
        return razon;
    }
    public void setRazon(String razon) {
        this.razon = razon;
    }
    ///endregion

    @Override
    public String toString() {
        return "Modificacion:" +
                "\nFecha de la modificacion: " + fechaModificacion +
                "\nID del operador: " + idOperador +
                "\nRazón: " + razon + '\n';
    }
}

