package Almacen;
///region IMPORTS
import Enums.T_Evidencia;
import java.util.UUID;
///endregion

public class Evidencia {
    private UUID idEvidencia;
    private T_Evidencia tipo;
    private String lugar;

    public Evidencia(T_Evidencia tipo, String lugar) {
        idEvidencia = UUID.randomUUID();
        this.tipo = tipo;
        this.lugar = lugar;
    }

    ///region GETTERS & SETTERS
    public UUID getIdEvidencia() {
        return idEvidencia;
    }

    public T_Evidencia getTipo() {
        return tipo;
    }

    public void setTipo(T_Evidencia tipo) {
        this.tipo = tipo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    ///endregion

    @Override
    public String toString() {
        return "Evidencia {" +
                "idEvidencia=" + idEvidencia +
                ", tipo=" + tipo +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
