package Area;

import Enums.T_Sector;
import Interfaces.IJson;
import org.json.JSONObject;

import java.util.Scanner;

public class Visita implements IJson<Visita> {
    private Integer idProcesado;
    private T_Sector sector;
    private Integer tiempoVisita;
    private String observacion, nroSector, fechaVisita , dniVisitante;

    public Visita(Integer idProcesado, String idVisitante, T_Sector sector, Integer tiempoVisita, String observacion, String nroSector, String diaVisita) {
        this.idProcesado = idProcesado;
        this.dniVisitante = idVisitante;
        this.sector = sector;
        this.tiempoVisita = tiempoVisita;
        this.observacion = observacion;
        this.nroSector = nroSector;
        this.fechaVisita = diaVisita;
    }

    public Visita() {
    }

    //region GETTERS & SETTERS
    public String getFechaVisita() {
        return fechaVisita;
    }
    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
    public Integer getIdProcesado() {
        return idProcesado;
    }
    public void setIdProcesado(Integer idProcesado) {
        this.idProcesado = idProcesado;
    }
    public String getDniVisitante() {
        return dniVisitante;
    }
    public void setDniVisitante(String dniVisitante) {
        this.dniVisitante = dniVisitante;
    }
    public T_Sector getSector() {
        return sector;
    }
    public void setSector(T_Sector sector) {
        this.sector = sector;
    }
    public Integer getTiempoVisita() {
        return tiempoVisita;
    }
    public void setTiempoVisita(Integer tiempoVisita) {
        this.tiempoVisita = tiempoVisita;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getNroSector() {
        return nroSector;
    }
    public void setNroSector(String nroSector) {
        this.nroSector = nroSector;
    }
    //endregion

    public void crearVisita(Scanner scanner){
        System.out.println("Ingrese el dni del visitante:");
        dniVisitante = scanner.nextLine();
        System.out.println("Ingrese el tiempo de visita (Horas):");
        tiempoVisita = scanner.nextInt();
        System.out.println("Ingrese el sector 1.MESAS\n" +
                "2.VENTANILLA\n" +
                "3.PATIO\n");
        switch (scanner.nextInt()){
            case 1 -> sector = T_Sector.MESAS;
            case 2 -> sector = T_Sector.VENTANILLA;
            case 3 -> sector = T_Sector.PATIO;
        }
        System.out.println("Ingrese el numero del sector:");
        System.out.println("Ingrese la fecha de la visita:");
        System.out.println("Ingrese algun comentario sobre la visita:");
    }

    @Override
    public String toString() {
        return "Visita{" +
                ", idProcesado=" + idProcesado +
                ", idVisitante=" + dniVisitante +
                ", sector=" + sector +
                ", tiempoVisita=" + tiempoVisita +
                ", observacion='" + observacion + '\'' +
                ", nroSector='" + nroSector + '\'' +
                '}';
    }

    @Override
    public Visita jsonToThisClass(JSONObject json) {
        return null;
    }

    @Override
    public JSONObject classToJson() {
        return null;
    }
}
