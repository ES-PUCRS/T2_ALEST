import java.io.FileNotFoundException;
import java.nio.file.Paths; 
import java.util.Scanner;
import java.lang.String;
import java.io.File;

public class FileManager {

    public static Pilha load(String file)throws FileNotFoundException {
        String path = Paths.get("").toAbsolutePath().toString();
        path = path.replaceAll("src", "");
        char separator = path.charAt(path.length()-1);
        path = path + "resources" + separator;
        
        File filepath = new File(path + file);
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