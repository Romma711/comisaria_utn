package Area;

import Enums.T_Estado;
import Interfaces.ABML;
import Entidades.Procesado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

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
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese \'1\' para cambiar el comentario del recluso.");
        System.out.println("Ingrese \'2\' para cambiar el estado del recluso.");
        System.out.println("Ingrese \'3\' para cambiar la fecha de egreso del recluso.");

        boolean flag = true;

        while (flag) {
            int command = scan.nextInt();
            scan.nextLine();

            switch (command) {
                case 1:
                    cambiarComentario(dato, scan);
                    flag = false;
                    break;
                case 2:
                    cambiarEstado(dato, scan);
                    flag = false;
                    break;
                case 3:
                    cambiarFechaEgreso(dato, scan);
                    flag = false;
                    break;
                default:
                    System.out.println("No ha ingresado un número válido.");
            }
        }
    }

    private void cambiarComentario(Procesado dato, Scanner scan){
        System.out.println("Ingrese el nuevo comentario");
        dato.setComentario(scan.nextLine());
    }

    private void cambiarEstado(Procesado dato, Scanner scan){
        System.out.println("Ingrese: 'P' para 'Procesado', 'I' para 'Indultado', 'D' para 'Detenido', 'M' para 'Migrado'");
        T_Estado estado = T_Estado.PROCESADO;
        boolean valido = false;

        while (!valido) {
            String input = scan.nextLine().trim().toUpperCase();
            switch (input) {
                case "P":
                    estado = T_Estado.PROCESADO;
                    valido = true;
                    break;
                case "I":
                    estado = T_Estado.INDULTADO;
                    valido = true;
                    break;
                case "D":
                    estado = T_Estado.DETENIDO;
                    valido = true;
                    break;
                case "M":
                    estado = T_Estado.MIGRADO;
                    valido = true;
                    break;
                default:
                    System.out.println("Ingrese una letra válida.");
            }
        }
        dato.setEstado(estado);
    }

    private void cambiarFechaEgreso(Procesado dato, Scanner scan){
        System.out.println("Ingrese la fecha de egreso con formato YYYY-MM-DD:");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean fechaValida = false;

        while(!fechaValida){
            String entradaFecha = scan.nextLine().trim();
            try{
                LocalDate fechaEgreso = LocalDate.parse(entradaFecha, dateFormatter);
                dato.setFechaEgreso(fechaEgreso);
                System.out.println("Fecha de egreso actualizada a: " + fechaEgreso);
                fechaValida = true;
            } catch (DateTimeParseException e){
                System.out.println("Formato de fecha invalido. Por favor ingrese en el formato YYYY-MM-DD.");
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