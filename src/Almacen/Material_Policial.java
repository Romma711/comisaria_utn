package Almacen;

import Enums.T_Material;

public class Material_Policial extends Registro {
    private String idPropietario;
    private final T_Material tipo;

    public Material_Policial(String idPropietario, T_Material tipo) {
        super();
        this.idPropietario = idPropietario;
        this.tipo = tipo;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    @Override
    public String toString() {
        return "Material policial:" +
                "\n  ID: " + super.getId() +
                "\n  Tipo: " + tipo.toString().toLowerCase() +
                "\n  Propiedad del material: " + idPropietario +
                super.toString();
    }
}

