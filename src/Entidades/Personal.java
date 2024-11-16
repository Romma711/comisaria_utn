package Entidades;

import Interfaces.IJson;
import org.json.JSONObject;

import java.util.Scanner;
import java.util.UUID;

public class Personal extends Persona{
    private Integer legajo, horasTotalesMes;
    private Double salario;
    private String tarea;
    private boolean activo;
    private static Integer cont=99999;

    public Personal(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, Double salario, Integer horasTotalesMes) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        cont++;
        legajo = cont;
        this.activo = true;
        this.salario = salario;
        this.horasTotalesMes = horasTotalesMes;
    }

    public Personal() {
        cont++;
        legajo=cont;
        activo=true;
    }

    //region GETTERS & SETTERS
    public Integer getLegajo() {
        return legajo;
    }
    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public Integer getHorasTotalesMes() {
        return horasTotalesMes;
    }
    public void setHorasTotalesMes(Integer horasTotalesMes) {
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

    public void crearPersonal(){
        super.crearPersona();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar horas por mes(Numero entero):");
        this.horasTotalesMes = scan.nextInt();
        System.out.println("Ingresar salario(numero decimal separado por coma ej: 203,4):");
        this.salario = scan.nextDouble();
        System.out.println("Ingresar la tarea a ejercer:");
        scan.nextLine();
        this.tarea = scan.nextLine();
    }

    @Override
    public String toString() {
        return "Personal{" +
                "legajo=" + legajo +
                ", salario=" + salario +
                ", horasTotalesMes=" + horasTotalesMes +
                '}';
    }
}

// TODO modificar el ToString()
