package Almacen;

import java.util.ArrayList;

public class Caso extends Registro {
    private final String nombre;
    private final ArrayList<Evidencia> caja = new ArrayList<>();
    private final String comentario;

    public Caso(String nombre,String comentario) {
        super();
        this.comentario = comentario;
        this.nombre = nombre;
    }

    public boolean agregarEvidencia(Evidencia dato) {
        return caja.add(dato);
    }
    public String lista() {
        String listado = "";
        int i = 0;
        for (Evidencia evidencia : caja) {
            i++;
            listado = listado.concat("    " + i + "- ");
            listado = listado.concat(evidencia.toString());
        }
        return listado;
    }

    @Override
    public String toString() {
        return "Caso:" +
                "\n  ID del caso: " + super.getId() +
                "\n  Nombre del caso: " + nombre +
                "\n  Comentario del caso: " + comentario +
                "\n" + lista() +
                super.toString();
    }
}