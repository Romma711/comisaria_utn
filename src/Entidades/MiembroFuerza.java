package Entidades;

import Area.Departamento;
import Enums.T_Rango;
import org.json.JSONObject;
import utils.Verificador;

import java.util.Scanner;

public class MiembroFuerza extends Personal  {
    public T_Rango rango;
    public Integer condecoraciones;


    public MiembroFuerza(String dni, String nombre, String apellido,
                         String direccion, String telefono,
                         Integer edad, Character genero,
                         Double salario,
                         Integer horasTotalesMes, T_Rango rango,
                         Integer condecoraciones) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero, salario, horasTotalesMes);
        this.rango = rango;
        this.condecoraciones = condecoraciones;
    }

    public MiembroFuerza() {
        super();
    }

    //region GETTERS & SETTERS
    public T_Rango getRango() {
        return rango;
    }
    public void setRango(T_Rango rango) {
        this.rango = rango;
    }
    public Integer getCondecoraciones() {
        return condecoraciones;
    }
    public void setCondecoraciones(Integer condecoraciones) {
        this.condecoraciones = condecoraciones;
    }
    //endregion

    public void crearMiembro(){
        super.crearPersonal();
        System.out.println("Ingrese el rango \n 1.OFICIAL \n 2.SARGENTO \n 3.TENIENTE \n 4.CAPITAN");
        this.rango = Departamento.rango(Verificador.verificarInt());
        System.out.println("Ingrese las condecoraciones");
        this.condecoraciones = Verificador.verificarInt();
    }

    @Override
    public JSONObject classToJson() {
        JSONObject jsonObject = super.classToJson();
        jsonObject.put("rango",getRango());
        jsonObject.put("condecoraciones",getCondecoraciones());
        return jsonObject;
    }

    @Override
    public MiembroFuerza jsonToThisClass(JSONObject json) {
        MiembroFuerza recuperado = new MiembroFuerza();
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
        recuperado.setRango(json.getEnum(T_Rango.class,"rango"));
        recuperado.setCondecoraciones(json.getInt("condecoraciones"));
        return recuperado;
    }

    @Override
    public String toString() {
        return "---------------------------------------------------------------------------\n"+
                "MiembroFuerza:\n" +
                        "\nLegajo= " + getLegajo() +
                        "\nNombre= "+ getNombre()+
                        "\nApellido= "+ getApellido()+
                        "\nDNI= "+ getDni()+
                        "\nTelefono= "+ getTelefono()+
                        "\nDireccion= "+ getDireccion()+
                        "\nEdad= "+ getEdad()+
                        "\nGenero= "+ getGenero()+
                        "\nHoras del mes= " + getHorasTotalesMes() +
                        "\nSalario= " + getSalario() +
                        "\nTarea= '" + getTarea() + '\'' +
                "\nRango="+getRango().toString()+
                "\nCondecoraciones=" + condecoraciones +
                "\n---------------------------------------------------------------------------\n";
    }
}

// TODO modificar el ToString()
