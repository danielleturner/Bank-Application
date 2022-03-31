package BankApp;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class scratch {



    public static void main(String[] args) throws IOException {

        File file = new File("/Users/danielleturner/IdeaProjects/Bank Application/Checking.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String st;
        int sumOfTextNumber = 0;
        
       try {
           while ((st = br.readLine()) != null){
                sumOfTextNumber += Integer.parseInt(st);
               System.out.println(st);
           }
           System.out.println("The sum of all numbers is: " + sumOfTextNumber);
       }catch (IOException e){
           System.out.println("Ooops something went wrong");
       }

    }
}
