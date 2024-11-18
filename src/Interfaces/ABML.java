package Interfaces;

public interface ABML<T> {
    boolean agregar(T dato);
    boolean eliminar(T dato);
    void modificar(T dato);
    void listar();
}
