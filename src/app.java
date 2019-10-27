import java.io.FileNotFoundException;

public class app {

    public static final String fileName = "exemplo3.txt";

    public static void main(String args[]) throws FileNotFoundException {
        Pilha file = FileManager.load(fileName);
        Calculadora calculadora = new Calculadora();

        while(!file.isEmpty()) {
            try {
                System.out.println(calculadora.command("" + file.pop()));
            } catch (Exception e) {
                System.out.println("\n\n" + e.getMessage());
                System.exit(0);
            }
        }

        System.out.println(calculadora.command("last"));
    }
}