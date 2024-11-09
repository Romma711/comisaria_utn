package Area;

import Entidades.MiembroFuerza;
import Entidades.Personal;
import Enums.T_Depto;
import Enums.T_Rango;
import Exceptions.NoEncontradoException;
import Exceptions.NoHayNadieEnLista;
import Exceptions.YaExisteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Departamento <T extends Personal> {
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
    public boolean listar(T_Depto tipoDepto) throws NoHayNadieEnLista {
        ArrayList<T> person= listaDepartamentos.get(tipoDepto);
        if(person!=null){
            System.out.println("nombre del Departamento" + tipoDepto + "\n");
            for (T persona: person){
                System.out.println(persona.toString());
            }
        }else {
            throw new NoHayNadieEnLista("No hay personas aqui");
        }
        return person!=null;
    }

    public void moficarPersonal(T_Depto tipoDepto, int lugar, int selector)  {
        Scanner scan = new Scanner(System.in);
        if (lugar != -1) {
            switch (selector) {
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
                    listaDepartamentos.get(tipoDepto).get(lugar).setGenero(Genero(e));
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
                        ((MiembroFuerza) listaDepartamentos.get(tipoDepto).get(lugar)).setSerialArma(scan.toString());
                    }
                    break;
                case 7:
                    if(listaDepartamentos.get(tipoDepto).get(lugar) instanceof  MiembroFuerza){
                        ((MiembroFuerza) listaDepartamentos.get(tipoDepto).get(lugar)).setCondecoraciones(scan.nextInt());
                    }
                    break;
                case 8:
                    if(listaDepartamentos.get(tipoDepto).get(lugar) instanceof  MiembroFuerza){
                        ((MiembroFuerza) listaDepartamentos.get(tipoDepto).get(lugar)).setRango(rango(scan.nextInt()));
                    }
                    break;

            }
        }
    }
    public Character Genero(int i) {
        if (i == 1) return 'm';
        else return 'f';
    }
    public T_Rango rango(int i) {
        return switch (i) {
            case 1 -> T_Rango.SUPERINTENDENTE;
            case 2 -> T_Rango.SARGENTO;
            case 3 -> T_Rango.SUBTENIENTE;
            case 4 -> T_Rango.TENIENTE;
            case 5 -> T_Rango.TENIENTE_PRIMERO;
            case 6 -> T_Rango.CAPITAN;
            case 7 -> T_Rango.INSPECTOR;
            case 8 -> T_Rango.COMISIONADO;
            default -> T_Rango.OFICIAL;
        };
    }
}
// TODO modificar, listar del ABML
