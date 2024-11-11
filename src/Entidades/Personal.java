package Entidades;

import Interfaces.IJson;
import org.json.JSONObject;

import java.util.UUID;

public class Personal extends Persona  implements IJson <Personal>{
    private Integer legajo;
    private Integer horasDiarias;
    private Double salario, horasTotalesMes;
    private String tarea;
    private boolean activo;
    private static Integer cont=99999;

    public Personal(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero, Integer horasDiarias, Double salario, Double horasTotalesMes) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero);
        cont++;
        legajo = cont;
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

    ///Esta funcion convierte el objeto en json
    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("nombre",super.getNombre());
        json.put("apellido",super.getApellido());
        json.put("direccion",super.getDireccion());
        json.put("telefono",super.getTelefono());
        json.put("dni",super.getDni());
        json.put("edad",super.getEdad());
        json.put("genero",super.getGenero());
        json.put("legajo",legajo);
        json.put("horas_diarias",horasDiarias);
        json.put("salario",salario);
        json.put("horas_mes",horasTotalesMes);
        json.put("tarea",tarea);
        return json;
    }

    @Override
    public Personal jsonToThisClass(JSONObject json) {
        return null;
    }
}

// TODO modificar el ToString()
