package Almacen;

import java.util.ArrayList;
import java.util.UUID;


public abstract class Registro {
    private static Integer cont = 10000;
    private Integer id;
    private ArrayList<Modificacion> modificaciones;

    public Registro() {
        cont++;
        id = cont;
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
    public Modificacion retornarPosicion(int i){
        return modificaciones.get(1);
    }
    public int retornarLenght(){
        return modificaciones.size();
    }
    ///endregion

    ///region GETTERS & SETTERS
    public Integer getId() {
        return id;
    }
    ///endregion

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

