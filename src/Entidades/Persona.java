package Entidades;

import java.util.Scanner;

public abstract class Persona{
    private String dni, nombre, apellido, direccion, telefono;
    private Integer edad;
    private Character genero;

    public Persona(String dni, String nombre, String apellido, String direccion, String telefono, Integer edad, Character genero) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.genero = genero;
    }
    public Persona() {
    }

    ///region GETTERS & SETTERS
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Character getGenero() {
        return genero;
    }
    public void setGenero(Character genero) {
        this.genero = genero;
    }

    ///endregion



    public void crearPersona(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar nombre:");
        this.nombre = scan.nextLine();
        System.out.println("Ingresar apellido:");
        this.apellido = scan.nextLine();
        System.out.println("Ingresar DNI:");
        this.dni = scan.nextLine();
        System.out.println("Ingresar telefono:");
        this.telefono = scan.nextLine();
        System.out.println("Ingresar direccion:");
        this.direccion = scan.nextLine();
        System.out.println("Ingresar edad:");
        this.edad = scan.nextInt();
        System.out.println("Ingresar genero (M / F):");
        scan.nextLine();
        this.genero = scan.nextLine().charAt(0);
    }
    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                '}';
    }
}
