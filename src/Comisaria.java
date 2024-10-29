import Almacen.Almacen;
import Area.Calabozo;
import Area.Departamento;
import Enums.T_Depto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Comisaria {
    private final HashMap<T_Depto, ArrayList<Departamento>>menuDeptos;
    private Almacen almacen;
    private Calabozo calabozo;

    public Comisaria(){
        menuDeptos= new HashMap<>();
    }

    public void crearDepto(T_Depto tipo){
        ArrayList<Departamento>depto = new ArrayList<>();
        menuDeptos.put(tipo,depto);
    }
    public void sacarDepto(T_Depto tipo){
        ArrayList<Departamento>depto = new ArrayList<>();
        menuDeptos.remove(tipo,depto);
    }

    public void menuAlmacenes() {
        int selector;
        do {
            System.out.println("1.Agregar al almacen");
            System.out.println("2.Modificar registros");
            System.out.println("3.Listar registros");
            System.out.println("0.Volver");

            Scanner lector = new Scanner(System.in);
            selector = lector.nextInt();
            switch (selector) {
                case 1:
                    //TODO almacen.agregarAlAlmacen();
                    break;
                case 2:
                    //TODO almacen.modificarRegistro();
                    break;
                case 3:
                    almacen.lista();
                    break;
                default:
                    break;
            }
        }while (selector != 0);
    }

    public void menuDepartamentos() {
        int selector;
        do {
            System.out.println("1.Agregar al departamento");
            System.out.println("2.Dar de baja");
            System.out.println("3.Modificar personal");
            System.out.println("4.Listar personal");
            System.out.println("0.Volver");

            Scanner lector = new Scanner(System.in);
            selector = lector.nextInt();
            switch (selector) {
                case 1:
                    System.out.println("Digame el Departamento que quiere Crear 1.INVESTIGACION 2.NARCOTICOS 3.COMUNICACIONES 4.TRANSITO \n" +
                    " 5.SEGURIDAD 6.CIENTIFICA 7.FORMACION 8.LIMPIEZA 9.SECRETARIA 10.ADMINISTRACION 11.RECURSOS_HUMANOS");
                    //TODO menuDepto.get(T_Depto).agregar() con todas las funciones de crear y validaciones
                    break;
                case 2:
                    System.out.println("Digame el Departamento que quiere Crear 1.INVESTIGACION 2.NARCOTICOS 3.COMUNICACIONES 4.TRANSITO \n" +
                    " 5.SEGURIDAD 6.CIENTIFICA 7.FORMACION 8.LIMPIEZA 9.SECRETARIA 10.ADMINISTRACION 11.RECURSOS_HUMANOS");

                    //TODO menuDepto.get(T_Depto).darDeBaja() con todas las funciones de crear y validaciones
                    break;
                case 3:
                    System.out.println("Digame el Departamento que quiere ver 1.INVESTIGACION 2.NARCOTICOS 3.COMUNICACIONES 4.TRANSITO \n" +
                    " 5.SEGURIDAD 6.CIENTIFICA 7.FORMACION 8.LIMPIEZA 9.SECRETARIA 10.ADMINISTRACION 11.RECURSOS_HUMANOS");

                    //TODO menuDepto.get(T_depto).modificar() Con validaciones
                    break;
                case 4:

                    //TODO menuDeptos.get(T_Depto).listar();
                    break;
                default:
                    break;
            }
        }while (selector != 0);
    }
    public void menuCalabozo() {
        int selector;
        do {
            System.out.println("1.Agregar al departamento");
            System.out.println("2.Migrar Procesados");
            System.out.println("3.Modificar procesados");
            System.out.println("4.Listar procesados");
            System.out.println("0.Volver");

            Scanner lector = new Scanner(System.in);
            selector = lector.nextInt();
            switch (selector) {
                case 1:
                    //TODO calabozo.agregar() con todas las funciones de crear y validaciones
                    break;
                case 2:
                    //TODO calabozo.migrar()
                    break;
                case 3:
                    //TODO calabozo.modificar() Con validaciones
                    break;
                case 4:
                    //TODO calabozo.listar();
                    break;
                default:
                    break;
            }
        }while (selector != 0);
    }

    public void menuVisita() {
        int selector;
        do {
            System.out.println("1.Agregar una visita");
            System.out.println("2.Cancelar visita");
            System.out.println("3.Modificar visita");
            System.out.println("4.Listar visitas");
            System.out.println("0.Volver");

            Scanner lector = new Scanner(System.in);
            selector = lector.nextInt();
            switch (selector) {
                case 1:
                    //TODO crear la funcion de agregas visita
                    break;
                case 2:
                    //TODO crear la funcion de cancelar una visita
                    break;
                case 3:
                    //TODO crear la funcion que modificique una visita
                    break;
                case 4:
                    //TODO crear la funcion que liste las visitas
                    break;
                default:
                    break;
            }
        }while (selector != 0);
    }


}

