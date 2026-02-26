public class StackFactory {

    public static <T> Stack<T> getStack(int opcion) {

        switch (opcion) {
            case 1:
                return new StackArrayList<>();
            case 2:
                return new StackVector<>();
            case 3:
                return new StackLista<>(new ListaSimple<>());
            default:
                return new StackArrayList<>();
        }
    }
}