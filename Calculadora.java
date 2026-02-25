public class Calculadora implements Calc {
    
    private Stack<Integer> pila; //pila para guardar los operandos

    //se recibe la pila que se va a usar
    public Calculadora(Stack<Integer> pila) {
        this.pila = pila;
    }

    /**
     * The `Operate` function takes a string input representing a mathematical expression in postfix
     * notation, evaluates it, and returns the result.
     * 
     * @param input The code you provided is a method called `Operate` that takes a string input
     * representing a mathematical expression in postfix notation and evaluates it. It uses a stack
     * (`pila`) to keep track of operands and perform the operations.
     * @return The method is returning the result of the arithmetic operation performed on the input
     * expression. The result is obtained by evaluating the expression using a stack data structure to
     * store operands and perform operations based on the operators encountered in the input string.
     */
    public int Operate(String input) {

        String[] partes = input.split(" "); // se separa la expresion por espacios

        for (int i = 0; i < partes.length; i++) { //se recorre la expresion

            String actual = partes[i];

            // si es un operando
            if (actual.equals("0") || actual.equals("1") || actual.equals("2") ||
                actual.equals("3") || actual.equals("4") || actual.equals("5") ||
                actual.equals("6") || actual.equals("7") || actual.equals("8") ||
                actual.equals("9")) {

                pila.push(Integer.parseInt(actual));
            }
            // si es operador
            else {
                int b = pila.pop();
                int a = pila.pop();

                if (actual.equals("+")) {
                    pila.push(a + b);
                }
                if (actual.equals("-")) {
                    pila.push(a - b);
                }
                if (actual.equals("*")) {
                    pila.push(a * b);
                }
                if (actual.equals("/")) {
                    pila.push(a / b);
                }
            }
        }

        return pila.pop();
    }
}