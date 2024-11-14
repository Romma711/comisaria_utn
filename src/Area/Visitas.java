package Area;

import Exceptions.NoEncontradoException;
import Exceptions.YaExisteException;
import Interfaces.ABML;

import java.util.ArrayList;
import java.util.ListIterator;

public class Visitas implements ABML<Visita> {
    private ArrayList<Visita> visitas;

    public Visitas(){
        visitas= new ArrayList<>();
    }


    @Override
    public boolean agregar(Visita dato)  {

        return visitas.add(dato);
    }

    @Override
    public boolean eliminar(Visita dato) {

        return visitas.remove(dato);
    }

    @Override
    public void modificar(Visita dato){


    }

    @Override
    public void listar() {
        ListIterator<Visita> iterator = visitas.listIterator();
        while (iterator.hasNext()){
            System.out.println();
        }
    }
}
