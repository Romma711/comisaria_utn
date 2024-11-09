import Almacen.*;
import Entidades.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gestor {

    public static void guardarArchivo(JSONArray array, String json){
        try{
            FileWriter file = new FileWriter(json);
            file.write(array.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONTokener leerArchivo(String json){
        JSONTokener token=null;
        try{
            token= new JSONTokener(new FileReader(json));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return token;
    }
    ///Esta funcion sirve para convertir el objeto a json
    public static JSONObject convertirAJSON(Object obj){
        JSONObject json = new JSONObject();
        if(obj instanceof Persona){ /// Aca revisa que sea una instancia de Persona
            convertirPersona(json,(Persona)obj);
            if (obj instanceof Personal){ ///Despues de incorporar los atributos de persona revisa una instancia de personal
                convertirPersonal(json,(Personal)obj);
                if(obj instanceof MiembroFuerza){ ///Despues de incorporar los atributos de personal revisa una instancia de MiembroFuerza
                    convertirMiembroFuerza(json,(MiembroFuerza) obj);
                }
            }else{///Aca al ver que no es una instancia de Personal va directo a Ingresante
                convertirIngresante(json,(Ingresante) obj);

                if(obj instanceof Procesado){ ///Y despues revisa que sea una instancia de procesado
                    convertirProcesado(json,(Procesado) obj);
                }
            }
        }
        if(obj instanceof Registro){
            convertirRegistro(json,(Registro) obj);
            if(obj instanceof Material_Policial){
                convertirMaterialPolicial(json,(Material_Policial) obj);
            }
            if(obj instanceof Denuncia){
                convertirDenuncia(json,(Denuncia) obj);
            }
            if(obj instanceof Caso){
                convertirCaso(json,(Caso) obj);
            }

        }
        return json;
    }
    //region convertir a json
    private static void convertirPersona(JSONObject json, Persona obj){
        json.put("nombre",obj.getNombre());
        json.put("apellido",obj.getApellido());
        json.put("direccion",obj.getDireccion());
        json.put("telefono",obj.getTelefono());
        json.put("dni",obj.getDni());
        json.put("edad",obj.getEdad());
        json.put("genero",obj.getGenero());
    }

    private static void convertirPersonal(JSONObject json, Personal obj){
        json.put("legajo",obj.getLegajo());
        json.put("horas_diarias",obj.getHorasDiarias());
        json.put("salario",obj.getSalario());
        json.put("horas_mes",obj.getHorasTotalesMes());
        json.put("tarea",obj.getTarea());
    }

    private static void convertirMiembroFuerza(JSONObject json, MiembroFuerza obj){
        json.put("rango",obj.getRango().getClass());
        json.put("serial_arma",obj.getSerialArma());
        json.put("placa",obj.getPlaca());
        json.put("servicio",obj.getServicio());
        json.put("condecoraciones",obj.getCondecoraciones());
    }

    private static void convertirIngresante(JSONObject json, Ingresante obj){
        json.put("fecha_ingreso",obj.getFechaIngreso());
        json.put("razon",obj.getRazon());
        json.put("nro_casillero",obj.getNroCasillero());
        json.put("id",obj.getId());
        json.put("cantidad_visitas",obj.getCantidadVisitas());
    }

    private static void convertirProcesado(JSONObject json, Procesado obj){
        json.put("comentario",obj.getComentario());
        json.put("fecha_egreso",obj.getFechaEgreso());
        json.put("id_calabozo",obj.getIdCalabozo());
        json.put("estado",obj.getEstado().getClass());
    }

    private static void convertirModificacion(JSONObject json, Modificacion obj){
        json.put("id_operador",obj.getIdOperador());
        json.put("fecha_modificacion",obj.getFechaModificacion());
        json.put("razon",obj.getRazon());
    }

    private static void convertirMaterialPolicial(JSONObject json, Material_Policial obj){
        json.put("id_propietario",obj.getIdPropietario());
        json.put("tipo",obj.getTipo().getClass());
    }

    private static void convertirEvidencia(JSONObject json, Evidencia obj){
        json.put("analisis",obj.getAnalisis());
        json.put("paradero",obj.getParadero());
        json.put("id_evidencia",obj.getIdEvidencia());
        json.put("tipo",obj.getTipo().getClass());
    }

    private static void convertirDenuncia(JSONObject json, Denuncia obj){
        json.put("denunciante",obj.getDniDenunciante());
        json.put("denunciado",obj.getDniDenunciado());
        json.put("declaracion",obj.getDeclaracion());
    }

    private static void convertirCaso(JSONObject json, Caso obj){
        JSONArray array = new JSONArray();
        JSONObject aux = new JSONObject();
        for(int i=0; i<obj.retornarLength();i++){
            convertirEvidencia(aux,obj.retornarEvidencia(i));
            array.put(aux);
        }
        json.put("comentarios",obj);
        json.put("evidencias",array);
    }
    private static void convertirRegistro(JSONObject json, Registro obj) {
        JSONArray array = new JSONArray();
        JSONObject aux = new JSONObject();
        for(int i=0; i<obj.retornarLenght();i++){
            convertirModificacion(aux,obj.retornarPosicion(i));
            array.put(aux);
        }
        json.put("id_registro", obj);
        json.put("modificaciones", array);
    }
    //endregion

}
