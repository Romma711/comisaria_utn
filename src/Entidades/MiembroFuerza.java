package Entidades;

import Area.Departamento;
import Enums.T_Rango;
import org.json.JSONObject;

import java.util.Scanner;
import java.util.UUID;

public class MiembroFuerza  extends Personal{
    public T_Rango rango;
    public Integer condecoraciones;


    public MiembroFuerza(String dni, String nombre, String apellido,
                         String direccion, String telefono,
                         Integer edad, Character genero,
                         Double salario,
                         Double horasTotalesMes, T_Rango rango,
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el rango 1.OFICIAL \n 2.SARGENTO \n 3.TENIENTE \n 4.CAPITAN");
        this.rango = Departamento.rango(scan.nextInt());
        System.out.println("Ingrese las condecoraciones");
        this.condecoraciones = scan.nextInt();
    }


    @Override
    public String toString() {
        return "MiembroFuerza{" +
                "legajo=" + super.getLegajo() +
                ", rango=" + rango +
                ", salario=" + super.getSalario() +
                ", horasTotalesMes=" + super.getHorasTotalesMes() +
                ", condecoraciones=" + condecoraciones +
                '}';
    }
}

// TODO modificar el ToString()
