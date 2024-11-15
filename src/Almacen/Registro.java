package Almacen;

import java.util.ArrayList;

public abstract class Registro {
    private static Integer cont = 9999;
    private final Integer id;
    protected final ArrayList<Modificacion> modificaciones;

    public Registro() {
        cont++;
        id = cont;
        modificaciones = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }
    public static void setCont(Integer cont) {
        Registro.cont = cont;
    }

    public boolean agregarMod(Modificacion dato) {
        return modificaciones.add(dato);
    }
    public String listaModificaciones() {
        String listado = "";
        int i = 0;
        for (Modificacion mods : modificaciones) {
            i++;
            listado = listado.concat(i +"- ");
            listado = listado.concat(mods.toString());
            listado = listado.concat("\n");
        }
        listado = listado.concat("\n\n----------------------------------------------------\n");
        return listado;
    }

    @Override
    public String toString() {
        return listaModificaciones();
    }
}

