import java.io.FileNotFoundException;

public class app {

    public static final String extension = ".txt";
    public static String fileName = "";

    public static void main(String args[]) throws FileNotFoundException {
        Calculadora calculator = new Calculadora();
        Pilha file;

        for(int i = 1; i < 5; i++) {
            fileName = "exemplo" + i;

            file = FileManager.load(fileName + extension);

            run(calculator, file, false);

            System.out.println(calculator.command("last"));
        }

//        fileName = "teste";
//        file = FileManager.load(fileName + extension);
//        run(calculator, file, true);
//        System.out.println(calculator.command("last"));
    }

    public static void run(Calculadora calculadora, Pilha file, Boolean log){
        while(!file.isEmpty()) {
            try {
                if(log)
                    System.out.println(calculadora.command("" + file.pop()));
                else
                    calculadora.command("" + file.pop());
            } catch (Exception e) {
                System.out.println("\n\n" + e.getMessage());
                System.exit(0);
            }
        }
    }
}