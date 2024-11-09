package Entidades;

import java.time.LocalDate;
import java.util.Date;

public class Visitante extends Ingresante {

    public Visitante(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, LocalDate fechaIngreso, String razon, String nroCasillero, Integer cantidadVisitas) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero, fechaIngreso, razon, nroCasillero, cantidadVisitas);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

// TODO modificar el ToString()
