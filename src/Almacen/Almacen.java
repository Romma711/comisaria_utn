package Almacen;

import Enums.T_Registro;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class Almacen {
    private HashMap<T_Registro, ArrayList<Registro>> almacen;

    public Almacen() {
        almacen = new HashMap<>();
    }

    public boolean agregarAlAlmacen(T_Registro tipoRegistro, Registro nuevoRegistro) {
        ArrayList<Registro> listaRegistros = almacen.computeIfAbsent(tipoRegistro, k -> new ArrayList<>());
        return listaRegistros.add(nuevoRegistro);
    }

    public Registro buscarPorID(Integer id) {
        for (T_Registro clave : almacen.keySet()) {
            ArrayList<Registro> valor = almacen.get(clave);
            for (Registro reg : valor) {
                if (reg.getId().equals(id)) {
                    return reg;
                }
            }
        }
        return null;
    }
    public Registro crearRegistro(T_Registro clave) {
        return switch (clave) {
            case CASO -> new Caso();
            case DENUNCIAS -> new Denuncia();
            case MATERIAL_POLICIAL -> new Material_Policial();
        };
    }
    public Almacen jasonToThisClass(JSONObject jason) {
        Almacen almacen = new Almacen();

        for (T_Registro clave : T_Registro.values()) {
            if (jason.has(clave.name())) {
                JSONArray jsonArray = jason.getJSONArray(clave.name());

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject registroJson = jsonArray.getJSONObject(i);
                    Registro registro = crearRegistro(clave);
                    almacen.agregarAlAlmacen(clave, registro.jsonToThisClass(registroJson));
                }
            }
        }
        return almacen;
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
