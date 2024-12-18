package Entidades;

import Interfaces.IJson;
import utils.Verificador;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public abstract class Ingresante extends Persona implements IJson<Ingresante> {
    private static int contadorId = 100000;
    private int id;
    private LocalDate fechaIngreso;
    private String razon, nroCasillero;

    public Ingresante(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, String razon, String nroCasillero) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        this.id = contadorId++;
        this.fechaIngreso = LocalDate.now();
        this.razon = razon;
        this.nroCasillero = nroCasillero;
    }

    public Ingresante() {
        contadorId++;
        id = contadorId;
        this.fechaIngreso = LocalDate.now();
    }

    //region GETTERS & SETTERS

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Ingresante.contadorId = contadorId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getRazon() {
        return razon;
    }
    public void setRazon(String razon) {
        this.razon = razon;
    }
    public String getNroCasillero() {
        return nroCasillero;
    }
    public void setNroCasillero(String nroCasillero) {
        this.nroCasillero = nroCasillero;
    }
    public int getId() {
        return id;
    }
    //endregion

    public void crearIngresante() {
        super.crearPersona();
        System.out.println("Ingrese la razon del ingreso");
        this.razon = Verificador.verificarString();
        System.out.println("Ingrese el numero de casillero donde se guardaron sus pertenencias");
        this.nroCasillero = Verificador.verificarString();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Ingresante:" +
                ", id= " + id +
                ", fechaIngreso= " + fechaIngreso +
                ", razon= " + razon +
                ", nroCasillero= " + nroCasillero +
                '}';
    }
}

// TODO modificar el ToString()
