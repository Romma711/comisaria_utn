package Entidades;

import Interfaces.IJson;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public abstract class Ingresante extends Persona implements IJson<Ingresante> {
    private static int contadorId = 100000;
    private int id;
    private String fechaIngreso;
    private String razon, nroCasillero;

    public Ingresante(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, String razon, String nroCasillero) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        this.id = contadorId++;
        this.fechaIngreso = LocalDate.now().toString();
        this.razon = razon;
        this.nroCasillero = nroCasillero;
    }

    public Ingresante() {
        contadorId++;
        id = contadorId;
        this.fechaIngreso = LocalDate.now().toString();
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
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la razon del ingreso");
        this.razon = scan.nextLine();
        System.out.println("Ingrese el numero de casillero donde se guardaron sus pertenencias");
        this.nroCasillero = scan.nextLine();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingresante that)) return false;
        return id == that.id;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Ingresante{" +
                ", id= " + id +
                ", fechaIngreso= " + fechaIngreso +
                ", razon= " + razon +
                ", nroCasillero= " + nroCasillero +
                '}';
    }
}

// TODO modificar el ToString()
