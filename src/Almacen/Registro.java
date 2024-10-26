package Almacen;

import java.util.ArrayList;
import java.util.UUID;


public abstract class Registro {
    private UUID id;
    private ArrayList<Modificacion> modificaciones;

    public Registro() {
        id = UUID.randomUUID();
        modificaciones = new ArrayList<>();
    }

    ///region AL de Registro
    public boolean agregarMod(Modificacion dato) {
        return modificaciones.add(dato);
    }
    public void listarMods() {
        for (Modificacion modificacion : modificaciones) {
            System.out.println(modificacion.toString());
        }
    }
    ///endregion

    ///region GETTERS & SETTERS
    public UUID getId() {
        return id;
    }
    ///endregion

    public String listaRegistros() {
        String listado = "";
        int i = 0;
        for (Modificacion mods : modificaciones) {
            i++;
            listado = listado.concat(i +"- ");
            listado = listado.concat(mods.toString());
            listado = listado.concat("\n");
        }
        return listado;
    }

    @Override
    public String toString() {
        return "Registro:" +
                "\nID: " + id + '\n' +
                listaRegistros();
    }
}

