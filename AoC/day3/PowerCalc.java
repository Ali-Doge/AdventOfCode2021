package day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PowerCalc{
    public static void Calc()throws FileNotFoundException{
        int[] gamma = new int[12];
        int gam = 0;
        int[] epsi = new int[12];
        int eps = 0;
        int i = 0;
        Scanner scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()){
            i++;
            String line = scan.nextLine();
            for (int j = 0; j<12; j++){
                gamma[j] += Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        for (int j = 0; j<12; j++){
            if (gamma[j] > i/2){
                gamma[j] = 1;
                epsi[j] = 0;
            }
            else {
                gamma[j] = 0;
                epsi[j] = 1;
            }
            gam += gamma[j] * 2^j;
        }
        System.out.println(gam * (2^12 - 1 -gam));
    }    

    public static void main(String[] args) throws FileNotFoundException{
        Calc();
    } 
}