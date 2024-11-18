package Entidades;

import Enums.T_Estado;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Procesado extends Ingresante {
    private String fechaEgreso;
    private T_Estado estado;

    public Procesado(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero,String razon, String nroCasillero,T_Estado estado) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero,razon, nroCasillero);

        this.fechaEgreso = null;
        this.estado = estado;
    }

    public Procesado() {
        super();
    }

    //region GETTERS & SETTERS

    public String getFechaEgreso() {
        return fechaEgreso;
    }
    public void setFechaEgreso(String fechaEgreso) {
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
        return "Procesado{" +
                ", Id= " + getId() +
                ", Nombre='" + getNombre() + '\'' +
                ", Apellido='" + getApellido() + '\'' +
                ", Dni='" + getDni() + '\'' +
                ", Edad=" + getEdad() +
                ", Genero=" + getGenero() +
                ", FechaIngreso= " + getFechaIngreso() +
                ", Razon= " + getRazon() +
                ", NroCasillero= " + getNroCasillero() +
                ", FechaEgreso=" + fechaEgreso +
                ", Estado=" + estado +
                '}';
    }

    @Override
    public Procesado jsonToThisClass(JSONObject json) {
        Procesado recuperado = new Procesado();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        recuperado.setNombre(json.getString("nombre"));
        recuperado.setApellido(json.getString("apellido"));
        recuperado.setDni(json.getString("dni"));
        recuperado.setTelefono(json.getString("telefono"));
        recuperado.setDireccion(json.getString("direccion"));
        recuperado.setEdad(json.getInt("edad"));
        recuperado.setGenero(json.getString("genero").charAt(0));
        recuperado.setId(json.getInt("id"));
        recuperado.setRazon(json.getString("razon"));
        recuperado.setFechaIngreso(LocalDate.parse(json.getString("fecha_ingreso"),dateFormatter));
        if(json.has("fecha_egreso")){
            recuperado.setFechaEgreso(json.getString("fecha_egreso"));
        }
        recuperado.setNroCasillero(json.getString("numero_casillero"));
        recuperado.setEstado(json.getEnum(T_Estado.class,"estado"));
        return recuperado;
    }

    @Override
    public JSONObject classToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre",super.getNombre());
        jsonObject.put("apellido",super.getApellido());
        jsonObject.put("dni",super.getDni());
        jsonObject.put("telefono",super.getTelefono());
        jsonObject.put("direccion",super.getDireccion());
        jsonObject.put("edad",super.getEdad());
        jsonObject.put("genero",super.getGenero());
        jsonObject.put("fecha_ingreso",super.getFechaIngreso());
        jsonObject.put("id",super.getId());
        jsonObject.put("razon",super.getRazon());
        jsonObject.put("numero_casillero",super.getNroCasillero());
        jsonObject.put("fecha_egreso",getFechaEgreso());
        jsonObject.put("estado",getEstado());
        return jsonObject;
    }
}


// TODO modificar el ToString()
