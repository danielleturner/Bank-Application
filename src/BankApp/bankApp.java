package BankApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;


public class bankApp extends Account {


    DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

    public bankApp(double savingsBalance, double checkingBalance) {
        super(savingsBalance, checkingBalance);
    }


    public static void displayMenu() throws IOException {

        int x = 1;
        do {
        Scanner input = new Scanner(System.in);

        System.out.println("Thank you for logging in what would you like to do?\n" +
                "\n" +
                "0 - exit\n" +
                "1 - Checking Balance\n" +
                "2 - Savings Balance\n" +
//                "3 - Deposit\n" +
//                "4 - Withdraw\n" +
                "\n" +
                "Enter your choice: ");

        int response = input.nextInt();
//        System.out.println(response);

        if (response == 0){
            exitOption();
        }else if(response == 1){
            checkingBalance();
        }else if(response == 2){
            savingsBalance();
        }else if(response == 3){
            depositChecking();
        }else if(response == 4){
            withdrawFunds();
        }else{
            System.out.println("You entered a invalid choice '\n' Please try again later");
            exitOption();
            x = 2;
        }
        }while (x == 1);
    }


    public static void exitOption() {
        System.out.println("Thank you for visiting have a nice day!");

    }


    public static void checkingBalance() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");
        Scanner scanner = new Scanner(System.in);

            System.out.println("Would you like to view your account balance? [y/N]");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Checking.txt"));
                    writer.write("CheckingAccountBalance: 0");
                    writer.close();
                    BufferedReader reader = new BufferedReader(new FileReader("/Users/danielleturner/IdeaProjects/Bank Application/Checking.txt"));
                    System.out.println(reader.readLine());
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Oops Something went wrong");
                }
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                System.out.println();
            }

        System.out.println("Would you like to add funds to your Checking Account? [y/N]");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y") ||  answer.equalsIgnoreCase("yes")) {
            depositChecking();
        }else if(answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")){
            System.out.println("Would you like to log out?\n" +
                    "\n" +
                    "0 - exit\n" +
                    "1 - Checking Balance\n" +
                    "2 - Savings Balance\n" +
                    "3 - Deposit\n" +
                    "4 - Withdraw\n" +
                    "Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 0){
                exitOption();
            }else if(choice == 1){
                checkingBalance();
            }else if(choice == 2){
                savingsBalance();
            }else if(choice == 3){
                depositChecking();
            }else if(choice == 4){
                withdrawFunds();
            }else{
                System.out.println("You entered a invalid choice");
                exitOption();
            }
        }

    }


    public static void savingsBalance() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to view your account balance? [y/N]");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Savings.txt"));
                writer.write("SavingsAccountBalance: 0");
                writer.close();
                BufferedReader reader = new BufferedReader(new FileReader("/Users/danielleturner/IdeaProjects/Bank Application/Checking.txt"));
                System.out.println(reader.readLine());
                reader.close();

                Scanner input = new Scanner(System.in);

                FileReader writer1 = new FileReader("Savings.txt");

                System.out.print("How much would you like to deposit? ");
                double option = input.nextDouble();

                System.out.print("You deposited " + option + writer1);


                System.out.println("Would you like to make another deposit? [y/N");
                String answer = input.next();

                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("Yes")) {
                    System.out.println("How much would you like to deposit? ");
                    double response2 = input.nextDouble();
                    System.out.printf("You deposited %.2f \n ", response2);

                } else if (answer.equalsIgnoreCase("N") || answer.equalsIgnoreCase("no")) {
                    System.out.printf("Your balance is %.2f", option);

                }
                checkingBalance();
                displayMenu();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Oops Something went wrong");
            }
        } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
            System.out.println("Have a nice day.");
            exitOption();
        }

    }

    public static void depositChecking() throws IOException {


        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

        System.out.println("How much would you like to deposit? ");

        Scanner input = new Scanner(System.in);

        double deposit = input.nextDouble();

        System.out.println("You deposited: " +  dollarFormat.format(deposit));



    }



    public static void depositSavings() throws FileNotFoundException{

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

        Scanner input = new Scanner(System.in);

        FileReader writer1 = new FileReader("Checking.txt");

        System.out.println("How much would you like to deposit? ");
    }

    public static void withdrawFunds(){

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

    }


    public static void main(String[] args) throws IOException {

        displayMenu();

    }


}


