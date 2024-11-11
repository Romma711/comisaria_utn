package Entidades;

import Enums.T_Rango;
import org.json.JSONObject;

import java.util.UUID;

public class MiembroFuerza  extends Personal{
    public T_Rango rango;
    public String serialArma, placa;
    public Boolean servicio;
    public Integer condecoraciones;


    public MiembroFuerza(String dni, String nombre, String apellido,
                         String direccion, String telefono,
                         Integer edad, Character genero,
                         Integer horasDiarias, Double salario,
                         Double horasTotalesMes, T_Rango rango,
                         String serialArma, String placa,
                         Boolean servicio, Integer condecoraciones) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero, horasDiarias, salario, horasTotalesMes);
        this.rango = rango;
        this.serialArma = serialArma;
        this.placa = placa;
        this.servicio = servicio;
        this.condecoraciones = condecoraciones;
    }

    ///region GETTERS & SETTERS

    public T_Rango getRango() {
        return rango;
    }

    public void setRango(T_Rango rango) {
        this.rango = rango;
    }

    public String getSerialArma() {
        return serialArma;
    }

    public void setSerialArma(String serialArma) {
        this.serialArma = serialArma;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getServicio() {
        return servicio;
    }

    public void setServicio(Boolean servicio) {
        this.servicio = servicio;
    }

    public Integer getCondecoraciones() {
        return condecoraciones;
    }

    public void setCondecoraciones(Integer condecoraciones) {
        this.condecoraciones = condecoraciones;
    }

    ///endregion

    @Override
    public Personal jsonToThisClass(JSONObject json) {
        return null;
    }
    ///Esta funcion convierte el objeto en json
    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("nombre",this.getNombre());
        json.put("apellido",this.getApellido());
        json.put("direccion",this.getDireccion());
        json.put("telefono",this.getTelefono());
        json.put("dni",this.getDni());
        json.put("edad",this.getEdad());
        json.put("genero",this.getGenero());
        json.put("legajo",this.getLegajo());
        json.put("horas_diarias",this.getHorasDiarias());
        json.put("salario",this.getSalario());
        json.put("horas_mes",this.getHorasTotalesMes());
        json.put("tarea",this.getTarea());
        json.put("rango",this.getRango().getClass());
        json.put("serial_arma",this.getSerialArma());
        json.put("placa",this.getPlaca());
        json.put("servicio",this.getServicio());
        json.put("condecoraciones",this.getCondecoraciones());
        return json;
    }


    @Override
    public String toString() {
        return "MiembroFuerza{" +
                "legajo=" + super.getLegajo() +
                ", rango=" + rango +
                ", salario=" + super.getSalario() +
                ", horasTotalesMes=" + super.getHorasTotalesMes() +
                ", serialArma='" + serialArma + '\'' +
                ", placa='" + placa + '\'' +
                ", servicio=" + servicio +
                ", condecoraciones=" + condecoraciones +
                ", horasDiarias=" + super.getHorasDiarias() +
                '}';
    }
}

// TODO modificar el ToString()
