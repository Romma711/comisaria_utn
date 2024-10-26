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

    public void agregarAlAlmacen(T_Registro tipoRegistro, Registro nuevoRegistro) {
        ArrayList<Registro> listaRegistros = almacen.get(tipoRegistro);
        if (listaRegistros == null) {
            listaRegistros = new ArrayList<>();
            almacen.put(tipoRegistro,listaRegistros);
        }
        listaRegistros.add(nuevoRegistro);
    }

    ///region AL
    @Override
    public boolean agregarNoModifcable(Registro dato) {
        return true;
    }
    @Override
    public String lista() {
        String listado = "";
        for (T_Registro clave : almacen.keySet()) {
            ArrayList<Registro> valor = almacen.get(clave);
            listado = listado.concat("Material: " + clave+ "\n");
            for (Registro reg : valor) {
                listado = listado.concat("Registros:\n" + reg.toString());
            }
        }
        return listado;
    }
    ///endregion
}


//TODO revisar listar() con pruebas en consola.
