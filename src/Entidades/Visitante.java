package Entidades;

import Interfaces.IJson;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Date;

public class Visitante extends Ingresante implements IJson<Visitante> {

    public Visitante(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, LocalDate fechaIngreso, String razon, String nroCasillero, Integer cantidadVisitas) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero, fechaIngreso, razon, nroCasillero, cantidadVisitas);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Visitante jsonToThisClass(JSONObject json) {
        return null;
    }

    @Override
    public JSONObject classToJson() {
        return null;
    }
}

// TODO modificar el ToString()
