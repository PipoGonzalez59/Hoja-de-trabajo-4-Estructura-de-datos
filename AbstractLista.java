// clase abstracta que maneja el tamaño de la lista
public abstract class AbstractLista<T> implements Lista<T> {

    protected int size = 0;  // contador de elementos

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}