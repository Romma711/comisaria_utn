import Almacen.*;
import Area.*;
import Entidades.Personal;
import Enums.T_Depto;
import Enums.T_Material;
import Enums.T_Registro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Comisaria {
    private Departamento departamento;
    private Almacen almacen;
    private Calabozo calabozo;


    public void menuPrincipal(){
        int selector;
        Scanner lector = new Scanner(System.in);
        do{
            System.out.println("1.Almacen");
            System.out.println("2.Departamentos");
            System.out.println("3.Calabozo");
            System.out.println("4.Visitas");
            System.out.println("0.Salir");
            selector = lector.nextInt();
            switch (selector){
                case 1:
                    menuAlmacenes();
                    break;
                case 2:
                    menuDepartamentos();
                    break;
                case 3:
                    menuCalabozo();
                    break;
                case 4:
                    menuVisita();
                    break;
                default:
                    break;
            }
        }while(selector !=0);
    }
    public void menuAlmacenes() {
        int selector;
        Scanner lector = new Scanner(System.in);
        departamento = new Departamento<>();
        //TODO relacionar con los archivos de json
        do {
            System.out.println("1.Agregar al almacen");
            System.out.println("2.Modificar registros");
            System.out.println("3.Listar registros");
            System.out.println("0.Volver");

            selector = lector.nextInt();
            switch (selector) {
                case 1:
                    menuAgregarRegistros();
                    break;
                case 2:

                    break;
                case 3:
                    almacen.lista();
                    break;
                default:
                    break;
            }
        }while (selector != 0);
    }

    public void menuAgregarRegistros(){
        int selector;
        Scanner lector = new Scanner(System.in);
        System.out.println("Seleccione el tipo de registro que va a almacenar");
        System.out.println("1.Material policial");
        System.out.println("2.Denuncia");
        System.out.println("3.Caso");
        System.out.println("4.Evidencia");
        System.out.println("0.Volver");
        do{
            selector = lector.nextInt();
            switch (selector){
                case 1:
                    System.out.println("Ingrese el id del miembro de la fuerza que la posee:");
                    Material_Policial nuevo = new Material_Policial(lector.nextLine(), T_Material.ARMA);
                    almacen.agregarAlAlmacen(T_Registro.MATERIAL_POLICIAL,nuevo);
                    break;
                case 2:
                    Denuncia nuevaD = new Denuncia();
                    System.out.println("Ingrese el dni del denunciante:");
                    nuevaD.setDniDenunciante(lector.nextLine());
                    System.out.println("Ingrese el dni del denunciado:");
                    nuevaD.setDniDenunciado(lector.nextLine());
                    System.out.println("Ingrese la declaracion:");
                    nuevaD.setDeclaracion(lector.nextLine());
                    almacen.agregarAlAlmacen(T_Registro.DENUNCIAS,nuevaD);
                    break;
                case 3:
                    Caso nuevoC = new Caso();
                    System.out.println("Ingresar el nombre del caso");
                    nuevoC.setNombre(lector.nextLine());
                    System.out.println("Ingresar un comentario sobre el caso");
                    nuevoC.setComentario(lector.nextLine());
                    almacen.agregarAlAlmacen(T_Registro.CASO,nuevoC);
                    break;
                case 4:
                    //todo hacer crear evidencias
                    break;
            }
        }while (selector != 0 );
    }

    public void menuModificarRegistros(){
        int selector;
        Scanner lector = new Scanner(System.in);
        System.out.println("Que desea modificar");
        System.out.println("1.Material policial (modificar la posesion del material)");
        System.out.println("2.Denuncia (modificar la declaracion)");
        System.out.println("0.Volver");
        do{
            selector = lector.nextInt();
            switch (selector){
                case 1:
                    
                    break;
                case 2:

                    break;
                default:
                    break;
            }
        }while (selector != 0 );
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
                    Personal nuevo;
                    System.out.println("Digame el Departamento que quiere Crear 1.POLICIA\n 2.MANTENIMIENTO\n 3.LIMPIEZA\n 4.ADMINISTRACION");
                    //TODO menuDepto.get(T_Depto).agregar() con todas las funciones de crear y validaciones
                    switch (lector.nextInt()){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
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
            System.out.println("1.Agregar al calabozo");
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

