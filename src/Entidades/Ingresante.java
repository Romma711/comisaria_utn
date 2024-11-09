package Entidades;

import java.time.LocalDate;

public abstract class Ingresante extends Persona{
    private static int contadorId = 100000;
    private final int id;
    private LocalDate fechaIngreso;
    private String razon, nroCasillero;
    private Integer cantidadVisitas;

    public Ingresante(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, LocalDate fechaIngreso, String razon, String nroCasillero, Integer cantidadVisitas) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        this.id = contadorId++;
        this.fechaIngreso = fechaIngreso;
        this.razon = razon;
        this.nroCasillero = nroCasillero;
        this.cantidadVisitas = cantidadVisitas;
    }

    ///region GETTERS & SETTERS
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

    public Integer getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(Integer cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }
    ///endregion
    @Override
    public String toString() {
        return super.toString() +
                ", Ingresante{" +
                "id=" + id +
                ", fechaIngreso=" + fechaIngreso +
                ", razon='" + razon + '\'' +
                ", nroCasillero='" + nroCasillero + '\'' +
                ", cantidadVisitas=" + cantidadVisitas +
                '}';
    }
}

// TODO modificar el ToString()
