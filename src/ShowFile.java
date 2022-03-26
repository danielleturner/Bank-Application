import java.io.*;


public class ShowFile {

    public static void main(String[] args) {


        int i;
        FileInputStream fin = null;

        if(args.length != 1){
            System.out.println("Usage: checkingAccount File");
            return;
        }
        try{
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Usage: checkingAccount File");
        }
        try{
            do{
                i = fin.read();
                if(i != -1){
                    System.out.println((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
        try {
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error closing file");
        }
    }
}
