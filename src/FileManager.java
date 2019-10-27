import java.io.File;
import java.lang.String;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileManager {

    public static Pilha load(String file)throws FileNotFoundException {
        File filepath = new File("/home/cley/Desktop/ALEST/T2_ALEST/resources/" + file);
        Scanner data = new Scanner(filepath);
        Pilha duracell = new Pilha();
        Pilha raiovac = new Pilha();

        while(data.hasNext()){
            duracell.push(data.nextLine());
        }

        while(!duracell.isEmpty()) {
            raiovac.push(duracell.pop());
        }

        return raiovac;
    }
}