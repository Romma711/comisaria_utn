package Almacen;
///region IMPORTS
import Enums.T_Material;
import Interfaces.ABML;
import Interfaces.AL;
import java.util.ArrayList;
import java.util.HashMap;
///endregion

public class Almacen implements AL<Registro> {
    private HashMap<T_Material, ArrayList<Registro>> almacen;

    public Almacen() {
        almacen = new HashMap<>();
    }

    public boolean nuevoMaterial(T_Material material) {
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
        for (T_Material clave : almacen.keySet()) {
            ArrayList<Registro> valor = almacen.get(clave);
            System.out.println("Material: " + clave + "\nRegistros:\n" + valor.toString());
        }
    }
}

//TODO ver nuevoMaterial() y agregar()
