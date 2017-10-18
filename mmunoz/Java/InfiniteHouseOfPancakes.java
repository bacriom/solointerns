/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitehouseogpancakes;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author migue
 */
public class InfiniteHouseOfPancakes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el numero de pruebas:");
        int t= Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; i++) {
            //Declaración de variables para cada test
            ArrayList<Integer> served= new ArrayList();
            
            System.out.println("Ingrese el número de clientes con platos servidos:");
            int d= Integer.parseInt(sc.nextLine());
            
            System.out.println("Ingrese el número de pancakes para cada cliente, separando con un espacio cadaplato\n"
                    + "Ejmplo: 2 3 1\n Considere que solo se añadira hasa el elemento #" + d + " encontrado");
            String dPan= sc.nextLine();
            
            int valMax= 0, cantMax= 0, mins= 0;
            boolean c= false;
            int[] values= {0, 0};
            
            //Inputs de pancakes para cada cliente
            try {
                for (String strServ : dPan.split(" ")){
                if (served.size()<d)
                    served.add(Integer.valueOf(strServ));
                else break;
            }
            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error de: " + e);
            }
            
            d= served.size();
            served= sort(served);
            values= updateList(served, d);
            valMax= values[0];
            cantMax= values[1];
            mins= cantMax;
            while ((valMax/2)+(valMax%2)+mins <= valMax) {
                
                for (int j = 0; j < cantMax; j++) {
                    served.remove(served.size()-1);
                }
                for (int j = 0; j < cantMax; j++) {
                    served.add(valMax/2);
                    served.add(valMax/2+(valMax%2));
                }
                d= served.size();
                served= sort(served);
                values= updateList(served, d);
                valMax= values[0];
                cantMax= values[1];
                mins+= cantMax;
                c= true;
            }
            if(c)
                mins+= valMax-cantMax;
            else
                mins= valMax;
            System.out.println("Caso #" + t + " tarda: " + mins + " minutos.");
            
        }
    sc.close();
    }
    
    public static ArrayList<Integer> sort(ArrayList served){
        Collections.sort(served);
        return served;
    }
    
    public static int[] updateList(ArrayList<Integer> served, int d){
        int valMax= 0, cantMax= 0;
        valMax= served.get(d-1);
            for (int j = served.size(); j > 0; j--) {
                if(valMax == served.get(j-1)){
                    cantMax++;
                }
            }
            int[] ret= {valMax, cantMax};
            return ret;
    }
    
}
