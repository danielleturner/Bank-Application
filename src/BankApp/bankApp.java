package BankApp;
import java.io.FileOutputStream;
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
                deposit();
            } else if (response == 4) {
                withdrawFunds();
            } else {
                System.out.println("You entered a invalid choice '\n' Please try again later");

            }
        } while (x == 1);
        exitOption();


    }


    public static void exitOption() {
        System.out.println("Thank you for visiting have a nice day!");
    }


    public static void checkingBalance() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.00");
        int x = 1;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Would you like to view your account balance? [y/N]");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("YES")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Checking.txt"));
                    System.out.println("Your balance is: $ " + reader.readLine()); // this line reads the balance from the text file
                    reader.close();

                    System.out.println("Would you like to add funds to your Checking Account? [y/N]");
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                        depositChecking();
                    } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                        System.out.println("You are being redirected to the main menu");
                        x = 3;
                    } else {
                        System.out.println("Please enter a valid response");
                        checkingBalance();
                    }
                } catch (IOException e) {
                    System.out.println("Oops Something went wrong");
                }
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                x = 2;
            } else {
                System.out.println("Please enter a valid response");
            }

        } while (x == 1);
        exitOption();
    }


    /**
     * DEPOSIT CHECKING BELOW
     **/
    public static void depositChecking() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.00");

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
                BufferedReader writer1 = new BufferedReader(new FileReader("Checking.txt"));
                writer1.readLine();
                writer.close();

                try {
                    File file = new File("Checking.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file)); //Preparing file for reading
                    // going through lines that are being read

                    while ((st = br.readLine()) != null) {
                        sumofTextNumbers += Double.parseDouble(st);

                        System.out.println("Your new balance is: " + dollarFormat.format(sumofTextNumbers + deposit));
                        double newbalance = sumofTextNumbers + deposit;
//                        System.out.println(newbalance);
                        FileWriter depositWriter = new FileWriter("Checking.txt");
                        depositWriter.write(new String (String.valueOf(newbalance)));
                        newbalance = Double.parseDouble(st);
                        depositWriter.close();
                        System.out.println("Success");

                        System.out.println("Would you like to make another deposit? [y/N]");
                        String nextdeposit = input.next();

                        if (nextdeposit.equalsIgnoreCase("y") || nextdeposit.equalsIgnoreCase("Y")) {
                            depositChecking();
                        } else if (nextdeposit.equalsIgnoreCase("n") || nextdeposit.equalsIgnoreCase("N")) {
                            x = 3;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Oops something went wrong");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number value");
                x = 2;
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

                System.out.println("Would you like to add funds to your Savings Account? [y/N]");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    depositSavings();
                } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                    System.out.println("You are being redirected to the main menu");
                    displayMenu();;
                }
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                x = 2;
            }
        } while (x == 1);
    }

    /**
     * DEPOSIT SAVINGS BELOW
     **/
    public static void depositSavings() throws IOException {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

        int x = 1;
        do {     // Reading text.file//

            String st;
            double sumofTextNumbers = 0;

            try {

                BufferedReader writer = new BufferedReader(new FileReader("Savings.txt"));
                writer.close();
                System.out.println("How much would you like to deposit to your savings account? ");
                Scanner input = new Scanner(System.in);
                double deposit = input.nextDouble();

                System.out.println("You deposited: " + dollarFormat.format(deposit));
                BufferedReader writer1 = new BufferedReader(new FileReader("Savings.txt"));
                writer1.readLine();
                writer.close();

                try {
                    File file = new File("Savings.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file)); //Preparing file for reading
                    // going through lines that are being read

                    while ((st = br.readLine()) != null) {
                        sumofTextNumbers += Double.parseDouble(st);

                        System.out.println("Your new balance is: " + dollarFormat.format(sumofTextNumbers + deposit));
                        double newbalance = sumofTextNumbers + deposit;
//                        System.out.println(newbalance);
                        FileWriter depositWriter = new FileWriter("Savings.txt");
                        depositWriter.write(new String (String.valueOf(newbalance)));
                        newbalance = Double.parseDouble(st);
                        depositWriter.close();
                        System.out.println("Success");


                        System.out.println("Would you like to make another deposit? [y/N]");
                        String nextdeposit = input.next();

                        if (nextdeposit.equalsIgnoreCase("y") || nextdeposit.equalsIgnoreCase("Y")) {
                            depositSavings();
                        } else if (nextdeposit.equalsIgnoreCase("n") || nextdeposit.equalsIgnoreCase("N")) {
                            x = 3;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Oops something went wrong");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number value");
                x = 2;
            }
        } while (x == 1);
    }

    public static void withdrawFunds() {

        DecimalFormat dollarFormat = new DecimalFormat("'$'###,###.##");

        System.out.println("Which account would you like to withdraw funds from? [1]-Checking OR [2]-Savings ");
        Scanner input = new Scanner(System.in);
        int response = input.nextInt();
//        System.out.println(response);
        if(response == 1){

            int x = 1;
            do {     // Reading text.file//

                String st;
                double sumofTextNumbers = 0;

                try {

                    BufferedReader writer = new BufferedReader(new FileReader("Checking.txt"));
                    writer.close();
                    System.out.println("How much would you like to withdraw from your checking account? ");
                    Scanner inputA = new Scanner(System.in);
                    double withdrawl = input.nextDouble();

                    System.out.println("You are about to withdraw: " + dollarFormat.format(withdrawl));
                    BufferedReader writer1 = new BufferedReader(new FileReader("Checking.txt"));
                    writer1.readLine();
                    writer.close();

                    try {
                        File file = new File("Checking.txt");
                        BufferedReader br = new BufferedReader(new FileReader(file)); //Preparing file for reading
                        // going through lines that are being read

                        while ((st = br.readLine()) != null) {
                            sumofTextNumbers += Double.parseDouble(st);

                            if(withdrawl > sumofTextNumbers){
                                System.out.println("You cant over draw");
                                x = 2;
                            }else {

                                System.out.println("Your new balance is: " + dollarFormat.format(sumofTextNumbers - withdrawl));
                                double newbalance = sumofTextNumbers - withdrawl;
                                System.out.println(newbalance);
                                FileWriter depositWriter = new FileWriter("Checking.txt");
                                depositWriter.write(new String (String.valueOf(newbalance)));
                                newbalance = Double.parseDouble(st);
                                depositWriter.close();
                                System.out.println("Success");

                                System.out.println("Would you like to make another withdrawal? [y/N]");
                                String nextwithdrawl = input.next();
                                if (nextwithdrawl.equalsIgnoreCase("y") || nextwithdrawl.equalsIgnoreCase("Y")) {
                                    depositChecking();
                                } else if (nextwithdrawl.equalsIgnoreCase("n") || nextwithdrawl.equalsIgnoreCase("N")) {
                                    x = 3;
                                }else{
                                    if( nextwithdrawl.isBlank()){
                                        System.out.println("You cant withdraw negative amount");
                                    }
                                }
                            }

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Oops something went wrong");
                    }
                } catch (InputMismatchException | IOException e) {
                    System.out.println("Please enter a number value");
                    x = 2;
                }
            } while (x == 1);

        }else if(response == 2){

        }else{
            System.out.println("Please enter a valid input");
            withdrawFunds();
        }

    }

    public static void deposit() throws IOException {

        System.out.println("Which account would you like to add funds to? [1]-Checking OR [2]-Savings ");

        Scanner input = new Scanner(System.in);

        int response = input.nextInt();

        if(response == 1){
            depositChecking();
        }else if(response == 2){
            depositSavings();
        }else{
            System.out.println("Please enter a valid input");
        }
    }



    public static void main(String[] args) throws IOException {

        displayMenu();

    }


}


