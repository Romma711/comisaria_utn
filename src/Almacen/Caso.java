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
    public int retornarLength(){
        return caja.size();
    }
    public Evidencia retornarEvidencia(int i){
        return caja.get(i);
    }

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
