// implementacion del stack usando nuestra lista simple
public class StackLista<T> extends AbstractStack<T> {

    private Lista<T> lista;

    // recibe la implementacion de lista que se va a usar
    public StackLista(Lista<T> lista) {
        this.lista = lista;
    }

    @Override
    public void push(T item) {
        lista.add(item);
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        count--;
        return lista.removeLast();
    }

    @Override
    public T peek() {
        return lista.getLast();
    }
}