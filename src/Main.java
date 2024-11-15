import Area.Calabozo;
import Area.Departamento;
import Entidades.MiembroFuerza;
import Entidades.Personal;
import Entidades.Procesado;
import Enums.T_Depto;
import Enums.T_Rango;
import Exceptions.YaExisteException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Departamento lista = new Departamento();
        Personal persona1 = new MiembroFuerza("42590901","andres","roma","calle falsa 3233","442512345",23,'M',20.00,20.20, T_Rango.CAPITAN,1);
        Personal persona2 = new MiembroFuerza("42590901","andres","roma","calle falsa 3233","442512345",23,'M',20.00,20.20,T_Rango.CAPITAN,2);
        Personal persona3 = new Personal("42590901","andres","roma","calle falsa 3233","442512345",23,'M',20.00,20.20);
        Personal persona4 = new Personal("42590901","andres","roma","calle falsa 3233","442512345",23,'M',20.00,20.20);
        Personal persona5 = new Personal("42590901","andres","roma","calle falsa 3233","442512345",23,'M',20.00,20.20);
        try {
            lista.agregarAlDepartamento(T_Depto.POLICIA,persona1);
            lista.agregarAlDepartamento(T_Depto.POLICIA,persona2);
            lista.agregarAlDepartamento(T_Depto.LIMPIEZA,persona3);
            lista.agregarAlDepartamento(T_Depto.MANTENIMIENTO,persona4);
            lista.agregarAlDepartamento(T_Depto.ADMINISTRACION,persona5);
        } catch (YaExisteException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lista.classToJson().toString());
    }
}