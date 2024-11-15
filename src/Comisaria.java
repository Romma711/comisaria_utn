import Almacen.*;
import Area.*;
import Entidades.Personal;
import Enums.T_Material;
import Enums.T_Registro;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Comisaria {
    private static Departamento departamento;
    private static Almacen almacen;
    private Calabozo calabozo;

    public Comisaria() {
    }

    public static void menuPrincipal() {

        //JSONUtils.leerArchivo("Departamento.json");
        //JSONUtils.leerArchivo("Almacen.json");
        //JSONUtils.leerArchivo("Calabozo.json");
        //JSONUtils.leerArchivo("Visitas.json");
        //JSONUtils.leerArchivo("Perrera.json");
        //JSONUtils.leerArchivo("Contadores.json");

        int selector;
        Scanner lector = new Scanner(System.in);
        do {
            System.out.println("Ingrese el área desea acceder mediante su número (0 para salir):");
            System.out.println("1. Almacen.");
            System.out.println("2. Departamentos.");
            System.out.println("3. Calabozo.");
            System.out.println("4. Visitas.");
            System.out.println("0. Salir.");
            System.out.print("> ");
            selector = lector.nextInt();
            switch (selector) {
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
                    System.out.println("Ingrese un número valido.");
                    break;
            }

        } while(selector !=0);
    }

    ///region MANIPULACIÓN DE ALMACEN.
        private static void menuAlmacenes() {
            int selector;
            Scanner lector = new Scanner(System.in);
            almacen = new Almacen();

            System.out.println("Ingrese el ID de quien va a operar almacen:");
            Integer idOperador = lector.nextInt();

            do {
                System.out.println("Ingrese el número que corresponde a la acción a realizar (0 para volver):");
                System.out.println("1. Agregar al almacen.");
                System.out.println("2. Modificar registros.");
                System.out.println("3. Listar registros.");
                System.out.println("0. Volver.");
                System.out.println("> ");

                selector = lector.nextInt();
                switch (selector) {
                    case 1:
                        menuAgregarRegistros(idOperador);
                        break;
                    case 2:
                        System.out.println(almacen.lista());
                        menuModificarRegistros(idOperador);
                        break;
                    case 3:
                        System.out.println(almacen.lista());
                        break;
                    default:
                        System.out.println("INGRESE UN NUMERO VALIDO...");
                        break;
                }
            }while (selector != 0);
        }

        private static void menuAgregarRegistros(Integer idOperador){
            int selector;
            Scanner lector = new Scanner(System.in);
            do {
                System.out.println("Seleccione el tipo de registro que va a almacenar:");
                System.out.println("1.Material policial");
                System.out.println("2.Denuncia");
                System.out.println("3.Caso");
                System.out.println("4.Evidencia de un caso");
                System.out.println("0.Volver");
                System.out.println("> ");

                selector = lector.nextInt();
                switch (selector){
                    case 1:
                        AgregarMaterialPolicial(idOperador);
                        break;
                    case 2:
                        AgregarDenuncia(idOperador);
                        break;
                    case 3:
                        AgregarCaso(idOperador);
                        break;
                    case 4:
                        System.out.println("Ingrese la ID del caso al cual desea agregar la evidencia:");
                        System.out.println("> ");
                        Registro caso = almacen.buscarPorID(lector.nextInt());
                        if (caso instanceof Caso) {
                            AgregarEvidencia((Caso) caso, idOperador);
                        } else {
                            System.out.println("El ID no pertenece a un CASO.");
                        }
                        break;
                    default:
                        System.out.println("INGRESE UN NUMERO VALIDO...");
                        break;
                }
            } while (selector != 0 );
        }

        ///region SUBMENÚ AGREGAR REGISTROS.
            private static void AgregarMaterialPolicial(Integer idOperador) {
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingrese el tipo de material:");
                System.out.println("1. Arma");
                System.out.println("2. Esposas");
                int select = lector.nextInt();
                lector.nextLine();
                Material_Policial materialPolicial = switch (select) {
                    case 1 -> new Material_Policial(null, T_Material.ARMA);
                    case 2 -> new Material_Policial(null, T_Material.ESPOSAS);
                    default -> null;
                };
                System.out.println("Inserte el ID del propietario (en caso de no tener insertar \"null\"");
                String idPropietario = lector.nextLine();
                if (materialPolicial != null) {
                    if (idPropietario.equalsIgnoreCase("null")) {
                        materialPolicial.setIdPropietario(null);
                    } else {
                        materialPolicial.setIdPropietario(idPropietario);
                    }
                    materialPolicial.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Primera inserción del material."));
                }
                boolean flag = almacen.agregarAlAlmacen(T_Registro.MATERIAL_POLICIAL,materialPolicial);
                if (flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LOS DATOS...");
                }
            }

            private static void AgregarDenuncia(Integer idOperador) {
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingrese el dni del denunciante:");
                System.out.println("> ");
                String idDenunciante = lector.nextLine();

                System.out.println("Ingrese el dni del denunciado:");
                System.out.println("> ");
                String idDenunciado = lector.nextLine();

                while (idDenunciado.equals(idDenunciante)) {
                    System.out.println("Ambos DNI son identicos...");
                    System.out.println("Ingrese el dni del denunciado nuevamente:");
                    System.out.println("> ");
                    idDenunciado = lector.nextLine();
                }

                System.out.println("Ingrese la declaracion:");
                System.out.println("> ");
                String declaracion = lector.nextLine();

                Denuncia denuncia = new Denuncia(idDenunciante,idDenunciado,declaracion);
                denuncia.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Primera inserción de la denuncia."));
                boolean flag = almacen.agregarAlAlmacen(T_Registro.DENUNCIAS,denuncia);
                if (flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LOS DATOS...");
                }
            }

            private static void AgregarCaso(Integer idOperador) {
                Scanner lector = new Scanner(System.in);

                System.out.println("Ingresar el nombre del caso");
                System.out.println("> ");
                String nombre = lector.nextLine();

                System.out.println("Ingresar un comentario sobre el caso");
                System.out.println("> ");
                String comentario = lector.nextLine();

                Caso caso = new Caso(nombre,comentario);


                System.out.println("Desea ingresar alguna evidencia? (1 para \"SI\"  /  0 para\"NO\")");
                if (lector.nextInt() == 1) {
                    AgregarEvidencia(caso, idOperador);
                }
                caso.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Primera inserción del caso."));
                boolean flag = almacen.agregarAlAlmacen(T_Registro.CASO,caso);
                if (flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LOS DATOS...");
                }
            }

            private static void AgregarEvidencia(Caso caso, Integer idOperador) {
            Scanner lector = new Scanner(System.in);

            System.out.println("Ingresar un nombre para el caso");
            System.out.println("> ");
            String nombre = lector.nextLine();

            System.out.println("Ingresar un comentario sobre el caso");
            System.out.println("> ");
            String comentario = lector.nextLine();

            System.out.println("Ingrese el tipo de material:");
            System.out.println("1. Arma");
            System.out.println("2. Muestra");
            System.out.println("3. Escritura");
            System.out.println("4. Análisis");
            int select = lector.nextInt();
            lector.nextLine();
            Evidencia evidencia = switch (select) {
                case 1 -> new Evidencia(T_Material.ARMA,nombre,comentario);
                case 2 -> new Evidencia(T_Material.MUESTRA,nombre,comentario);
                case 3 -> new Evidencia(T_Material.ESCRITURA,nombre,comentario);
                case 4 -> new Evidencia(T_Material.ANALISIS,nombre,comentario);
                default -> null;
            };
            caso.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Incorporación de evidencia."));
            boolean flag = caso.agregarEvidencia(evidencia);
            if (flag) {
                System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LA EVIDENCIA...");
            }
        }
        ///endregion

        private static void menuModificarRegistros(Integer idOperador){
            int selector;
            Scanner lector = new Scanner(System.in);
            System.out.println("Que desea modificar:");
            System.out.println("1. Material policial --- (Posesión)");
            System.out.println("2. Denuncia ------------ (Declaración)");
            System.out.println("0. Volver.");
            do {
                selector = lector.nextInt();
                switch (selector){
                    case 1:
                        modificarMaterialPolicial();
                        break;
                    case 2:
                        modificarDenuncia();
                        break;
                    default:
                        System.out.println("INGRESE UN NUMERO VALIDO...");
                        break;
                }
            } while (selector != 0 );
        }

        ///region SUBMENÚ MODIFICAR.
            private static void modificarMaterialPolicial() {
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingrese el ID del material policial a modificar:");
                System.out.println("> ");

                Registro materialPolicial = almacen.buscarPorID(lector.nextInt());
                lector.nextLine();
                if (materialPolicial instanceof Material_Policial) {
                    System.out.println("Ingrese el ID del nuevo propietario:");
                    System.out.println("> ");
                    ((Material_Policial) materialPolicial).setIdPropietario(lector.nextLine());
                } else {
                    System.out.println("El ID no pertenece a un MATERIAL POLICIAL.");
                }
            }

            private static void modificarDenuncia() {
            Scanner lector = new Scanner(System.in);
            System.out.println("Ingrese el ID de la denuncia a modificar:");
            System.out.println("> ");

            Registro denuncia = almacen.buscarPorID(lector.nextInt());
            lector.nextLine();
            if (denuncia instanceof Denuncia) {
                System.out.println("Ingrese la nueva declaración de la denuncia:");
                System.out.println("> ");
                ((Denuncia) denuncia).setDeclaracion(lector.nextLine());
            } else {
                System.out.println("El ID no pertenece a una DENUNCIA.");
            }
        }
        ///endregion

    ///endregion

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

