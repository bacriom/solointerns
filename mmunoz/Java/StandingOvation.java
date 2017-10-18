/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standingovation;
import java.util.Scanner;
/**
 *
 * @author migue
 */
public class StandingOvation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese casos a analizar:");
	int t= sc.nextInt();
	for(int i = 1; i <= t; i++){
            System.out.println("Ingrese el número de 'pena' máximo:");
            int sMax = sc.nextInt();
            System.out.println("Ingrese la cadena de personas con nivel de pena de 0 a " + sMax + ":");
            String readString = sc.next();
            int clapping= 0;
            int additional= 0;
            for(int j = 0; j <= sMax; j++){
                int numRead= Integer.parseInt(readString.substring(j, j+1));
                if(numRead>0){
                    if(clapping<j){
                        additional+= j-clapping;
                        clapping= j;
                    }
                    clapping+= numRead;
                }
            }
            System.out.print("Caso #" + i + ": Debe invitar a " + additional + " amigos.\n");
	}	
	sc.close();
    }
}
