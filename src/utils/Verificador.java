package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Verificador {

    public static String verificarString(){
        Scanner scan = new Scanner(System.in);
        String validador;
        do {
            validador = scan.nextLine();
            if(validador.isBlank() || validador.isEmpty()){
                System.out.println("ERROR: Dato no valido\n");
            }
        }while (validador.isBlank() || validador.isEmpty());
        return validador;
    }
    public static Integer verificarInt(){
        Scanner scan = new Scanner(System.in);
        Integer validador;
        try {
            validador = scan.nextInt();
        }catch (InputMismatchException e){
            e.getMessage();
            System.out.println("ERROR: Dato no valido\n");
            validador=0;
        }
        return validador;
    }
    public static Double verificarDouble(){
        Scanner scan = new Scanner(System.in);
        Double validador;
            try {
                validador = scan.nextDouble();
            }catch (InputMismatchException e){
                e.getMessage();
                System.out.println("ERROR: Dato no valido\n");
                validador = 0.0;
            }
        return validador;
    }

    public static Boolean verificarMayorEdad(Integer edad){
        if(edad >= 18 && edad <70){ return true;}
        System.out.println("ERROR: La persona no puede ser menor de edad, Vuelva a intentarlo\n");
        return false;
    }
}
