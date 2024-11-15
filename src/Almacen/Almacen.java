package Almacen;

import Enums.T_Registro;
import Interfaces.IJson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class Almacen implements IJson<Almacen> {
    private final HashMap<T_Registro, ArrayList<Registro>> almacen;

    public Almacen() {
        almacen = new HashMap<>();
    }

    public boolean agregarAlAlmacen(T_Registro tipoRegistro, Registro nuevoRegistro) {
        ArrayList<Registro> listaRegistros = almacen.get(tipoRegistro);
        if (listaRegistros != null) {
            return listaRegistros.add(nuevoRegistro);
        }
        listaRegistros = new ArrayList<>();
        almacen.put(tipoRegistro,listaRegistros);
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

    @Override
    public Almacen jsonToThisClass(JSONObject json) {
        return null;
    }

    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("Almacen",almacen);
        return json;
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
