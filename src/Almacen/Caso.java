package Almacen;

import Interfaces.AL;
import java.util.ArrayList;


public class Caso extends Registro implements AL<Evidencia> {
    private ArrayList<Evidencia> caja;
    private String comentario;

    public Caso(String comentario) {
        super();
        caja = new ArrayList<>();
        this.comentario = comentario;
    }

    ///region GETTERS & SETTERS
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    ///endregion

    ///region AL
    @Override
    public boolean agregarNoModifcable(Evidencia dato) {
        return caja.add(dato);
    }
    @Override
    public String lista() {
        String listado = "";
        int i = 0;
        for (Evidencia evidencia : caja) {
            i++;
            listado = listado.concat(i + "- ");
            System.out.println(evidencia.toString());
        }
        return null;
    }
    ///endregion

    @Override
    public String toString() {
        return "Caso:" +
                "\nComentario del caso: " + comentario +
                "\n" + lista();
    }
}

//TODO revisar listar() con pruebas en consola.