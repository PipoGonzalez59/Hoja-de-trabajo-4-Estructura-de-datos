import java.util.ArrayList;

// implementacion del stack usando ArrayList
public class StackArrayList<T> extends AbstractStack<T> {

    // lista interna donde se guardan los datos
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(T item) {
        list.add(item);   // agrega al final
        count++;          // aumenta el contador
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        count--;
        return list.remove(list.size() - 1); // quita el ultimo
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1); // devuelve el ultimo
    }
}