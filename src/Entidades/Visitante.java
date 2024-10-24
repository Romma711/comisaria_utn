package Entidades;

import java.util.Date;
import java.util.UUID;

public class Visitante extends Ingresante {

    public Visitante(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, Date fechaIngreso, String razon, String nroCasillero, Integer cantidadVisitas) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero, fechaIngreso, razon, nroCasillero, cantidadVisitas);
        super.setId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

// TODO modificar el ToString()
