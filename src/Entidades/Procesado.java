package Entidades;

import Enums.T_Estado;

import java.time.LocalDate;
import java.util.Objects;

public class Procesado extends Ingresante {
    private String comentario;
    private LocalDate fechaEgreso;
    private int id;
    private T_Estado estado;

    public Procesado(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, LocalDate fechaIngreso, String razon, String nroCasillero, Integer cantidadVisitas, String comentario, LocalDate fechaEgreso, T_Estado estado) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero, fechaIngreso, razon, nroCasillero, cantidadVisitas);
        this.comentario = comentario;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
    }

    // GETTERS & SETTERS
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { // Nuevo setter para asignar ID desde Calabozo
        this.id = id;
    }

    public T_Estado getEstado() {
        return estado;
    }

    public void setEstado(T_Estado estado) {
        this.estado = estado;
    }

    // Métodos equals y hashCode para comparación
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procesado procesado = (Procesado) o;
        return id == procesado.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Procesado{" +
                "comentario='" + comentario + '\'' +
                ", fechaEgreso=" + fechaEgreso +
                ", id=" + id +
                ", estado=" + estado +
                '}';
    }
}


// TODO modificar el ToString()
