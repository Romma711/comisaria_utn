package Almacen;

import java.util.UUID;

public class Denuncia{
    private UUID idDenuncia;
    private String dniDenunciante, dniDenunciado, declaracion;

    public Denuncia(String dniDenunciante, String dniDenunciado, String declaracion) {
        idDenuncia = UUID.randomUUID();
        this.dniDenunciante = dniDenunciante;
        this.dniDenunciado = dniDenunciado;
        this.declaracion = declaracion;
    }

    ///region GETTERS & SETTERS
    public UUID getIdDenuncia() {
        return idDenuncia;
    }

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
                "idDenuncia=" + idDenuncia +
                ", dniDenunciante='" + dniDenunciante + '\'' +
                ", dniDenunciado='" + dniDenunciado + '\'' +
                "\nDeclaracion: " + declaracion;
    }
}
