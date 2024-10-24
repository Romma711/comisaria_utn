package Almacen;

import java.util.Date;
import java.util.UUID;

public class Modificacion {
    private UUID idOperador;
    private Date fechaModificacion;

    public Modificacion(UUID idOperador, Date fechaModificacion) {
        idOperador = UUID.randomUUID();
        this.fechaModificacion = fechaModificacion;
    }

    ///region GETTERS
    public UUID getIdOperador() {
        return idOperador;
    }
    public void setIdOperador(UUID idOperador) {
        this.idOperador = idOperador;
    }
    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    ///endregion


    @Override
    public String toString() {
        return "Modificacion {" +
                "idOperador=" + idOperador +
                ", ultimaModificacion=" + fechaModificacion +
                '}';
    }
}
