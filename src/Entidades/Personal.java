package Entidades;

import java.util.UUID;

public class Personal extends Persona{
    private Integer legajo;
    private Integer horasDiarias;
    private Double salario, horasTotalesMes;
    private String tarea;
    private boolean activo;
    private static Integer cont=100000;

    public Personal(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, Integer horasDiarias, Double salario, Double horasTotalesMes) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        legajo = cont;
        cont++;
        this.activo = true;
        this.horasDiarias = horasDiarias;
        this.salario = salario;
        this.horasTotalesMes = horasTotalesMes;
    }

    //region GETTERS & SETTERS
    public Integer getLegajo() {
        return legajo;
    }
    public Integer getHorasDiarias() {
        return horasDiarias;
    }
    public void setHorasDiarias(Integer horasDiarias) {
        this.horasDiarias = horasDiarias;
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
    public String getTarea() {
        return tarea;
    }
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }


//endregion


    @Override
    public String toString() {
        return "Personal{" +
                "legajo=" + legajo +
                ", horasDiarias=" + horasDiarias +
                ", salario=" + salario +
                ", horasTotalesMes=" + horasTotalesMes +
                '}';
    }
}

// TODO modificar el ToString()
