package Almacen;

import Enums.T_Material;
import java.util.UUID;


public class Material_Policial extends Registro {
    private UUID idPropietario;
    private T_Material tipo;

    public Material_Policial(UUID idPropietario, T_Material tipo) {
        super();
        this.idPropietario = idPropietario;
        this.tipo = tipo;
    }

    ///region GETTERS & SETTERS
    public UUID getIdPropietario() {
        return idPropietario;
    }
    public void setIdPropietario(UUID idPropietario) {
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
                "ID: " + super.getId() +
                "propiedad del id: " + idPropietario;
    }
}
