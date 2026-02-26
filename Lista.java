public interface Lista<T> {

    void add(T item);

    T removeLast();

    T getLast();

    boolean isEmpty();

    int size();
}