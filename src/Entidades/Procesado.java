package Entidades;

import Enums.T_Estado;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


public class Procesado extends Ingresante {
    private String comentario;
    private LocalDate fechaEgreso;
    private UUID idCalabozo;
    private T_Estado estado;

    public Procesado(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, Date fechaIngreso, String razon, String nroCasillero, Integer cantidadVisitas, String comentario, LocalDate fechaEgreso, UUID idCalabozo, T_Estado estado) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero, fechaIngreso, razon, nroCasillero, cantidadVisitas);
        super.setId(UUID.randomUUID());
        this.comentario = comentario;
        this.fechaEgreso = fechaEgreso;
        this.idCalabozo = idCalabozo;
        this.estado = estado;
    }

    ///region GETTERS & SETTERS
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
    public UUID getIdCalabozo() {
        return idCalabozo;
    }
    public void setIdCalabozo(UUID idCalabozo) {
        this.idCalabozo = idCalabozo;
    }
    public T_Estado getEstado() {
        return estado;
    }
    public void setEstado(T_Estado estado) {
        this.estado = estado;
    }
    ///endregion


    @Override
    public String toString() {
        return super.toString() +
                ", Procesado{" +
                "comentario='" + comentario + '\'' +
                ", fechaEgreso=" + fechaEgreso +
                ", idCalabozo=" + idCalabozo +
                ", estado=" + estado +
                '}';
    }
}

// TODO modificar el ToString()
