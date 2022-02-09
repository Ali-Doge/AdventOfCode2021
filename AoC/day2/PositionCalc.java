import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PositionCalc{
    public static void Calc()throws FileNotFoundException{
        int depth = 0;
        int x = 0;
        int aim = 0;
        Scanner scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            int num = Integer.parseInt(String.valueOf(line.charAt(line.length()-1)));
            if (line.startsWith("f")){x += num; depth += aim*num;}
            if (line.startsWith("u")){ aim -= num;}
            if (line.startsWith("d")){ aim += num;}
        }
        System.out.println(x*depth);
    }
    public static void main(String[] args) throws FileNotFoundException{
        Calc();
    } 
}