package Entidades;

import Enums.T_Estado;
import java.time.LocalDate;
import java.util.Scanner;

public class Procesado extends Ingresante {
    private LocalDate fechaEgreso;
    private T_Estado estado;

    public Procesado(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero,String razon, String nroCasillero,LocalDate fechaEgreso, T_Estado estado) {
        super(dni, nombre, apellido, direccion, telefono, edad, genero,razon, nroCasillero);

        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
    }
    public Procesado() {
    }

    //region GETTERS & SETTERS
    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }
    public void setFechaEgreso(LocalDate fechaEgreso) {
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
        return super.toString() +
                ", Procesado{" +
                ", fechaEgreso=" + fechaEgreso +
                ", estado=" + estado +
                '}';
    }
}

// TODO modificar el ToString()
