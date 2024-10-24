package Almacen;

import Enums.T_Registro;
import Interfaces.AL;
import java.util.ArrayList;
import java.util.HashMap;

public class Almacen implements AL<Registro> {
    private HashMap<T_Registro, ArrayList<Registro>> almacen;

    public Almacen() {
        almacen = new HashMap<>();
    }

    public boolean nuevoMaterial(T_Registro material) {
        if (almacen.containsKey(material)) {
            return false;
        } else {
            almacen.put(material, new ArrayList<>());
            return true;
        }
    }

    @Override
    public boolean agregar(Registro dato) {
        return true;
    }

    @Override
    public void listar() {
        for (T_Registro clave : almacen.keySet()) {
            ArrayList<Registro> valor = almacen.get(clave);
            System.out.println("Material: " + clave + "\nRegistros:\n" + valor.toString());
        }
    }
}

//TODO ver nuevoMaterial() y agregar()
