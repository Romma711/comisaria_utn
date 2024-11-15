package Entidades;

import Enums.T_Estado;
import Interfaces.IJson;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Procesado extends Ingresante implements IJson<Procesado> {
    private LocalDate fechaEgreso;
    private T_Estado estado;

    public Procesado(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero,String razon, String nroCasillero,LocalDate fechaEgreso, T_Estado estado) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero,razon, nroCasillero);

        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
    }

    public Procesado() {
    }

    //region GETTERS & SETTERS

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }
    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
    public T_Estado getEstado() {
        return estado;
    }
    public void setEstado(T_Estado estado) {
        this.estado = estado;
    }
    //endregion

    public void crearProcesado() {
        super.crearIngresante();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el estado del procesado 1.PROCESADO,\n" +
                "2.INDULTADO,\n" +
                "3.DETENIDO,\n" +
                "4.MIGRADO\n");
        switch (scan.nextInt()){
            case 1 -> estado = T_Estado.PROCESADO;
            case 2 -> estado = T_Estado.LIBERADO;
            case 3 -> estado = T_Estado.DETENIDO;
            case 4 -> estado = T_Estado.MIGRADO;
        }
    }



    @Override
    public String toString() {
        return super.toString() +
                ", Procesado{" +
                ", fechaEgreso=" + fechaEgreso +
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
        json.put("fecha_egreso",this.getFechaEgreso());
        json.put("id_calabozo",this.getId());
        json.put("estado",this.getEstado().getClass());
        return json;
    }
}


// TODO modificar el ToString()
