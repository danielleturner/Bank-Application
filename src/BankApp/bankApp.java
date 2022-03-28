package BankApp;

import java.io.*;
import java.util.Scanner;


public class bankApp extends Account {


    public bankApp(String name, double balance) {
        super(name, balance);
    }

    public static void runProgram() throws IOException {


    }


    public static void displayMenu() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Thank you for logging in what would you like to do??\n" +
                "\n" +
                "0 - exit\n" +
                "1 - Check Balance\n" +
                "2 - Deposit\n" +
                "3 - Withdraw\n" +
                "4 - Previous Transactions\n" +
                "  \n" +
                "Enter your choice: ");

        int response = input.nextInt();
//        System.out.println(response);

        if (response == 0){
            exitOption();
        }else if (response == 1){
            checkBalance();
        }else if (response == 2) {
            optionTwo();
        }
    }


    public static void exitOption(){
        System.out.println("Thank you for visiting have a nice day!");
    }




    public static Object checkBalance() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("src/data/checkingAccount.txt"));
        String line = in.readLine();
        while(line != null)
        {
            System.out.print("Your balance is: " + line);
            line = in.readLine();

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nWould you like to continue? [y/N]");
            String response = scanner.nextLine();
            if(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")){
                displayMenu();
            }else if(response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")){
                System.out.println();
            }
        }
        in.close();
        exitOption();

        return checkBalance();
    }




    public static void optionTwo() throws IOException{

        Scanner input = new Scanner(System.in);

//        FileReader file = new FileReader("src/data/checkingAccount.txt");
//        BufferedReader bf = new BufferedReader(file);
//
//        String st = bf.readLine();


        double accountBalance = 0;
        double newdeposit = 0;
        double newBalance = accountBalance + newdeposit;
        FileReader i =  new FileReader("src/data/checkingAccount.txt");




        System.out.printf("Your current balance is: %s \n", checkBalance());
        System.out.print("How much would you like to deposit? ");
        double option = input.nextDouble();

        System.out.printf("You deposited %.2f \n", option);


        System.out.println("Would you like to make another deposit? [y/N");
        String answer = input.next();


        if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("Yes")){
            System.out.println("How much would you like to deposit? ");
            double response2 = input.nextDouble();
            System.out.printf("You deposited %.2f \n Your total balance is: %.2f\n", response2);
        }else if(answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("no")){
            System.out.printf("Your balance is %.2f", option);




//                String str;
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                System.out.println(" Enter text ('stop' to quit).");
//
//                try(DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("src/data/checkingAccount.txt"))){
//                    System.out.println("writing: " + answer);
//                    dataOut.writeDouble(Integer.parseInt(answer + checkBalance()));
//                }catch (IOException exc){
//                    System.out.println("Writing error.");
//                    return;
//                }
//                System.out.println();



//                try (FileWriter fw = new FileWriter("checkingAccount", true))
//                {
//                    do{
//                        System.out.print(": ");
//                        str = br.readLine();
//
//                        if(str.compareTo("stop") == 0) break;
//
//                        str = str + "\r\n"; // add New Line
//                        fw.write(str);
//                    }while(str.compareTo("stop") != 0);
//                }catch(IOException exc){
//                    System.out.println("I/O Error: " + exc);
//                }


//                try {
//
//                    writer.write((int) option );
//                    writer.write("\r\n");   // write new line
//                    writer.write((int) ( + accountBalance));
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }else{
//                System.out.println();
//
            }
            checkBalance();
            displayMenu();
    }


    public static void main(String[] args)throws IOException {

        ;



        displayMenu();
//        optionTwo();
    }


}


