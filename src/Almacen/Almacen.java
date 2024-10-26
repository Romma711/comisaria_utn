package Almacen;

import Enums.T_Registro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


public class Almacen {
    private HashMap<T_Registro, ArrayList<Registro>> almacen;

    public Almacen() {
        almacen = new HashMap<>();
    }

    public boolean agregarAlAlmacen(T_Registro tipoRegistro, Registro nuevoRegistro) {
        ArrayList<Registro> listaRegistros = almacen.get(tipoRegistro);
        if (listaRegistros == null) {
            listaRegistros = new ArrayList<>();
            almacen.put(tipoRegistro,listaRegistros);
        }
        return listaRegistros.add(nuevoRegistro);
    }

    public Registro buscarPorID(String id) {
        for (T_Registro clave : almacen.keySet()) {
            ArrayList<Registro> valor = almacen.get(clave);
            for (Registro reg : valor) {
                if (reg.getId().toString().equals(id)) {
                    return reg;
                }
            }
        }
        return null;
    }

    public String lista() {
        String listado = "";
        int i;
        for (T_Registro clave : almacen.keySet()) {
            i = 0;
            ArrayList<Registro> valor = almacen.get(clave);
            listado = listado.concat("Tipo de registro: " + clave + "\n");
            for (Registro reg : valor) {
                i++;
                listado = listado.concat("  " + i +"- ");
                listado = listado.concat(reg.toString());
            }
        }
        return listado;
    }
}

//TODO revisar listar() con pruebas en consola.
