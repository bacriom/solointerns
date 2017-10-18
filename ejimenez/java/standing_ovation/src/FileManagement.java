import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    /**
     * Saves a text file in the folder output inside the source folder of this project
     * @param data the text to be writted in the file
     * @param fileName the path (including the name) for the file to be created
     */
    public static void saveFile(String data, String fileName){
        File savedFile = new File(fileName);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(savedFile));
            PrintWriter printer = new PrintWriter(bw);
            printer.print(data);
            printer.close();
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> readFile(File file){
        ArrayList<String> lines = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line=reader.readLine()) != null){
                lines.add(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
