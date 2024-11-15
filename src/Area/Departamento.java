package Area;

import Entidades.MiembroFuerza;
import Entidades.Personal;
import Enums.T_Depto;
import Enums.T_Rango;
import Exceptions.NoEncontradoException;
import Exceptions.YaExisteException;
import Interfaces.IJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Departamento <T extends Personal> implements IJson<T> {
    private HashMap<T_Depto, ArrayList<T>>listaDepartamentos;

    public Departamento() {
        listaDepartamentos = new HashMap<>();
    }

    public boolean agregarAlDepartamento(T_Depto tipoDepto, T dato) throws YaExisteException {
        ArrayList<T> depto = listaDepartamentos.get(tipoDepto);
        if (depto == null) {
            depto = new ArrayList<>();
            listaDepartamentos.put(tipoDepto,depto);
        }
        if(!depto.add(dato)){
            throw new YaExisteException("el personal que intenta agregar ya existe dentro de la lista");
        }
        return depto.add(dato);
    }

    public boolean eliminarDelDepartamento(T_Depto tipoDepto, T dato) throws NoEncontradoException {
        Boolean flag=false;
        for(int i = 0; i < listaDepartamentos.get(tipoDepto).size(); i++){
            if(listaDepartamentos.get(tipoDepto).get(i).equals(dato)){
                listaDepartamentos.get(tipoDepto).get(i).setActivo(false);
                flag=true;
                break;
            }
        }
        if(!flag){
            throw new NoEncontradoException("No se encontro el personal seleccionado");
        }
        return flag;
    }
    public boolean listar(T_Depto tipoDepto)  {
        ArrayList<T> person= listaDepartamentos.get(tipoDepto);
        if(person!=null){
            System.out.println("Departamento:" + tipoDepto + "\n");
            for (T persona: person){
                System.out.println(persona.toString());
            }
        }
        return person!=null;
    }

    public void modificarPersonal(T_Depto tipoDepto, T data)  throws NoEncontradoException{
        int lugar = listaDepartamentos.get(tipoDepto).indexOf(data);
        if(lugar == -1){
            throw new NoEncontradoException("No se encontro el elemento");
        }
        System.out.println("1.TELEFONO");
        System.out.println("2.DNI");
        System.out.println("3.EDAD");
        System.out.println("4.GENERO");
        System.out.println("5.SALARIO");
        if(listaDepartamentos.get(tipoDepto).get(lugar) instanceof MiembroFuerza) {
            System.out.println("6.CONDECORACIONES");
            System.out.println("7.RANGO");
        }
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
                case 1:
                    listaDepartamentos.get(tipoDepto).get(lugar).setTelefono(scan.next());
                    break;
                case 2:
                    listaDepartamentos.get(tipoDepto).get(lugar).setDni(scan.next());
                    break;
                case 3:
                    listaDepartamentos.get(tipoDepto).get(lugar).setEdad(scan.nextInt());
                    break;
                case 4:
                    int e = 0;
                    do {
                        e = scan.nextInt();
                    } while (e < 1 || e > 2);
                    listaDepartamentos.get(tipoDepto).get(lugar).setGenero(scan.nextLine().charAt(0));
                    break;
                case 5:
                    try {
                        listaDepartamentos.get(tipoDepto).get(lugar).setSalario(scan.nextDouble());
                    }catch (InputMismatchException a){
                        a.printStackTrace();
                    }
                    break;
                case 6:
                    if(listaDepartamentos.get(tipoDepto).get(lugar) instanceof  MiembroFuerza){
                        ((MiembroFuerza) listaDepartamentos.get(tipoDepto).get(lugar)).setCondecoraciones(scan.nextInt());
                    }
                    break;
                case 7:
                    if(listaDepartamentos.get(tipoDepto).get(lugar) instanceof  MiembroFuerza){
                        ((MiembroFuerza) listaDepartamentos.get(tipoDepto).get(lugar)).setRango(rango(scan.nextInt()));
                    }
                    break;
        }
    }

    public static T_Rango rango(int i) throws IllegalStateException{
        return switch (i) {
            case 1 -> T_Rango.OFICIAL;
            case 2 -> T_Rango.SARGENTO;
            case 3 -> T_Rango.TENIENTE;
            case 4 -> T_Rango.CAPITAN;
            default -> throw new IllegalStateException("Seleccion incorrecta, vuelva a intentar");
        };
    }

    @Override
    public T jsonToThisClass(JSONObject json) {
        return null;
    }

    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        json.put("Departamentos",listaDepartamentos);
        return json;
    }
}
// TODO modificar, listar del ABML
