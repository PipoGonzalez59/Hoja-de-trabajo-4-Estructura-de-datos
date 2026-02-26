import java.util.Vector;

// implementacion del stack usando Vector
public class StackVector<T> extends AbstractStack<T> {

    private Vector<T> vector = new Vector<>();

    @Override
    public void push(T item) {
        vector.add(item); // agrega al final
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        count--;
        return vector.remove(vector.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return vector.get(vector.size() - 1);
    }
}