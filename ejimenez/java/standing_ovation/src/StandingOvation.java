import javax.swing.*;
import java.awt.*;
import java.io.*;

public class StandingOvation {

    /**
     * An empty constructor for this class
     */
    public StandingOvation(){
    }

    /**
     * Evaluate the input to know the minimum number of invited persons for avery case
     * @param file it's the input for our program
     *             the rules for the input are:
     *             1.- The first line of the input gives the number of test cases (T) with the limit 1 <= T <= 100.
     *             2.- T test cases follow.
     *             3.- Each consists of one line with Smax followed by a string of Smax + 1 single digits.
     *             4.- The kth digit of this string (counting starting from 0) represents how many people
     *                 in the audience have shyness level k.
     * @return the number of invited persons for every case
     */
    public String evaluateInput(File file){
        String result = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int t=0; // t = total cases
            if(line != null){
                t = Integer.parseInt(line.trim());
            }
            if(t>=1 && t<=100){ //verify that the input is on the limit of the program
                for(int i=1; i<=t && line != null; i++){
                    line = reader.readLine();
                    String xcase[] = line.split(" ");
                    result+="Case #"+i+": "+evaluateCase(Integer.parseInt(xcase[0]),xcase[1])+"\n";
                }
            }else{ // if t is off the limits then we put an error
                System.out.println("Error: this input exceed the number of test cases accepted");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Converts the string to a integer array
     * @param string the string that contains the digits from our input
     * @return an integer array with the digits in the string
     */
    private int[] convertStringToDigits(String string){
        int digits[] = new int[string.length()];
        try{
            for(int i=0;i<string.length();i++){
                digits[i]=Integer.parseInt(""+string.charAt(i));
            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return digits;
    }

    /**
     * Evaluates a case to
     * @param Smax the maximum shyness level in this case
     * @param stringDigits a string that contains the number of persons with a kth shyness level in this case
     * @return the minimum number of persons who have to be invited in this case
     */
    private String evaluateCase(int Smax, String stringDigits){
        int invited=0,aplauding=0;
        int digits[] = convertStringToDigits(stringDigits);
        if(Smax+1 == digits.length){
            for(int i=0;i<digits.length;i++){
                if(digits[i] > 0){
                    if(aplauding < i){
                        invited += (i-aplauding);
                        aplauding += (i-aplauding);
                    }
                    aplauding += digits[i];
                }
            }
        }
        return ""+invited;
    }

    /**
     * Saves a text file in the folder output inside the source folder of this project
     * @param data the text to be writted in the file
     */
    public void saveFile(String data){
        File savedFile = new File("src/output/result.txt");
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

    /**
     * The main function of this program
     * @param args
     */
    public static void main(String args[]){
        JFileChooser chooser = new JFileChooser("in/");
        int returnVal = chooser.showOpenDialog(new Panel());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            StandingOvation ovation = new StandingOvation();
            String result = ovation.evaluateInput(chooser.getSelectedFile());
            System.out.println(result);
            ovation.saveFile(result);
        }
    }
}
