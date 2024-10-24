package Area;

import Enums.T_Depto;
import Entidades.Persona;
import Interfaces.ABML;
import java.util.ArrayList;

public class Departamento<T extends Persona> implements ABML<T> {
    private ArrayList<T> listaEmpleados;
    private T_Depto depto;
    private ArrayList<String> tareas;

    public Departamento(T_Depto depto) {
        listaEmpleados = new ArrayList<>();
        this.depto = depto;
        tareas = new ArrayList<>();
    }

    ///region ABML
    @Override
    public boolean agregar(T dato) {
        return listaEmpleados.add(dato);
    }

    @Override
    public boolean eliminar(T dato) {
        return listaEmpleados.remove(dato);
    }

    @Override
    public void modificar(T dato) {
        listar();
        System.out.println("Seleccione el departamento");
    }

    @Override
    public void listar() {

    }
    ///endregion
}

// TODO modificar, listar del ABML
