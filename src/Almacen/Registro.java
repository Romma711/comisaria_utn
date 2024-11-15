package Almacen;

import org.json.JSONObject;
import java.util.ArrayList;

public abstract class Registro{
    private static Integer cont = 10000;
    private Integer id;
    protected final ArrayList<Modificacion> modificaciones;

    public Registro() {
        cont++;
        id = cont;
        modificaciones = new ArrayList<>();
    }

    ///region MODIFICACIONES
    public boolean agregarMod(Modificacion dato) {
        return modificaciones.add(dato);
    }
    protected Modificacion retornarPosicion(int i){
        return modificaciones.get(i);
    }
    protected int retornarLenght(){
        return modificaciones.size();
    }
    ///endregion

    ///region GETTERS & SETTERS
    public Integer getId() {
        return id;
    }
    protected void setId (Integer id) {
        this.id = id;
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

