public class Calculadora {

    // instancia unica (patron Singleton)
    private static Calculadora instancia;

    // constructor privado para que no se pueda crear con new
    private Calculadora() {}

    // metodo para obtener la unica instancia
    public static Calculadora getInstance() {
        if (instancia == null) {
            instancia = new Calculadora();
        }
        return instancia;
    }

    // metodo que define la precedencia de operadores
    private int precedencia(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // convierte una expresion infix a postfix usando una pila
    public String infixToPostfix(String infix, Stack<Character> stack) {

        String resultado = "";
        String numero = "";

        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            // se ignoran espacios
            if (c == ' ') {
                continue;
            }

            // si es numero lo va formando (ej: 10, 20)
            if (Character.isDigit(c)) {
                numero += c;
            } else {

                // si ya termino de leer un numero lo agrega al resultado
                if (!numero.equals("")) {
                    resultado += numero + " ";
                    numero = "";
                }

                // si es parentesis izquierdo lo mete a la pila
                if (c == '(') {
                    stack.push(c);

                    // si es parentesis derecho saca todo hasta encontrar '('
                } else if (c == ')') {

                    while (!stack.isEmpty() && stack.peek() != '(') {
                        resultado += stack.pop() + " ";
                    }

                    stack.pop(); // quitar el '('

                    // si es operador revisa precedencia
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {

                    while (!stack.isEmpty() &&
                            precedencia(c) <= precedencia(stack.peek())) {

                        resultado += stack.pop() + " ";
                    }

                    stack.push(c);
                }
            }
        }

        // por si termina en numero
        if (!numero.equals("")) {
            resultado += numero + " ";
        }

        // vaciar la pila al final
        while (!stack.isEmpty()) {
            resultado += stack.pop() + " ";
        }

        return resultado.trim();
    }

    // evalua una expresion en postfix
    public int evaluarPostfix(String postfix, Stack<Integer> stack) {

        String[] partes = postfix.split(" ");

        for (String actual : partes) {

            try {
                // si es numero lo mete a la pila
                int numero = Integer.parseInt(actual);
                stack.push(numero);

            } catch (NumberFormatException e) {

                // si no es numero entonces es operador
                int b = stack.pop();
                int a = stack.pop();

                if (actual.equals("+")) stack.push(a + b);
                if (actual.equals("-")) stack.push(a - b);
                if (actual.equals("*")) stack.push(a * b);
                if (actual.equals("/")) stack.push(a / b);
            }
        }

        // el resultado final queda en la pila
        return stack.pop();
    }
}