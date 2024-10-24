package Entidades;

import Enums.T_Rango;
import java.util.UUID;

public class MiembroFuerza  extends Persona{
    public UUID legajo;
    public T_Rango rango;
    public Double salario, horasTotalesMes;
    public String serialArma, placa;
    public Boolean servicio;
    public Integer condecoraciones, horasDiarias;


    public MiembroFuerza(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, T_Rango rango, Double salario, Double horasTotalesMes, String serialArma, String placa, Boolean servicio, Integer condecoraciones, Integer horasDiarias) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        legajo = UUID.randomUUID();
        this.rango = rango;
        this.salario = salario;
        this.horasTotalesMes = horasTotalesMes;
        this.serialArma = serialArma;
        this.placa = placa;
        this.servicio = servicio;
        this.condecoraciones = condecoraciones;
        this.horasDiarias = horasDiarias;
    }

    ///region GETTERS & SETTERS
    public T_Rango getRango() {
        return rango;
    }
    public void setRango(T_Rango rango) {
        this.rango = rango;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public Double getHorasTotalesMes() {
        return horasTotalesMes;
    }
    public void setHorasTotalesMes(Double horasTotalesMes) {
        this.horasTotalesMes = horasTotalesMes;
    }
    public UUID getLegajo() {
        return legajo;
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
    public Integer getHorasDiarias() {
        return horasDiarias;
    }
    public void setHorasDiarias(Integer horasDiarias) {
        this.horasDiarias = horasDiarias;
    }
    ///endregion


    @Override
    public String toString() {
        return "MiembroFuerza{" +
                "legajo=" + legajo +
                ", rango=" + rango +
                ", salario=" + salario +
                ", horasTotalesMes=" + horasTotalesMes +
                ", serialArma='" + serialArma + '\'' +
                ", placa='" + placa + '\'' +
                ", servicio=" + servicio +
                ", condecoraciones=" + condecoraciones +
                ", horasDiarias=" + horasDiarias +
                '}';
    }
}

// TODO modificar el ToString()
