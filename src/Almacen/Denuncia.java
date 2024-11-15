package Almacen;

public class Denuncia extends Registro{
    private final String dniDenunciante, dniDenunciado;
    private String declaracion;

    public Denuncia(String dniDenunciante, String dniDenunciado, String declaracion) {
        super();
        this.dniDenunciante = dniDenunciante;
        this.dniDenunciado = dniDenunciado;
        this.declaracion = declaracion;
    }

    public void setDeclaracion(String declaracion) {
        this.declaracion = declaracion;
    }

    @Override
    public String toString() {
        return "Denuncia:" +
                "\n  ID de la denuncia: " + super.getId() +
                "\n  DNI del denunciante: " + dniDenunciante +
                "\n  DNI del denunciado: " + dniDenunciado +
                "\n  Declaracion: " + declaracion +
                super.toString();
    }
}