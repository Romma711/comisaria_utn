package Entidades;

import Interfaces.IJson;
import org.json.JSONObject;
import utils.Verificador;

import java.util.Objects;
import java.util.Scanner;

public class Personal extends Persona implements IJson<Personal>{
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
    public static Integer getCont() {
        return cont;
    }
    public static void setCont(Integer cont) {
        Personal.cont = cont;
    }
    //endregion


    @Override
    public Personal jsonToThisClass(JSONObject json) {
        Personal recuperado = new Personal();
        recuperado.setNombre(json.getString("nombre"));
        recuperado.setApellido(json.getString("apellido"));
        recuperado.setDni(json.getString("dni"));
        recuperado.setTelefono(json.getString("telefono"));
        recuperado.setDireccion(json.getString("direccion"));
        recuperado.setEdad(json.getInt("edad"));
        recuperado.setGenero(json.getString("genero").charAt(0));
        recuperado.setLegajo(json.getInt("legajo"));
        recuperado.setSalario(json.getDouble("salario"));
        recuperado.setHorasTotalesMes(json.getInt("horas_mes"));
        recuperado.setTarea(json.getString("tarea"));
        recuperado.setActivo(json.getBoolean("activo"));
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
        jsonObject.put("legajo",getLegajo());
        jsonObject.put("salario",getSalario());
        jsonObject.put("horas_mes",getHorasTotalesMes());
        jsonObject.put("tarea",getTarea());
        jsonObject.put("activo",isActivo());
        return jsonObject;
    }

    public void crearPersonal(){
        super.crearPersona();
        Double aux=0.0;
        System.out.println("Ingresar horas por mes(Numero entero):");
        this.horasTotalesMes = Verificador.verificarInt();
        System.out.println("Ingresar salario(numero decimal separado por coma ej: 203,4):");
        while (aux==0.0){ aux=Verificador.verificarDouble(); }
        this.salario = aux;
        System.out.println("Ingresar la tarea a ejercer:");
        this.tarea = Verificador.verificarString();
    }

    @Override
    public String toString() {
        return "\n---------------------------------------------------------------------------\n"+
                "Personal:\n" +
                "\nLegajo=" + legajo +
                "\nNombre="+ getNombre()+
                "\nApellido="+ getApellido()+
                "\nDNI="+ getDni()+
                "\nTelefono="+ getTelefono()+
                "\nDireccion="+ getDireccion()+
                "\nEdad="+ getEdad()+
                "\nGenero="+ getGenero()+
                "\nHoras del mes=" + horasTotalesMes +
                "\nSalario=" + salario +
                "\nTarea='" + tarea + '\'' +
                "\n---------------------------------------------------------------------------\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personal personal)) return false;
        return Objects.equals(legajo, personal.legajo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(legajo);
    }
}

// TODO modificar el ToString()
