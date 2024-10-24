package Almacen;

import java.util.UUID;

public class Material_Policial {
    private UUID propiedad;

    public Material_Policial(UUID propiedad) {
        this.propiedad = propiedad;
    }

    ///region GETTERS & SETTERS
    public UUID getPropiedad() {
        return propiedad;
    }
    public void setPropiedad(UUID propiedad) {
        this.propiedad = propiedad;
    }
    ///endregion


    @Override
    public String toString() {
        return "Material propiedad del id: " + propiedad;
    }
}
