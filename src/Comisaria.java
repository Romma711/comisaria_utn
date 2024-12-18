import Almacen.*;
import Area.*;
import Entidades.*;
import Enums.*;
import Exceptions.NoEncontradoException;
import Exceptions.YaExisteException;
import utils.JSONUtils;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Comisaria {
    private static Departamento departamento;
    private static Almacen almacen;
    private static Calabozo calabozo;

    public Comisaria() {

    }

    public static void menuPrincipal() {
        //region Tomar valores de los JSON
        try {
            departamento = new Departamento();
            departamento = departamento.jsonToThisClass(JSONUtils.leerArchivo("departamento.json"));
        } catch (NullPointerException e) {
            System.out.println("No existe json con datos para departamentos.");
        }
        try {
            calabozo = new Calabozo();
            calabozo = calabozo.jsonToThisClass(JSONUtils.leerArchivo("calabozo.json"));
        } catch (NullPointerException e) {
            System.out.println("No existe json con datos para calabozo.");
        }
        try {
            almacen = new Almacen();
            almacen = almacen.jsonToThisClass(JSONUtils.leerArchivo("almacen.json"));
        } catch (NullPointerException e) {
            System.out.println("No existe json con datos para almacen.");
        }
        //endregion

        int selector = -1;
        Scanner lector = new Scanner(System.in);

        do {
            System.out.println("Ingrese el área desea acceder mediante su número (0 para salir):");
            System.out.println("1. Almacen.");
            System.out.println("2. Departamentos.");
            System.out.println("3. Calabozo.");
            System.out.println("0. Salir.");
            System.out.print("> ");
            try {
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
                    default:
                        if(selector == 0){
                            System.out.println("Vuelva prontos");
                        } else {
                            System.out.println("Ingrese un número válido.");
                        }
                        break;
                }
            } catch (InputMismatchException e) { //Ya lo declara el default del switch
                System.out.println("INGRESE UN DÍGITO VÁLIDO PARA EL AREA EN EL QUE DESEA INGRESAR...");
                lector.nextLine();
            }
        } while(selector !=0);
    }

    //region MANIPULACIÓN DE ALMACEN.
        private static void menuAlmacenes() {
            Scanner lector = new Scanner(System.in);
            int selector = -1;
            int idOperador = -1;
            String dni;
            System.out.println("Ingrese el DNI de quien va a operar almacen:");
            while (idOperador == -1){
                dni = lector.nextLine();
                idOperador = departamento.verificarSiExiste(dni);
            }


            do {
                System.out.println("Ingrese el número que corresponde a la acción a realizar:");
                System.out.println("1. Agregar al almacen.");
                System.out.println("2. Modificar registros.");
                System.out.println("3. Listar registros.");
                System.out.println("0. Volver.");
                System.out.print("> ");
                try {
                    selector = lector.nextInt();
                    switch (selector) {
                        case 1:
                            menuAgregarRegistros(idOperador);
                            break;
                        case 2:
                            try {
                                menuModificarRegistros(idOperador);
                            } catch (NullPointerException e) {
                                System.out.println("PARA MODIFICAR UN DATO PRIMERO DEBE EXISTIR...");
                            }
                            break;
                        case 3:
                            System.out.println(almacen.listar());
                            break;
                        default:
                            if (selector != 0) {
                                System.out.println("INGRESE UN NUMERO VALIDO PARA LA ACCIÓN QUE DESEA REALIZAR EN ALMACEN...");
                            }
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("INGRESE UN DÍGITO VÁLIDO...");
                    lector.nextLine();
                }
                System.out.println("Desea ingresar a otra area?...");
            } while (selector != 0);
            JSONUtils.guardarArchivo(almacen.classToJson(), "almacen.json");
        }

        private static void menuAgregarRegistros(Integer idOperador) {
            int selector;
            Scanner lector = new Scanner(System.in);
            do {
                System.out.println("Seleccione el tipo de registro que va a almacenar:");
                System.out.println("1.Material policial");
                System.out.println("2.Denuncia");
                System.out.println("3.Caso");
                System.out.println("4.Evidencia de un caso");
                System.out.println("0.Volver");
                System.out.print("> ");

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
                        System.out.println(almacen.listar(T_Registro.CASO));
                        System.out.println("Ingrese la ID del caso al cual desea agregar la evidencia:");
                        System.out.print("> ");
                        Registro caso = almacen.buscarPorID(lector.nextInt());
                        boolean flag = true;
                        do {
                            if (caso instanceof Caso) {
                                AgregarEvidencia((Caso) caso, idOperador);
                                flag = false;
                            } else {
                                System.out.println("El ID no pertenece a un CASO.");
                                System.out.print("Ingrese nuevamente el ID:\n> ");
                                caso = almacen.buscarPorID(lector.nextInt());
                            }
                        } while (flag);
                        break;
                    default:
                        if (selector != 0) {
                            System.out.println("INGRESE UN NUMERO VALIDO...");
                        }
                        break;
                }
                System.out.println("Desea ingresar otro dato?...");
            } while (selector != 0 );
        }

        //region SUBMENÚ AGREGAR REGISTROS.
            private static void AgregarMaterialPolicial(Integer idOperador) {
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingrese el tipo de material:");
                System.out.println("1. Arma");
                System.out.println("2. Esposas");
                System.out.print("> ");
                int select = lector.nextInt();
                lector.nextLine();
                Material_Policial materialPolicial = switch (select) {
                    case 1 -> new Material_Policial(null, T_Material.ARMA);
                    case 2 -> new Material_Policial(null, T_Material.ESPOSAS);
                    default -> null;
                };
                materialPolicial.setIdPropietario("Sin propietario");
                materialPolicial.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Primera inserción del material."));

                boolean flag = almacen.agregarAlAlmacen(T_Registro.MATERIAL_POLICIAL,materialPolicial);
                if (!flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LOS DATOS...");
                }
            }

            private static void AgregarDenuncia(Integer idOperador) {
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingrese el dni del denunciante:");
                System.out.println("> ");
                String idDenunciante = lector.nextLine();

                System.out.println("Ingrese el dni del denunciado:");
                System.out.print("> ");
                String idDenunciado = lector.nextLine();

                while (idDenunciado.equals(idDenunciante)) {
                    System.out.println("Ambos DNI son identicos...");
                    System.out.println("Ingrese el dni del denunciado nuevamente:");
                    System.out.print("> ");
                    idDenunciado = lector.nextLine();
                }

                System.out.println("Ingrese la declaracion:");
                System.out.print("> ");
                String declaracion = lector.nextLine();

                Denuncia denuncia = new Denuncia(idDenunciante,idDenunciado,declaracion);
                denuncia.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Primera inserción de la denuncia."));
                boolean flag = almacen.agregarAlAlmacen(T_Registro.DENUNCIAS,denuncia);
                if (!flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LOS DATOS...");
                }
            }

            private static void AgregarCaso(Integer idOperador) {
                Scanner lector = new Scanner(System.in);

                System.out.println("Ingresar el nombre del caso");
                System.out.print("> ");
                String nombre = lector.nextLine();

                System.out.println("Ingresar un comentario sobre el caso");
                System.out.print("> ");
                String comentario = lector.nextLine();

                Caso caso = new Caso(nombre,comentario);


                System.out.println("Desea ingresar alguna evidencia? (1 para \"SI\"  /  0 para\"NO\")");
                if (lector.nextInt() == 1) {
                    AgregarEvidencia(caso, idOperador);
                }
                caso.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Primera inserción del caso."));
                boolean flag = almacen.agregarAlAlmacen(T_Registro.CASO,caso);
                if (!flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LOS DATOS...");
                }
            }

            private static void AgregarEvidencia(Caso caso, Integer idOperador) {
            Scanner lector = new Scanner(System.in);

            System.out.println("Ingresar el codigo de paradero de la evidencia");
            System.out.print("> ");
            String codigo = lector.nextLine();

            System.out.println("Ingresar un comentario sobre la evidencia");
            System.out.print("> ");
            String comentario = lector.nextLine();

            System.out.println("Ingrese el tipo de material:");
            System.out.println("1. Arma");
            System.out.println("2. Muestra");
            System.out.println("3. Escritura");
            System.out.println("4. Análisis");
            int select = lector.nextInt();
            lector.nextLine();
            Evidencia evidencia = switch (select) {
                case 1 -> new Evidencia(T_Material.ARMA,codigo,comentario);
                case 2 -> new Evidencia(T_Material.MUESTRA,codigo,comentario);
                case 3 -> new Evidencia(T_Material.ESCRITURA,codigo,comentario);
                case 4 -> new Evidencia(T_Material.ANALISIS,codigo,comentario);
                default -> null;
            };
            caso.agregarMod(new Modificacion(idOperador,LocalDateTime.now().toString(),"Incorporación de evidencia."));
            boolean flag = caso.agregarEvidencia(evidencia);
            if (!flag) {
                System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR LA EVIDENCIA...");
            }
        }
        //endregion

        private static void menuModificarRegistros(Integer idOperador) throws NullPointerException{
            int selector;
            Scanner lector = new Scanner(System.in);

            do {
                System.out.println("Que desea modificar:");
                System.out.println("1. Material policial --- (Posesión)");
                System.out.println("2. Denuncia ------------ (Declaración)");
                System.out.println("0. Volver.");
                System.out.print("> ");
                selector = lector.nextInt();
                switch (selector) {
                    case 1:
                        System.out.println(almacen.listar(T_Registro.MATERIAL_POLICIAL));
                        modificarMaterialPolicial(idOperador);
                        break;
                    case 2:
                        System.out.println(almacen.listar(T_Registro.DENUNCIAS));
                        modificarDenuncia(idOperador);
                        break;
                    default:
                        if (selector != 0) {
                            System.out.println("INGRESE UN NUMERO VALIDO...");
                        }
                        break;
                }
                System.out.println("Desea modificar otro dato?...");
            } while (selector != 0);
        }

        //region SUBMENÚ MODIFICAR.
            private static void modificarMaterialPolicial(Integer idOperador) {
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingrese el ID del material policial a modificar:");
                System.out.print("> ");
                Registro materialPolicial = almacen.buscarPorID(lector.nextInt());
                if (materialPolicial instanceof Material_Policial) {
                    String dni;
                    System.out.println("Ingrese el DNI del nuevo propietario:");
                    System.out.print("> ");
                    lector.nextLine();
                    Integer idPropietario=-1;
                    while (idPropietario == -1){
                        dni = lector.nextLine();
                        idPropietario= departamento.verificarSiExiste(dni);
                    }
                    ((Material_Policial) materialPolicial).setIdPropietario(idOperador.toString());
                } else {
                    System.out.println("El ID no pertenece a un MATERIAL POLICIAL.");
                }
                System.out.println("Ingrese un comentario para la modificacion:");
                System.out.print("> ");
                boolean flag = materialPolicial.agregarMod(new Modificacion(idOperador, LocalDateTime.now().toString(), lector.nextLine()));
                if (!flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR EL COMENTARIO DE LA MODIFICACION...");
                }
            }

            private static void modificarDenuncia(Integer idOperador) {
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingrese el ID de la denuncia a modificar:");
                System.out.println("> ");

                Registro denuncia = almacen.buscarPorID(lector.nextInt());
                lector.nextLine();
                if (denuncia instanceof Denuncia) {
                    System.out.println("Ingrese la nueva declaración de la denuncia:");
                    System.out.print("> ");
                    ((Denuncia) denuncia).setDeclaracion(lector.nextLine());
                } else {
                    System.out.println("El ID no pertenece a una DENUNCIA.");
                }
                System.out.println("Ingrese un comentario para la modificacion:");
                System.out.print("> ");
                boolean flag = denuncia.agregarMod(new Modificacion(idOperador, LocalDateTime.now().toString(), lector.nextLine()));
                if (!flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR EL COMENTARIO DE LA MODIFICACION...");
                }
                System.out.println(denuncia.listaModificaciones());
            }
        //endregion

    //endregion

    //region MENUES DEPARTAMENTOS
        public static void menuDepartamentos() {
            try {
                departamento = departamento.jsonToThisClass(JSONUtils.leerArchivo("departamento.json"));
            }catch (NullPointerException e){
                e.getMessage();
            }
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
                        menuAgregarDepartamento();
                        break;
                    case 2:
                        menuBajaDepartamento();
                        break;
                    case 3:
                        menuModificarDepartamento();
                        break;
                    case 4:
                        departamento.listar(T_Depto.POLICIA);
                        departamento.listar(T_Depto.MANTENIMIENTO);
                        departamento.listar(T_Depto.LIMPIEZA);
                        departamento.listar(T_Depto.ADMINISTRACION);
                        break;
                    default:
                        break;
                }
            }while (selector != 0);
            JSONUtils.guardarArchivo(departamento.classToJson(),"departamento.json");
        }

        //MENU PARA AGREGAR PERSONAL
        public static void menuAgregarDepartamento(){
            int selector;
            Personal nuevo;
            do {
                System.out.println("Que elemento desea ingresar?");
                System.out.println("1.Personal");
                System.out.println("2.Miebro de la fuerza");
                System.out.println("0.Volver");
                Scanner lector = new Scanner(System.in);
                selector = lector.nextInt();
                try {
                    switch (selector) {
                        case 1:
                            nuevo = new Personal();
                            nuevo.crearPersonal();
                            System.out.println("Seleccionar departamento al que pertenecera\n 1.MANTENIMIENTO \n 2.LIMPIEZA \n 3. ADMINISTRACION");
                            switch (lector.nextInt()) {
                                case 1:
                                    departamento.agregarAlDepartamento(T_Depto.MANTENIMIENTO, nuevo);
                                    break;
                                case 2:
                                    departamento.agregarAlDepartamento(T_Depto.LIMPIEZA, nuevo);
                                    break;
                                case 3:
                                    departamento.agregarAlDepartamento(T_Depto.ADMINISTRACION, nuevo);
                                    break;
                            }
                            break;
                        case 2:
                            nuevo = new MiembroFuerza();
                            ((MiembroFuerza) nuevo).crearMiembro();
                            departamento.agregarAlDepartamento(T_Depto.POLICIA,nuevo);
                            break;
                        default:
                            break;
                    }
                }catch (YaExisteException e){
                    e.getMessage();
                    System.out.println("\nERROR: El personal ya existe en el sistema, NO se puede agregar nuevamente.\n");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }while (selector != 0);
        }

        ///MENU PARA DAR DE BAJA A UN PERSONAL
        public static void menuBajaDepartamento(){
            int selector;
            Integer aux;
            do {
                System.out.println("Seleccionar el Departamento:");
                System.out.println("1.Policia");
                System.out.println("2.Mantenimiento");
                System.out.println("3.Limpieza");
                System.out.println("4.Administracion");
                System.out.println("0.Volver");
                Scanner lector = new Scanner(System.in);
                selector = lector.nextInt();
                switch (selector) {
                    case 1:
                        try {
                            departamento.listar(T_Depto.POLICIA);
                            System.out.println("Ingrese el LEGAJO del policia");
                            aux = lector.nextInt();
                            departamento.eliminarDelDepartamento(T_Depto.POLICIA, aux);
                        } catch (NoEncontradoException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            departamento.listar(T_Depto.MANTENIMIENTO);
                            System.out.println("Ingrese el LEGAJO del personal de mantenimiento");
                            aux = lector.nextInt();
                            departamento.eliminarDelDepartamento(T_Depto.MANTENIMIENTO, aux);
                        } catch (NoEncontradoException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            departamento.listar(T_Depto.LIMPIEZA);
                            System.out.println("Ingrese el LEGAJO del personal de limpieza");
                            aux = lector.nextInt();
                            departamento.eliminarDelDepartamento(T_Depto.LIMPIEZA, aux);
                        } catch (NoEncontradoException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            departamento.listar(T_Depto.ADMINISTRACION);
                            System.out.println("Ingrese el LEGAJO del personal de administracion");
                            aux = lector.nextInt();
                            departamento.eliminarDelDepartamento(T_Depto.ADMINISTRACION, aux);
                        } catch (NoEncontradoException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }while (selector != 0);
        }

        ///MENU PARA MODIFICAR UN PERSONAL
        public static void menuModificarDepartamento(){
        int selector;
        Integer aux;
        do {
            System.out.println("Seleccionar el Departamento:");
            System.out.println("1.Policia");
            System.out.println("2.Mantenimiento");
            System.out.println("3.Limpieza");
            System.out.println("4.Administracion");
            System.out.println("0.Volver");
            Scanner lector = new Scanner(System.in);
            selector = lector.nextInt();
            switch (selector) {
                case 1:
                    try {
                        departamento.listar(T_Depto.POLICIA);
                        System.out.println("Ingrese el LEGAJO del policia\n");
                        aux = lector.nextInt();
                        departamento.modificarPersonal(T_Depto.POLICIA, aux);
                    } catch (NoEncontradoException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        departamento.listar(T_Depto.MANTENIMIENTO);
                        System.out.println("Ingrese el LEGAJO del personal de mantenimiento\n");
                        aux = lector.nextInt();
                        departamento.modificarPersonal(T_Depto.MANTENIMIENTO, aux);
                    } catch (NoEncontradoException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        departamento.listar(T_Depto.LIMPIEZA);
                        System.out.println("Ingrese el LEGAJO del personal de limpieza\n");
                        aux = lector.nextInt();
                        departamento.modificarPersonal(T_Depto.LIMPIEZA, aux);
                    } catch (NoEncontradoException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        departamento.listar(T_Depto.ADMINISTRACION);
                        System.out.println("Ingrese el LEGAJO del personal de administracion\n");
                        aux = lector.nextInt();
                        departamento.modificarPersonal(T_Depto.ADMINISTRACION, aux);
                    } catch (NoEncontradoException e) {
                        e.getMessage();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                default:
                    break;
            }
        }while (selector != 0);
    }
    //endregion

    public static void menuCalabozo() {
        try {
            calabozo = calabozo.jsonToThisClass(JSONUtils.leerArchivo("calabozo.json"));
        }catch (NullPointerException e) {
            e.getMessage();
        }
        int selector;
        Procesado nuevo = new Procesado();
        do {
            System.out.println("1.Agregar al calabozo");
            System.out.println("2.Sacar procesado");
            System.out.println("3.Cambiar estado del procesado");
            System.out.println("4.Listar procesados");
            System.out.println("0.Volver");
            Scanner lector = new Scanner(System.in);
            selector = lector.nextInt();
            switch (selector) {
                case 1:
                    nuevo.crearProcesado();
                    calabozo.agregar(nuevo);
                    break;
                case 2:
                    calabozo.listar();
                    System.out.println("Ingresa el id del procesado");
                    nuevo.setId(lector.nextInt());
                    calabozo.eliminar(nuevo);
                    break;
                case 3:
                    calabozo.listar();
                    System.out.println("Ingresa el id del procesado");
                    nuevo.setId(lector.nextInt());
                    calabozo.modificar(nuevo);
                    break;
                case 4:
                    calabozo.listar();
                    break;
                default:
                    break;
            }
        }while (selector != 0);
        JSONUtils.guardarArchivo(calabozo.classToJson(),"calabozo.json");
    }
}

