package Almacen;

import Enums.T_Material;

public class Evidencia{
    private static Integer cont = 0;
    private final Integer idEvidencia;
    private final T_Material tipo;
    private final String paradero, nota;

    public Evidencia(T_Material tipo, String paradero, String nota) {
        cont++;
        idEvidencia = cont;
        this.tipo = tipo;
        this.paradero = paradero;
        this.nota = nota;
    }

    public static void setCont(Integer cont) {
        Evidencia.cont = cont;
    }

    @Override
    public String toString() {
        return "Evidencia:" +
                "\n    ID de la evidencia: " + idEvidencia +
                "\n    Tipo: " + tipo +
                "\n    Lugar: " + paradero +
                "\n    Analisis: " + nota + "\n    ------------------------------------\n";
    }
}
