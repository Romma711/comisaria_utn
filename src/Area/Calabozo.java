package Area;

import Entidades.Ingresante;
import Entidades.Persona;
import Entidades.Personal;
import Enums.T_Estado;
import Interfaces.ABML;
import Entidades.Procesado;
import Interfaces.IJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Calabozo implements ABML<Procesado>, IJson<Calabozo> {
    private ArrayList<Procesado> reclusos;

    public Calabozo() {
        reclusos = new ArrayList<>();
    }

    @Override
    public boolean agregar(Procesado dato) {
        // Comprobación para evitar duplicados por ID
        if (reclusos.contains(dato)) {
            System.out.println("\nERROR: El recluso ya existe en el calabozo y no se puede agregar nuevamente.\n\n");
            return false;
        }

        return reclusos.add(dato);
    }
    @Override
    public boolean eliminar(Procesado dato) {
        // Comprobación para evitar eliminar un dato que no existe
        for (int i = 0; i < reclusos.size(); i++) {
            Procesado recluso = reclusos.get(i);
            if (recluso.getId() == dato.getId() && recluso.getEstado() != T_Estado.LIBERADO) {
                recluso.setEstado(T_Estado.LIBERADO);
                recluso.setFechaEgreso(LocalDate.now().toString());
                return true;
            }
        }
        return false;
    }
    @Override
    public void listar() {
        // Comprobación si la lista está vacía antes de listar
        if (reclusos.isEmpty()) {
            System.out.println("No hay reclusos en el calabozo.");
        } else {
            for (Procesado procesado : reclusos) {
                System.out.println(procesado.toString());
            }
        }
    }
    @Override
    public void modificar(Procesado dato) {
        // Comprobación para asegurar que el recluso existe antes de modificar
        boolean flag=false;
        int i;
        for (i = 0; i < reclusos.size(); i++) {
            if (reclusos.get(i).getId() == dato.getId() && reclusos.get(i).getEstado() != T_Estado.LIBERADO) {
                flag = true;
                break;
            }

        }
        if (!flag) {
            System.out.println("El recluso no se encuentra en el calabozo.");
            return;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese '1' para cambiar el estado del recluso.");
        System.out.println("Ingrese '2' para cambiar la fecha de egreso del recluso.");

        flag=true;

        while (flag) {
            int command = scan.nextInt();
            scan.nextLine();

            switch (command) {
                case 1:
                    cambiarEstado(reclusos.get(i), scan);
                    flag = false;
                    break;
                case 2:
                    cambiarFechaEgreso(reclusos.get(i), scan);
                    flag = false;
                    break;
                default:
                    System.out.println("No ha ingresado un número válido.");
            }
        }
    }
    private void cambiarEstado(Procesado dato, Scanner scan) {
        System.out.println("Ingrese: '1' para 'Procesado', '2' para 'Liberado', '3' para 'Detenido', '4' para 'Migrado'");
        T_Estado estado = T_Estado.PROCESADO;
        boolean valido = false;

        while (!valido) {
            String input = scan.nextLine().trim().toUpperCase();
            switch (input) {
                case "1":
                    estado = T_Estado.PROCESADO;
                    valido = true;
                    break;
                case "2":
                    estado = T_Estado.LIBERADO;
                    valido = true;
                    break;
                case "3":
                    estado = T_Estado.DETENIDO;
                    valido = true;
                    break;
                case "4":
                    estado = T_Estado.MIGRADO;
                    valido = true;
                    break;
                default:
                    System.out.println("Ingrese una letra válida.");
            }
        }
        dato.setEstado(estado);
    }
    private void cambiarFechaEgreso(Procesado dato, Scanner scan) {
        System.out.println("Ingrese la fecha de egreso con formato YYYY-MM-DD:");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean fechaValida = false;

        while (!fechaValida) {
            String entradaFecha = scan.nextLine().trim();
            try {
                LocalDate fechaEgreso = LocalDate.parse(entradaFecha, dateFormatter);
                dato.setFechaEgreso(fechaEgreso.toString());
                System.out.println("Fecha de egreso actualizada a: " + fechaEgreso);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor ingrese en el formato YYYY-MM-DD.");
            }
        }
    }

    @Override
    public Calabozo jsonToThisClass(JSONObject json) {
        Calabozo calabozo = new Calabozo();
        JSONArray array = json.getJSONArray("calabozo");
        for (int i = 0;i<array.length();i++){
            Procesado nuevo = new Procesado();
            JSONObject aux = array.getJSONObject(i);
            calabozo.agregar(nuevo.jsonToThisClass(aux));
        }
        Ingresante.setContadorId(json.getInt("cont"));
        return calabozo;
    }

    @Override
    public JSONObject classToJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i< reclusos.size();i++){
            jsonArray.put(reclusos.get(i).classToJson());
        }
        jsonObject.put("calabozo",jsonArray);
        jsonObject.put("cont", Ingresante.getContadorId());
        return jsonObject;
    }
}