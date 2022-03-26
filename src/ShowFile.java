import java.io.*;


public class ShowFile {

    public static void main(String[] args) {


        int chekcingAccount;
        FileInputStream fin = null;



        if(args.length != 1){
            System.out.println("Usage: ShoeFile src/data/checkingAccount.txt");
            return;
        }

        try{
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Usage: src/data/checkingAccount.txt");
        }
        try{
            do{
                chekcingAccount = fin.read();
                if(chekcingAccount != -1){
                    System.out.println((char) chekcingAccount);
                }
            } while (chekcingAccount != -1);
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
