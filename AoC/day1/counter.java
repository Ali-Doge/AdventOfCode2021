import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class counter{
    public static void counter1() throws FileNotFoundException{
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scan = new Scanner(new File("input.txt"));
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            int num = Integer.parseInt(line);
            
            list.add(num);
            if (list.size() == 1) {
                ;
            }
            else if (num > list.get(list.size()-2)){
                count++;
            }
        }
        System.out.println(count);
    }

    
    public static void main(String[] args) throws FileNotFoundException{
        counter1();
    } 
}