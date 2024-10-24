package Area;

import Entidades.Perro;
import Interfaces.ABML;
import java.util.ArrayList;

public class Perrera implements ABML<Perro> {
    private ArrayList<Perro> perritos;

    public Perrera() {
        perritos = new ArrayList<>();
    }

    ///region ABML
    @Override
    public boolean agregar(Perro dato) {
        return perritos.add(dato);
    }

    @Override
    public boolean eliminar(Perro dato) {
        return perritos.remove(dato);
    }

    @Override
    public void modificar(Perro dato) {

    }

    @Override
    public void listar() {
        for (Perro perro : perritos) {
            System.out.println(perro.toString());
        }
    }
    ///endregion

}

// TODO modificar del ABML.