package Entidades;

import java.util.Date;
import java.util.UUID;

public abstract class Ingresante extends Persona{
    private Date fechaIngreso;
    private String razon, nroCasillero;
    private UUID id;
    private Integer cantidadVisitas;

    public Ingresante(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, Date fechaIngreso, String razon, String nroCasillero, Integer cantidadVisitas) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        id = UUID.randomUUID();
        this.fechaIngreso = fechaIngreso;
        this.razon = razon;
        this.nroCasillero = nroCasillero;
        this.cantidadVisitas = cantidadVisitas;
    }

    ///region GETTERS & SETTERS
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
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
    public UUID getId() {
        return id;
    }
    protected void setId(UUID id) {
        this.id = id;
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
