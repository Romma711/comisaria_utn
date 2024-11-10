package Almacen;

import Enums.T_Material;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.UUID;


public class Material_Policial extends Registro {
    private String idPropietario;
    private T_Material tipo;

    public Material_Policial(String idPropietario, T_Material tipo) {
        super();
        this.idPropietario = idPropietario;
        this.tipo = tipo;
    }
    public Material_Policial() {
    }

    ///region GETTERS & SETTERS
    public String getIdPropietario() {
        return idPropietario;
    }
    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }
    public T_Material getTipo() {
        return tipo;
    }
    public void setTipo(T_Material tipo) {
        this.tipo = tipo;
    }
    ///endregion

    @Override
    public Material_Policial jsonToThisClass(JSONObject jason) {
        Material_Policial mat_pol = new Material_Policial();
        mat_pol.setId(jason.getInt("id"));
        mat_pol.setIdPropietario(jason.getString("idPropietario"));
        mat_pol.setTipo(jason.getEnum(T_Material.class,"tipo"));

        JSONArray listado = jason.getJSONArray("modificaciones");
        for (int i = 0; i < listado.length(); i++) {
            JSONObject modificacionJSON = listado.getJSONObject(i);
            Modificacion modificacion = new Modificacion();
            modificacion = modificacion.jsonToThisClass(modificacionJSON);

            mat_pol.agregarMod(modificacion);
        }

        return mat_pol;
    }

    @Override
    public String toString() {
        return "Material policial:" +
                "\n  ID: " + super.getId() +
                "\n  Propiedad del material: " + idPropietario +
                super.toString();
    }
}

