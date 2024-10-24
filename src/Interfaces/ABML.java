package Interfaces;

public interface ABML<T> {
    public boolean agregar(T dato);
    public boolean eliminar(T dato);
    public void modificar(T dato);
    public void listar();
}
