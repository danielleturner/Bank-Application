package BankApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.nio.CharBuffer;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
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
                    "3 - Deposit\n" +
                    "4 - Withdraw\n" +
                    "\n" +
                    "Enter your choice: ");

            int response = input.nextInt();

            if (response == 0) {
                x = 2;
            } else if (response == 1) {
                checkingBalance();
            } else if (response == 2) {
                savingsBalance();
            } else if (response == 3) {
                depositChecking();
            } else if (response == 4) {
                withdrawFunds();
            } else {
                System.out.println("You entered a invalid choice '\n' Please try again later");
                exitOption();
                x = 3;
            }
        } while (x == 1);

    }


    public static void exitOption() {
        System.out.println("Thank you for visiting have a nice day!");


    }


    public static void checkingBalance() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");
        int x = 1;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Would you like to view your account balance? [y/N]");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("YES")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Checking.txt"));
                    System.out.println("Your balance is: $" + reader.readLine()); // this line reads the balance from the text file
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Oops Something went wrong");
                    x = 2;
                }
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                displayMenu();
            } else {
                System.out.println("Please enter a valid response");
                checkingBalance();
            }

            System.out.println("Would you like to add funds to your Checking Account? [y/N]");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                depositChecking();
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                System.out.println("You are being redirected to the main menu");
                displayMenu();
                System.out.println();
            } else {
                System.out.println("Please enter a valid response");
                checkingBalance();
            }
        } while (x == 1);
        exitOption();
    }


    /**
     * DEPOSIT CHECKING BELOW
     **/
    public static void depositChecking() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

        int x = 1;
        do {     // Reading text.file//

            String st;
            double sumofTextNumbers = 0;


            try {

                BufferedReader writer = new BufferedReader(new FileReader("Checking.txt"));
                writer.close();
                System.out.println("How much would you like to deposit to your checking account? ");
                Scanner input = new Scanner(System.in);
                double deposit = input.nextDouble();
                System.out.println("You deposited: " + dollarFormat.format(deposit));

                try {
                    File file = new File("Checking.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file)); //Preparing file for reading
                    // going through lines that are being read

                    while ((st = br.readLine()) != null) {
                        sumofTextNumbers += Integer.parseInt(st);

                        System.out.println("Your new balance is: " + dollarFormat.format(sumofTextNumbers + deposit));
                        double newbalance = sumofTextNumbers + deposit;
                        System.out.println(newbalance);
                        FileWriter depositWriter = new FileWriter("Checking.txt");
//                        double changeBalance = newbalance;
//                        newbalance += Integer.parseInt(st);
                        depositWriter.write(String.valueOf(newbalance)); // casting the double balance into an int so that it can be written into the text fil
//                        depositWriter.close();


//                        FileWriter changeNumber = new FileWriter("Checking.txt");
//                        changeNumber.write(String.valueOf(changeBalance));
                        System.out.println("Success");
                    }

                } catch (NumberFormatException e) {
                    BufferedReader writer1 = new BufferedReader(new FileReader("Checking.txt"));
                    writer1.readLine();
                    writer.close();
                    System.out.println("Oops something went wrong");
                }

                System.out.println("Would you like to make another deposit? [y/N]");
                String nextdeposit = input.next();

                if (nextdeposit.equalsIgnoreCase("y") || nextdeposit.equalsIgnoreCase("Y")) {
                    depositChecking();
                } else if (nextdeposit.equalsIgnoreCase("n") || nextdeposit.equalsIgnoreCase("N")) {
                    System.out.println();
                    displayMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number value");
                x = 2;
                depositSavings();
            }
        } while (x == 1);
    }

    /**
     * SAVINGS BALANCE BELLOW
     **/
    public static void savingsBalance() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");
        int x = 1;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Would you like to view your Savings account balance? [y/N]");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Savings.txt"));
                    System.out.println("Your balance is: $" + reader.readLine()); // this line reads the balance from the text file
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Oops Something went wrong");
                    x = 2;
                    savingsBalance();
                }
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                exitOption();
                x = 2;
                return;
            }

            System.out.println("Would you like to add funds to your Savings Account? [y/N]");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                x = 2;
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                System.out.println("You are being redirected to the main menu");
                displayMenu();
                x = 2;
                System.out.println();
            }
        } while (x == 1);
        exitOption();


    }

    /**
     * DEPOSIT SAVINGS BELOW
     **/
    public static void depositSavings() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

        String st;
        double sumofTextNumbers = 0;
        int x = 1;
        do {     // Reading text.file//
            BufferedReader writer = new BufferedReader(new FileReader("Savings.txt"));
            writer.close();
            try {
                System.out.println("How much would you like to deposit to your savings account? ");
                Scanner input = new Scanner(System.in);
                double deposit = input.nextDouble();
                System.out.println("You deposited: " + dollarFormat.format(deposit));

                File file = new File("Savings.txt");
                BufferedReader br = new BufferedReader(new FileReader(file)); //Preparing file for reading
                // going through lines that are being read
                try {
                    while ((st = br.readLine()) != null) {
                        sumofTextNumbers += Integer.parseInt(st);

                        System.out.println("Your new balance is: " + dollarFormat.format(sumofTextNumbers + deposit));
                        double newbalance = sumofTextNumbers + deposit;
                        FileWriter depositWriter = new FileWriter("Savings.txt");
                        depositWriter.write(String.valueOf(newbalance)); // casting the double balance into an int so that it can be written into the text fil
                        depositWriter.close();
                        System.out.println("Success");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Oops something went wrong");
                }

                System.out.println("Would you like to make another deposit? [y/N]");
                String nextdeposit = input.next();

                if (nextdeposit.equalsIgnoreCase("y") || nextdeposit.equalsIgnoreCase("Y")) {
                    depositSavings();
                } else if (nextdeposit.equalsIgnoreCase("n") || nextdeposit.equalsIgnoreCase("N")) {
                    displayMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number value");
                x = 2;
                depositSavings();
            }
        } while (x == 1);
    }

    public static void withdrawFunds() {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

    }


    public static void main(String[] args) throws IOException {

        displayMenu();

    }


}


