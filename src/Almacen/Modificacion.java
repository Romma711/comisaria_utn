package Almacen;

import java.util.UUID;

public class Modificacion{
    private final UUID idModificacion;
    private final Integer idOperador;
    private final String fechaModificacion, razon;

    public Modificacion(Integer idOperador, String fechaModificacion, String comentario) {
        idModificacion = UUID.randomUUID();
        this.idOperador = idOperador;
        this.fechaModificacion = fechaModificacion;
        this.razon = comentario;
    }

    @Override
    public String toString() {
        return "Modificacion:" +
                "\nID de la modificacion: " + idModificacion +
                "\nFecha de la modificacion: " + fechaModificacion +
                "\nID del operador: " + idOperador +
                "\nRazón: " + razon + '\n';
    }
}

