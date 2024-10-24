package Almacen;

import java.util.Date;
import java.util.UUID;

public class Modificacion {
    private UUID idOperador;
    private Date ultimaModificacion;

    public Modificacion(UUID idOperador, Date ultimaModificacion) {
        idOperador = UUID.randomUUID();
        this.ultimaModificacion = ultimaModificacion;
    }

    ///region GETTERS
    public UUID getIdOperador() {
        return idOperador;
    }
    public Date getUltimaModificacion() {
        return ultimaModificacion;
    }
    ///endregion


    @Override
    public String toString() {
        return "Modificacion {" +
                "idOperador=" + idOperador +
                ", ultimaModificacion=" + ultimaModificacion +
                '}';
    }
}
