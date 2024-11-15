package Almacen;

import Interfaces.IJson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Caso extends Registro {
    private String nombre;
    private final ArrayList<Evidencia> caja = new ArrayList<>();
    private String comentario;

    public Caso(String nombre,String comentario) {
        super();
        this.comentario = comentario;
        this.nombre = nombre;
    }
    public Caso() {
        super();
    }

    ///region GETTERS & SETTERS
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    ///endregion

    public int retornarLength(){
        return caja.size();
    }
    public Evidencia retornarEvidencia(int i){
        return caja.get(i);
    }

    ///region AL
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
    ///endregion

    @Override
    public String toString() {
        return "Caso:" +
                "\n  ID del caso: " + super.getId() +
                "\n  Comentario del caso: " + comentario +
                "\n" + lista() +
                super.toString();
    }
}

//TODO revisar listar() con pruebas en consola.
