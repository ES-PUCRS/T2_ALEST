public class Calculadora {
    private Pilha memoria;
    private int recordSize;
    private int pilhaSize;
    double a = 0, b = 0;


    public Calculadora(){
        memoria = new Pilha();
        pilhaSize = 0;
    }

    /*
     *   Método que recebe valor ou operando e já
     *   realiza a função correspondente com o dado inserido.
     *   @param
     *       • inteiro: neste caso o número inteiro deve ser inserido na calculadora e torna-se disponível;
     *       • +, *: as operações de soma e multiplicação são executadas com os dois últimos números disponíveis;
     *       • -, /: as operações de subtração e divisão são realizadas com os dois últimos números disponíveis.
     *   @Return
     *       • Log com as operações realizadas e resultados gerados decorrente do 'value' na entrada
     *
     *   A calculadora funciona baseada em switch
     */
    public String command(String value) {
        String resultReturn = "";
        double result = 0.0;
        recordSize();


        switch (value) {
            case "+": resultReturn = "Operation: +";
                    dropMemoria();
                    result = a + b;
                    resultReturn += "\nvalue: " + a +
                                    "\nvalue: " + b;
                break;

            case "-": resultReturn = "Operation: -";
                    dropMemoria();
                    result = a - b;
                    resultReturn += "\nvalue: " + a +
                                    "\nvalue: " + b;
                break;

            case "*": resultReturn = "Operation: *";
                    dropMemoria();
                    result = a * b;
                    resultReturn += "\nvalue: " + a +
                                    "\nvalue: " + b;
                break;

            case "/": resultReturn = "Operation: /";
                    dropMemoria();
                    result = a / b;
                    resultReturn += "\nvalue: " + a +
                                    "\nvalue: " + b;
                break;

            case "pop": resultReturn = "Operation: pop";
                resultReturn += "\nValue popped: " + memoria.pop();
                pilhaSize --;
            return resultReturn + "\n";

            case "dup": resultReturn = "Operation: dup";
                memoria.push(memoria.top());
                resultReturn += "\nValue dupped: " + memoria.top();
                pilhaSize ++;
            return resultReturn + "\n";

            case "swap": resultReturn = "Operation: swap";
                a = getDoublePop();
                b = getDoublePop();
                memoria.push(a);
                memoria.push(b);
                resultReturn += "\n" + a + " by " + b;
            return resultReturn + "\n";

            case "chs": resultReturn = "Operation: chs";
                a = getDoublePop();
                resultReturn += "\nvalue: " + a;
                memoria.push(a * -1);
                resultReturn += "\nresult: " + memoria.top();
            return resultReturn + "\n";

            case "sqrt": resultReturn = "Operation: sqrt";
                a = getDoublePop();
                memoria.push(Math.sqrt(a));
                resultReturn += "\nsqrt of: " + a +
                                "\nresult: " + memoria.top();
            return resultReturn + "\n";

            /*
             *  Finaliza a calculadora.
             *  Verifica se a mesma foi finalizada corretamente (há apenas a resposta na pilha)
             *  e retorna a resposta do compile.
             */
            case "last": resultReturn = "\nResult of file "+ app.fileName + " compiled is: ";
                a = getDoublePop();
                if(!memoria.isEmpty()) {
                    resultReturn += "Error, more than one number on calculator memory. [" + a;
                    while (!memoria.isEmpty()){
                        resultReturn += ", " + getDoublePop();
                    }
                    resultReturn += "].";
                }else {
                    resultReturn += a;
                    resultReturn += "\nBiggest size of stack: " + recordSize;
                }
                clear();
            return resultReturn;

            /*
             *  Caso não seja um dos operadores, o valor é validado e apenas inserido na pilha.
             */
            default:
                    pilhaSize ++;
                    memoria.push(Double.parseDouble(value.toString()));
                    return "Value inserted: " + memoria.top() + "\n";
        }

        /*
         * Após a operação ser realizada no switch anterior, o resultado é inserido na pilha.
         * A inserção é inserida fora do switch para que não tenha um push em cada 'case'.
         */
        memoria.push(result);

        resultReturn += "\nResult: " + memoria.top();

        return resultReturn + "\n";
    }

    /*
     *  Método de conveniência.
     *  Tem como função verificar se é possível realizar a operação,
     *  Também já separa os dois últimos valores que serão utilizados.
     */
    private void dropMemoria(){
        if(memoria.size() < 2) {
            clear();
            throw new ArithmeticException("You can not operate without at least two numbers");
        }else{
            a = getDoublePop();
            b = getDoublePop();
            pilhaSize --;
        }
    }

    /*
     *  Limpa a calculadora após toda finalização de arquivo
     *  *na chamada do comando "last"
     */
    private void clear(){
        memoria.clear();
        recordSize = 0;
        pilhaSize = 0;
    }

    /*
     *   Devido à pilha ser genérica problemas de parse apareceram, portanto
     *   o pop da pilha é transformado em string e o valor é convertido para double
     *   Esse método também é o responsável por contar o tamanho máximo alcançado pela
     *   pilha 'mémória' da calculadora.
     */
    private double getDoublePop(){
        if(memoria.isEmpty())
            throw new NullPointerException();
        else
            return Double.parseDouble(memoria.pop().toString());
    }
    private void recordSize(){
        if(pilhaSize > recordSize)
            recordSize = pilhaSize;
    }
}