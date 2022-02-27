package day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PowerCalc{
    public static void Calc()throws FileNotFoundException{
        int lenght = 12;
        int[] gamma = new int[lenght];
        int gam = 0;
        int[] epsi = new int[lenght];
        int eps = 0;
        int i = 0;
        ArrayList<String> strings = new ArrayList<>();

        Scanner scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()){
            i++;
            String line = scan.nextLine();
            strings.add(line);
            for (int j = lenght-1; j>=0; j--){
                gamma[j] += Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        for (int j = 0; j<lenght; j++){
            if (gamma[j] > i/2){
                gamma[j] = 1;
                epsi[j] = 0;
            }
            else {
                gamma[j] = 0;
                epsi[j] = 1;
            }
            gam += gamma[j] * Math.pow(2,lenght-1-j);
            eps += epsi[j] * Math.pow(2,lenght-1-j);
        }
        System.out.println(gam * eps);
        int OGen = mostCommonFinder(strings, 0);
        int CO2 = leastCommonFinder(strings, 0);
        System.out.println(OGen * CO2);
    }  
    
    public static int mostCommonFinder(ArrayList<String> search, int bit){
        ArrayList<String> ones = new ArrayList<>();
        ArrayList<String> zeros = new ArrayList<>();
        if (search.size() == 1){
            return Integer.parseInt(search.get(0),2);
        }
        for (String element : search){
            if (element.charAt(bit) == '1'){
                ones.add(element);
            }else{
                zeros.add(element);
            }
        }
        if (ones.size() == zeros.size()){
            return mostCommonFinder(ones, bit+1);
        }
        if (ones.size() > (double) search.size()/2){
            return mostCommonFinder(ones, bit+1);
        }else{
            return mostCommonFinder(zeros, bit+1);
        }
    }

    public static int leastCommonFinder(ArrayList<String> search, int bit){
        ArrayList<String> ones = new ArrayList<>();
        ArrayList<String> zeros = new ArrayList<>();
        if (search.size() == 1){
            return Integer.parseInt(search.get(0),2);
        }
        for (String element : search){
            if (element.charAt(bit) == '1'){
                ones.add(element);
            }else{
                zeros.add(element);
            }
        }
        if (ones.size() == zeros.size()){
            return leastCommonFinder(zeros, bit+1);
        }
        if (ones.size() < (double) search.size()/2){
            return leastCommonFinder(ones, bit+1);
        }else{
            return leastCommonFinder(zeros, bit+1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        Calc();
    } 
}