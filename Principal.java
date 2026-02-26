import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // se pide la ruta del archivo
        System.out.println("Ingrese la ruta del archivo:"); //porfavor pongan la ruta exacta de acceso del archivo, y sin comillas
        String ruta = sc.nextLine();

        // se pide el tipo de implementacion del stack
        System.out.println("Seleccione implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int opcion = sc.nextInt();

        // se crean dos stacks (uno para operadores y otro para numeros)
        Stack<Character> stackOperadores = StackFactory.getStack(opcion);
        Stack<Integer> stackNumeros = StackFactory.getStack(opcion);

        // se obtiene la unica instancia de la calculadora
        Calculadora calc = Calculadora.getInstance();

        // se lee la expresion del archivo
        Lector lector = new Lector();
        String infix = lector.leerArchivo(ruta);

        System.out.println("Expresión infix: " + infix);

        // convertir a postfix
        String postfix = calc.infixToPostfix(infix, stackOperadores);

        System.out.println("Expresión postfix: " + postfix);

        // evaluar postfix
        int resultado = calc.evaluarPostfix(postfix, stackNumeros);

        System.out.println("Resultado: " + resultado);
    }
}