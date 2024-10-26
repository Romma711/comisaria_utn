package Almacen;

import Enums.T_Material;
import java.util.UUID;


public class Material_Policial extends Registro {
    private String idPropietario;
    private T_Material tipo;

    public Material_Policial(String idPropietario, T_Material tipo) {
        super();
        this.idPropietario = idPropietario;
        this.tipo = tipo;
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
    public String toString() {
        return "Material policial:" +
                "\n  ID: " + super.getId() +
                "\n  Propiedad del material: " + idPropietario +
                super.toString();
    }
}

