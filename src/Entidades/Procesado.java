package Entidades;

import Enums.T_Estado;
import Interfaces.IJson;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Objects;

public class Procesado extends Ingresante implements IJson<Procesado> {
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

    @Override
    public Procesado jsonToThisClass(JSONObject json) {
        return null;
    }

    @Override
    public JSONObject classToJson() {
        JSONObject json=new JSONObject();
        json.put("nombre",this.getNombre());
        json.put("apellido",this.getApellido());
        json.put("direccion",this.getDireccion());
        json.put("telefono",this.getTelefono());
        json.put("dni",this.getDni());
        json.put("edad",this.getEdad());
        json.put("genero",this.getGenero());
        json.put("fecha_ingreso",this.getFechaIngreso());
        json.put("razon",this.getRazon());
        json.put("nro_casillero",this.getNroCasillero());
        json.put("id",this.getId());
        json.put("cantidad_visitas",this.getCantidadVisitas());
        json.put("comentario",this.getComentario());
        json.put("fecha_egreso",this.getFechaEgreso());
        json.put("id_calabozo",this.getId());
        json.put("estado",this.getEstado().getClass());
        return json;
    }
}


// TODO modificar el ToString()
