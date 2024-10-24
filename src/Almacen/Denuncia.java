package Almacen;

import java.util.UUID;

public class Denuncia extends Registro{
    private String dniDenunciante, dniDenunciado, declaracion;

    public Denuncia(String dniDenunciante, String dniDenunciado, String declaracion) {
        super();
        this.dniDenunciante = dniDenunciante;
        this.dniDenunciado = dniDenunciado;
        this.declaracion = declaracion;
    }

    ///region GETTERS & SETTERS
    public String getDniDenunciante() {
        return dniDenunciante;
    }

    public void setDniDenunciante(String dniDenunciante) {
        this.dniDenunciante = dniDenunciante;
    }

    public String getDniDenunciado() {
        return dniDenunciado;
    }

    public void setDniDenunciado(String dniDenunciado) {
        this.dniDenunciado = dniDenunciado;
    }

    public String getDeclaracion() {
        return declaracion;
    }

    public void setDeclaracion(String declaracion) {
        this.declaracion = declaracion;
    }
    ///endregion

    @Override
    public String toString() {
        return "Denuncia \n" +
                "dniDenunciante='" + dniDenunciante + '\'' +
                ", dniDenunciado='" + dniDenunciado + '\'' +
                "\nDeclaracion: " + declaracion;
    }
}
