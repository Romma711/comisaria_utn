package Almacen;

import Interfaces.AL;
import java.util.ArrayList;
import java.util.UUID;

public class Caso extends Registro implements AL<Evidencia> {
    private ArrayList<Evidencia> caja;
    private String comentario;

    public Caso(String comentario) {
        super();
        caja = new ArrayList<>();
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public boolean agregar(Evidencia dato) {
        return caja.add(dato);
    }

    @Override
    public void listar() {
        for (Evidencia evidencia : caja) {
            System.out.println(evidencia.toString());
        }
    }
}
