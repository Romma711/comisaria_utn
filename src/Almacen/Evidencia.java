package Almacen;

import Enums.T_Material;
import java.util.UUID;


public class Evidencia {
    private UUID idEvidencia;
    private T_Material tipo;
    private String lugar;

    public Evidencia(T_Material tipo, String lugar) {
        idEvidencia = UUID.randomUUID();
        this.tipo = tipo;
        this.lugar = lugar;
    }

    ///region GETTERS & SETTERS
    public UUID getIdEvidencia() {
        return idEvidencia;
    }
    public T_Material getTipo() {
        return tipo;
    }
    public void setTipo(T_Material tipo) {
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
        return "Evidencia:" +
                "\nID de la evidencia: " + idEvidencia +
                "\nTipo: " + tipo +
                "\nLugar: '" + lugar + '\n';
    }
}

