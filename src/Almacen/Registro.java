package Almacen;
///region IMPORTS
import Interfaces.AL;
import java.util.ArrayList;
import java.util.UUID;
///endregion

public class Registro implements AL<Modificacion> {
    private UUID idRegistro;
    private ArrayList<Modificacion> modificaciones;

    public Registro() {
        idRegistro = UUID.randomUUID();
        modificaciones = new ArrayList<>();
    }

    ///region AL
    @Override
    public boolean agregar(Modificacion dato) {
        return modificaciones.add(dato);
    }

    @Override
    public void listar() {
        for (Modificacion modificacion : modificaciones) {
            System.out.println(modificacion.toString());
        }
    }
    ///endregion
}
