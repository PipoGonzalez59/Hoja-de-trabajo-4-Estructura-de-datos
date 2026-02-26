// implementacion de lista simplemente enlazada
public class ListaSimple<T> extends AbstractLista<T> {

    // clase interna Nodo
    private class Nodo {
        T dato;
        Nodo siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    private Nodo cabeza; // primer nodo

    @Override
    public void add(T item) {

        Nodo nuevo = new Nodo(item);

        // si la lista esta vacia
        if (cabeza == null) {
            cabeza = nuevo;
        } else {

            // recorrer hasta el final
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }

        size++; // aumentar contador
    }

    @Override
    public T removeLast() {

        if (isEmpty()) return null;

        // si solo hay un elemento
        if (cabeza.siguiente == null) {
            T dato = cabeza.dato;
            cabeza = null;
            size--;
            return dato;
        }

        // recorrer hasta el penultimo
        Nodo temp = cabeza;
        while (temp.siguiente.siguiente != null) {
            temp = temp.siguiente;
        }

        T dato = temp.siguiente.dato;
        temp.siguiente = null;
        size--;
        return dato;
    }

    @Override
    public T getLast() {

        if (isEmpty()) return null;

        Nodo temp = cabeza;

        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }

        return temp.dato;
    }
}