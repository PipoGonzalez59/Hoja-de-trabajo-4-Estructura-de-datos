public class ListaFactory {

    public static <T> Lista<T> getLista(int opcion) {

        switch (opcion) {
            case 1:
                return new ListaSimple<>();
            case 2:
                return new ListaSimple<>();
            default:
                return new ListaSimple<>();
        }
    }
}