package Area;

import Enums.T_Sector;
import Interfaces.IJson;
import org.json.JSONObject;

import java.util.UUID;

public class Visita implements IJson<Visita> {
    private UUID idVisita, idProcesado, idVisitante;
    private T_Sector sector;
    private Integer tiempoVisita;
    private String observacion, nroSector;

    public Visita(T_Sector sector, String nroSector, UUID idProcesado, UUID idVisitante, Integer tiempoVisita, String observacion) {
        idVisita = UUID.randomUUID();
        this.sector = sector;
        this.nroSector = nroSector;
        this.idProcesado = idProcesado;
        this.idVisitante = idVisitante;
        this.tiempoVisita = tiempoVisita;
        this.observacion = observacion;
    }

    ///region GETTERS & SETTERS
    public UUID getIdVisita() {
        return idVisita;
    }
    public UUID getIdProcesado() {
        return idProcesado;
    }
    public void setIdProcesado(UUID idProcesado) {
        this.idProcesado = idProcesado;
    }
    public UUID getIdVisitante() {
        return idVisitante;
    }
    public void setIdVisitante(UUID idVisitante) {
        this.idVisitante = idVisitante;
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
    ///endregion

    @Override
    public String toString() {
        return "Visita{" +
                "idVisita=" + idVisita +
                ", idProcesado=" + idProcesado +
                ", idVisitante=" + idVisitante +
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
