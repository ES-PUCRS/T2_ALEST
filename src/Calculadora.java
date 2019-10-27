public class Calculadora {
    private Pilha memoria;
    private int pilhaSize;
    private int recordSize;
    double a = 0, b = 0;


    public Calculadora(){
        memoria = new Pilha();
        pilhaSize = 0;
    }

    public String command(String value) {
        String resultReturn = "";
        double result = 0.0;
        recordSize();

        switch (value) {
            case "+": resultReturn = "Operation: +";
                    dropMemoria();
                    result = a + b;
                    resultReturn += "\nvalue: " + a+
                                    "\nvalue: " + b;
                break;

            case "-": resultReturn = "Operation: -";
                    dropMemoria();
                    result = a - b;
                break;

            case "*": resultReturn = "Operation: *";
                    dropMemoria();
                    result = a * b;
                break;

            case "/": resultReturn = "Operation: /";
                    dropMemoria();
                    result = a / b;
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
                System.out.println("value: " + a);
                memoria.push(a * -1);
                resultReturn += "\nresult: " + memoria.top();
            return resultReturn + "\n";

            case "sqrt": resultReturn = "Operation: sqrt";
                a = getDoublePop();
                memoria.push(Math.sqrt(a));
                resultReturn += "\nsqrt of: " + a +
                                "\nresult: " + memoria.top();
            return resultReturn + "\n";


            case "last": resultReturn = "\nResult of file compile: "+ app.fileName + " é: ";
                a = getDoublePop();
                if(!memoria.isEmpty()) {
                    resultReturn += "Error, more than one number on calculator memory. [" + a;
                    while (!memoria.isEmpty()){
                        resultReturn += ", " + getDoublePop();
                    }
                    resultReturn += "].";
                }else {
                    resultReturn += a;
                    resultReturn += "\nTamanho máximo da pilha é: " + recordSize;
                }
            return resultReturn;


            default:
                    pilhaSize ++;
                    memoria.push(Double.parseDouble(value.toString()));
                    return "Value inserted: " + memoria.top() + "\n";
        }

        memoria.push(result);
        resultReturn += "\nResult: " + memoria.top();

        return resultReturn + "\n";
    }

    private void dropMemoria(){
        if(memoria.size() < 2) {
            throw new ArithmeticException("You can not operate without at least two numbers");
        }else{
            a = getDoublePop();
            System.out.println(a + " popped");

            b = getDoublePop();
            System.out.println(b + " popped");

            pilhaSize --;
        }
    }

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