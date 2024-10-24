package Entidades;
///region IMPORTS
import Enums.T_Estado;
import java.util.Date;
import java.util.UUID;
///endregion

public class Procesado extends Ingresante {
    private String comentario;
    private Date fechaEgreso;
    private UUID idCalabozo;
    private T_Estado estado;

    public Procesado(String comentario, Date fechaEgreso, UUID idCalabozo, T_Estado estado) {
        this.comentario = comentario;
        this.fechaEgreso = fechaEgreso;
        this.idCalabozo = idCalabozo;
        this.estado = estado;
    }

    ///region GETTERS & SETTERS
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Date getFechaEgreso() {
        return fechaEgreso;
    }
    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
    public UUID getIdCalabozo() {
        return idCalabozo;
    }
    public void setIdCalabozo(UUID idCalabozo) {
        this.idCalabozo = idCalabozo;
    }
    public T_Estado getEstado() {
        return estado;
    }
    public void setEstado(T_Estado estado) {
        this.estado = estado;
    }
    ///endregion

}
