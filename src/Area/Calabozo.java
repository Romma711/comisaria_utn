package Area;
///region IMPORTS
import Enums.T_Estado;
import Interfaces.ABML;
import Entidades.Procesado;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
///endregion

public class Calabozo implements ABML<Procesado> {
    private UUID idCalabozo;
    private ArrayList<Procesado> reclusos;

    public Calabozo() {
        idCalabozo = UUID.randomUUID();
        reclusos = new ArrayList<>();
    }

    @Override
    public boolean agregar(Procesado dato) {
        return reclusos.add(dato);
    }

    @Override
    public boolean eliminar(Procesado dato) {
        return reclusos.remove(dato);
    }

    @Override
    public void modificar(Procesado dato) {
        System.out.println("Ingrese \'1\' para cambiar el comentario del recluso.");
        System.out.println("Ingrese \'2\' para cambiar el estado del recluso.");
        System.out.println("Ingrese \'3\' para cambiar la fecha de egreso del recluso.");
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int command;

        while (flag) {
            command = scan.nextInt();

            switch (command) {
                case 1: // Cambiar comentario.
                    dato.setComentario(scan.nextLine());
                    scan.nextLine();
                    flag = false;
                    break;
                case 2: // Cambiar estado.
                    System.out.println("Ingrese\n\'P\' para establecer como \'Procesado\'");
                    System.out.println("\'I\' para establecer como \'Indultado\'");
                    System.out.println("\'D\' para establecer como \'Detenido\'");
                    System.out.println("\'M\' para establecer como \'Migrado\'");

                    String establecer = "0"; // Para poder entrar al while;
                    T_Estado estado = T_Estado.PROCESADO;

                    while (flag) {
                        establecer = scan.nextLine();
                        scan.nextLine();
                        establecer.toUpperCase();

                        switch (establecer) {
                            case ("P"): flag = false; //por estar inicializado como PROCESADO.
                                break;
                            case ("I"): estado = T_Estado.INDULTADO;
                                flag = false;
                                break;
                            case ("D"): estado = T_Estado.DETENIDO;
                                flag = false;
                                break;
                            case ("M"): estado = T_Estado.MIGRADO;
                                flag = false;
                                break;
                            default:
                                System.out.println("Ingrese una letra válida.");
                                break;
                        }
                    }
                    dato.setEstado(estado);
                    break;
                case 3: // Cambiar fecha de egreso.
                    //TODO dato.setFechaEgreso(scan.nextDate());
                    flag = false;
                    break;
                default:
                    System.out.println("No ha ingresado un número válido");
                    break;
            }
        }
    }

    @Override
    public void listar() {
        for (Procesado procesado: reclusos) {
            System.out.println(procesado.toString());
        }
    }
}

//TODO revisar si se limpia el buffer con el "scan.nextLine()"
