package Area;

import Entidades.MiembroFuerza;
import Entidades.Personal;
import Enums.T_Depto;
import Entidades.Persona;
import Enums.T_Rango;
import Interfaces.ABML;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Departamento <T extends Personal> implements ABML<T> {
    private ArrayList<T> listaEmpleados;
    private T_Depto depto;
    private String tareas;

    /// region ABML
    @Override
    public boolean agregar(T dato) {

        return listaEmpleados.add(dato);
    }

    @Override
    public boolean eliminar(T dato) {
        return listaEmpleados.remove(dato);
    }


    @Override
    public void modificar(T dato) {
        boolean found = false;
        int i = 0;
        while (i < listaEmpleados.size() && !found) {
            if (Objects.equals(dato.getDni(), listaEmpleados.get(i).getDni())) {
                found = true;
                moficarPersonal(i);
            }
            i++;
        }
        if (!found) {
            System.out.println("Empleado no encontrado.");
        }
    }

    @Override
    public void listar() {
        System.out.println("\n Nombre del departamento  " + depto + "\n");
        for (Persona person : listaEmpleados) {
            System.out.println(listaEmpleados.toString());
        }
    }

    /// endregion


/////////////*************************se puede mejorar**********************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public void moficarPersonal(int lugar){
        int selector;
        Scanner scan = new Scanner(System.in);
        if (lugar != -1) {
            System.out.println(listaEmpleados.get(lugar).toString());
            System.out.println("¿Qué quieres modificar? \n");
            if(listaEmpleados.get(lugar) instanceof MiembroFuerza){
                do {
                    System.out.println("1.Telefono 2.DNI 3.Edad 4.Género 5.Salario 6.SerialArma 7.Condecoraciones 8.Rango\n");
                    selector = scan.nextInt();
                } while (selector < 1 || selector > 8);
            }else {
                do {
                    System.out.println("1.Telefono 2.DNI 3.Edad 4.Género 5.Salario\n");
                    selector = scan.nextInt();
                } while (selector < 1 || selector > 5);
            }
            switch (selector){
                case 1:
                    System.out.println("Insertar el nuevo Teléfono\n");
                    listaEmpleados.get(lugar).setTelefono(scan.next());
                    break;
                case 2:
                    System.out.println("Insertar el nuevo DNI\n");
                    listaEmpleados.get(lugar).setDni(scan.next());
                    break;
                case 3:
                    System.out.println("Insertar la nueva Edad\n");
                    listaEmpleados.get(lugar).setEdad(scan.nextInt());
                    break;
                case 4:
                    int e = 0;
                    do {
                        System.out.println("Insertar el nuevo Género 1.M 2.F\n");
                        e = scan.nextInt();
                    } while (e < 1 || e > 2);
                    listaEmpleados.get(lugar).setGenero(Genero(e));
                    break;
                case 5:
                    System.out.println("Insertar el nuevo Salario \n");
                    ((Personal)listaEmpleados.get(lugar)).setSalario(scan.nextDouble());
                    break;
                default:
                    if(listaEmpleados.get(lugar) instanceof MiembroFuerza){
                        modificarPoli((MiembroFuerza)listaEmpleados.get(lugar),selector);
                    }
                    break;
            }
        }
        System.out.println(listaEmpleados.get(lugar).toString());
    }

    public void modificarPoli(MiembroFuerza miembroFuerza, int i) {
        Scanner scan = new Scanner(System.in);
        switch (i) {
            case 6:
                System.out.println("Insertar el nuevo SerialArma \n");
                miembroFuerza.setSerialArma(scan.next());
                break;
            case 7:
                System.out.println("Insertar el nuevo número de Condecoraciones \n");
                miembroFuerza.setCondecoraciones(scan.nextInt());
                break;
            case 8:
                System.out.println("Seleccione el rango 1.SUPERINTENDENTE 2.SARGENTO 3.SUBTENIENTE 4.TENIENTE 5.TENIENTE_PRIMERO" +
                        " 6.CAPITAN 7.INSPECTOR 8.COMISIONADO 9.OFICIAL");
                miembroFuerza.setRango(rango(scan.nextInt()));
                break;
        }
    }

    public Character Genero(int i) {
        if (i == 1) return 'm';
        else return 'f';
    }

    public T_Rango rango(int i) {
        return switch (i) {
            case 1 -> T_Rango.SUPERINTENDENTE;
            case 2 -> T_Rango.SARGENTO;
            case 3 -> T_Rango.SUBTENIENTE;
            case 4 -> T_Rango.TENIENTE;
            case 5 -> T_Rango.TENIENTE_PRIMERO;
            case 6 -> T_Rango.CAPITAN;
            case 7 -> T_Rango.INSPECTOR;
            case 8 -> T_Rango.COMISIONADO;
            default -> T_Rango.OFICIAL;
        };
    }

    public int buscarPorDNI(String DNI) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (Objects.equals(DNI, listaEmpleados.get(i).getDni())) {
                return i;
            }
        }
        return -1;
    }
}

// TODO modificar, listar del ABML
