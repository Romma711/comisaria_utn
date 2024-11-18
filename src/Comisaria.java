import Almacen.*;
import Area.*;
import Entidades.*;
import Enums.*;
import Exceptions.NoEncontradoException;
import Exceptions.YaExisteException;
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
        departamento = new Departamento();
        calabozo = new Calabozo();
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
                        if(selector==0){
                            System.out.println("Vuelva prontos");
                        }
                            System.out.println("No ingrese espacios.");
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
            try {
                almacen = new Almacen();
                almacen = almacen.jsonToThisClass(JSONUtils.leerArchivo("Almacen.json"));

                int selector = -1;
                System.out.println("Ingrese el ID de quien va a operar almacen:");
                Integer idOperador = lector.nextInt();

                do {
                    System.out.println("Ingrese el número que corresponde a la acción a realizar (0 para volver):");
                    System.out.println("1. Agregar al almacen.");
                    System.out.println("2. Modificar registros.");
                    System.out.println("3. Listar registros.");
                    System.out.println("0. Volver.");
                    System.out.println("> ");
                    try {
                        selector = lector.nextInt();
                        switch (selector) {
                            case 1:
                                menuAgregarRegistros(idOperador);
                                break;
                            case 2:
                                System.out.println(almacen.listar());
                                menuModificarRegistros(idOperador);
                                break;
                            case 3:
                                System.out.println(almacen.listar());
                                break;
                            default:
                                System.out.println("INGRESE UN NUMERO VALIDO PARA LA ACCIÓN QUE DESEA REALIZAR EN ALMACEN...");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("INGRESE UN DÍGITO VÁLIDO...");
                        lector.nextLine();
                    }

                } while (selector != 0);
                JSONUtils.guardarArchivo(almacen.classToJson(), "almacen.json");

            } catch (NullPointerException e) {
                e.getMessage();
            }
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

        //region SUBMENÚ AGREGAR REGISTROS.
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
        //endregion

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
                        modificarMaterialPolicial(idOperador);
                        break;
                    case 2:
                        modificarDenuncia(idOperador);
                        break;
                    default:
                        System.out.println("INGRESE UN NUMERO VALIDO...");
                        break;
                }
            } while (selector != 0 );
        }

        //region SUBMENÚ MODIFICAR.
            private static void modificarMaterialPolicial(Integer idOperador) {
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
                System.out.println("Ingrese un comentario para la modificacion:");
                System.out.println("> ");
                boolean flag = materialPolicial.agregarMod(new Modificacion(idOperador, LocalDateTime.now().toString(), lector.nextLine()));
                if (flag) {
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
                    System.out.println("> ");
                    ((Denuncia) denuncia).setDeclaracion(lector.nextLine());
                } else {
                    System.out.println("El ID no pertenece a una DENUNCIA.");
                }
                System.out.println("Ingrese un comentario para la modificacion:");
                System.out.println("> ");
                boolean flag = denuncia.agregarMod(new Modificacion(idOperador, LocalDateTime.now().toString(), lector.nextLine()));
                if (flag) {
                    System.out.println("SE PRESENTÓ UN PROBLEMA AL INGRESAR EL COMENTARIO DE LA MODIFICACION...");
                }
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
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }while (selector != 0);
        }

        ///MENU PARA DAR DE BAJA A UN PERSONAL
        public static void menuBajaDepartamento(){
            int selector;
            Personal aux = new Personal();
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
                            aux.setLegajo(lector.nextInt());
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
                            aux.setLegajo(lector.nextInt());
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
                            aux.setLegajo(lector.nextInt());
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
                            aux.setLegajo(lector.nextInt());
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
        Personal aux = new Personal();
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
                        aux.setLegajo(lector.nextInt());
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
                        aux.setLegajo(lector.nextInt());
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
                        aux.setLegajo(lector.nextInt());
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
                        aux.setLegajo(lector.nextInt());
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

