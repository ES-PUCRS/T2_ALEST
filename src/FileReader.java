import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Path;

public class FileReader {

    public static String scanFile(String filePath){
    String s = "";
        Path path1 = Paths.get(filePath);
            try(Scanner sc=new Scanner(Files.newBufferedReader(path1, Charset.defaultCharset()))){
                sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
                while (sc.hasNext()) {
                    s += sc;
                }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
            return s;
    }

    public static String removeBreakLine(String s){
        s = s.replaceAll("\n", "");
        s = s.replaceAll("\r", "");
        s = s.replaceAll("\t", "");
        
        return s;
    }

    public static String scanWOBL(String filePath){
        return removeBreakLine(scanFile(filePath));
    }
}