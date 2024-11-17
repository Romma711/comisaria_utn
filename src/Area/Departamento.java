package Area;

import Entidades.MiembroFuerza;
import Entidades.Personal;
import Enums.T_Depto;
import Enums.T_Rango;
import Enums.T_Registro;
import Exceptions.NoEncontradoException;
import Exceptions.YaExisteException;
import Interfaces.IJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class Departamento implements IJson<Departamento> {
    private final HashMap<T_Depto, ArrayList<Personal>>listaDepartamentos;
    public Departamento() {
        listaDepartamentos = new HashMap<>();
    }

    public boolean agregarAlDepartamento(T_Depto tipoDepto, Personal dato) throws YaExisteException {
        ArrayList<Personal> depto = listaDepartamentos.get(tipoDepto);
        if (depto == null) {
            depto = new ArrayList<>();
            listaDepartamentos.put(tipoDepto,depto);
        }
        if(depto.contains(dato)){
            throw new YaExisteException("el personal que intenta agregar ya existe dentro de la lista");
        }
        return depto.add(dato);
    }

    public boolean eliminarDelDepartamento(T_Depto tipoDepto, Personal dato) throws NoEncontradoException {
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
        ArrayList<Personal> person= listaDepartamentos.get(tipoDepto);
        if(person!=null){
            System.out.println("Departamento:" + tipoDepto + "\n");
            for (Personal persona: person){
                System.out.println(persona.toString());
            }
        }
        return person!=null;
    }

    public void modificarPersonal(T_Depto tipoDepto, Personal data)  throws NoEncontradoException{
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
                            e.getMessage();
                        }

                    }else {
                        Personal nuevo = new Personal();
                        try{
                            departamento.agregarAlDepartamento(clave, nuevo.jsonToThisClass(personalJson));
                        }catch (YaExisteException e){
                            e.getMessage();
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
}

