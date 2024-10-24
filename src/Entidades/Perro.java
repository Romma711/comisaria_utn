package Entidades;

import Enums.T_Raza;
import java.util.UUID;

public class Perro {
    private UUID idPerro;
    private T_Raza raza;
    private String nombre;
    private Integer edad;
    private Double horasServicio;

    public Perro(T_Raza raza, String nombre, Integer edad, Double horasServicio) {
        idPerro = UUID.randomUUID();
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;
        this.horasServicio = horasServicio;
    }

    ///region GETTERS & SETTERS
    public UUID getIdPerro() {
        return idPerro;
    }
    public T_Raza getRaza() {
        return raza;
    }
    public void setRaza(T_Raza raza) {
        this.raza = raza;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Double getHorasServicio() {
        return horasServicio;
    }
    public void setHorasServicio(Double horasServicio) {
        this.horasServicio = horasServicio;
    }
    ///endregion


    @Override
    public String toString() {
        return "Perro{" +
                "idPerro=" + idPerro +
                ", nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", edad=" + edad +
                ", horasServicio=" + horasServicio +
                '}';
    }
}
