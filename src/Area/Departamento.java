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

import javax.xml.transform.Source;
import java.util.*;

public class Departamento implements IJson<Departamento> {
    private final HashMap<T_Depto, ArrayList<Personal>>listaDepartamentos;
    public Departamento() {
        listaDepartamentos = new HashMap<>();
    }

    public void agregarAlDepartamento(T_Depto tipoDepto, Personal dato) throws YaExisteException {
        for (T_Depto clave : T_Depto.values()){
            if (listaDepartamentos.get(clave) != null)
                if (listaDepartamentos.get(clave).contains(dato)) {
                    throw new YaExisteException("El personal que intenta agregar ya existe dentro de la lista");
                }
        }
        ArrayList<Personal> depto = listaDepartamentos.get(tipoDepto);
        if (depto == null) {
            depto = new ArrayList<>();
            listaDepartamentos.put(tipoDepto, depto);
        }
        depto.add(dato);
    }

    public void eliminarDelDepartamento(T_Depto tipoDepto, Integer dato) throws NoEncontradoException {
        List<Personal> departamento = listaDepartamentos.get(tipoDepto);

        for (int i = 0; i < departamento.size(); i++) {
            Personal personal = departamento.get(i);
            System.out.println(personal.toString());
            if (Objects.equals(personal.getLegajo(), dato) && personal.isActivo()) {
                personal.setActivo(false);
                return;
            }
        }
        throw new NoEncontradoException("No se encontró el personal seleccionado");
    }

    public void listar(T_Depto tipoDepto)  {
        ArrayList<Personal> person = listaDepartamentos.get(tipoDepto);
        if(person != null){
            System.out.println("Departamento:" + tipoDepto + "\n");
            for (Personal persona: person){
                if(persona.isActivo()){
                    System.out.println(persona);
                }
            }
        }
    }

    public void modificarPersonal(T_Depto tipoDepto, Integer data)  throws NoEncontradoException{
        int lugar=-1;
        for (int i = 0; i < listaDepartamentos.get(tipoDepto).size(); i++) {
            Personal personal = listaDepartamentos.get(tipoDepto).get(i);
            if (Objects.equals(personal.getLegajo(), data) && personal.isActivo()) {
                return;
            }
        }
        if(lugar == -1){
            throw new NoEncontradoException("No se encontro el elemento");
        }
        System.out.println("Que quiere modificar?");
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
                    System.out.println("Ingrese el nuevo dato");
                    System.out.println(">");
                    listaDepartamentos.get(tipoDepto).get(lugar).setTelefono(scan.next());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo dato");
                    System.out.println(">");
                    listaDepartamentos.get(tipoDepto).get(lugar).setDni(scan.next());
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo dato");
                    System.out.println(">");
                    listaDepartamentos.get(tipoDepto).get(lugar).setEdad(scan.nextInt());
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo dato");
                    System.out.println(">");
                    int e;
                    do {
                        e = scan.nextInt();
                        scan.nextLine();
                    } while (e < 1 || e > 2);
                    listaDepartamentos.get(tipoDepto).get(lugar).setGenero(scan.nextLine().charAt(0));
                    break;
                case 5:
                    System.out.println("Ingrese el nuevo dato");
                    System.out.println(">");
                    try {
                        listaDepartamentos.get(tipoDepto).get(lugar).setSalario(scan.nextDouble());
                    }catch (InputMismatchException a){
                        System.out.println("Error: Entrada inválida para salario, por favor, ingrese un número valido");
                        scan.nextLine();
                    }
                    break;
                case 6:
                    if(listaDepartamentos.get(tipoDepto).get(lugar) instanceof  MiembroFuerza){
                        System.out.println("Ingrese el nuevo dato");
                        System.out.println(">");
                        ((MiembroFuerza) listaDepartamentos.get(tipoDepto).get(lugar)).setCondecoraciones(scan.nextInt());
                    }
                    break;
                case 7:
                    if(listaDepartamentos.get(tipoDepto).get(lugar) instanceof  MiembroFuerza){
                        System.out.println("Ingrese el nuevo dato");
                        System.out.println(">");
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
    public Departamento jsonToThisClass(JSONObject json) {
        Departamento departamento = new Departamento();
        for (T_Depto clave : T_Depto.values()) {
            if (json.has(clave.name())) {
                JSONArray jsonArray = json.getJSONArray(clave.name());
                ///itera cada pocicion del JSONArray para almacenarlo en un objeto y luego en un arraylist
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject personalJson = jsonArray.getJSONObject(i);

                    if(clave == T_Depto.POLICIA){
                        MiembroFuerza nuevo = new MiembroFuerza();
                        try{
                            departamento.agregarAlDepartamento(clave, nuevo.jsonToThisClass(personalJson));
                        }catch (YaExisteException e){
                            System.out.println("Error al agregar al departamento: " + e.getMessage());
                        }

                    }else {
                        Personal nuevo = new Personal();
                        try{
                            departamento.agregarAlDepartamento(clave, nuevo.jsonToThisClass(personalJson));
                        }catch (YaExisteException e){
                            System.out.println("Error al agregar al departamento: " + e.getMessage());
                        }
                    }
                }
            }
        }
        Personal.setCont(json.getInt("cont"));
        return departamento;
    }

    @Override
    public JSONObject classToJson() {
        JSONObject json = new JSONObject();
        /// Iterar sobre los valores del enum
        for (T_Depto clave : T_Depto.values()) {
            JSONArray arrayReg = new JSONArray();
            try{
                for (int i = 0; i < listaDepartamentos.get(clave).size(); i++){
                    arrayReg.put(listaDepartamentos.get(clave).get(i).classToJson());
                }
                json.put(clave.toString(),arrayReg);
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }
        json.put("cont",Personal.getCont());
        return json;
    }
    public Integer verificarSiExiste(String dni){
        Personal aux= new Personal();
        aux.setDni(dni);
        for(T_Depto clave: T_Depto.values()){
            if(listaDepartamentos.get(clave)!=null){
                try {
                    int posicion = listaDepartamentos.get(clave).indexOf(aux);
                    return listaDepartamentos.get(clave).get(posicion).getLegajo();
                }catch (IndexOutOfBoundsException e){
                    e.getMessage();
                    System.out.println("ERROR: el DNI del personal no existe");
                }
            }
        }
        return -1;
    }
}

