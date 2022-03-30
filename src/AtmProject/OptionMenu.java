package AtmProject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {

    Scanner menuInput = new Scanner(System.in);
    //Here I set parameters for how all monetary values will be entered and printed out
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,###.##");

    // this is to add customer number and pin number
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();


    public OptionMenu(int customerNumber) {
        super(customerNumber);
    }

    // I had to make an overload method in order to instantiate a new method to run the program in the (java.atm)
    public OptionMenu() {
        super();
    }

    public void getLogin() throws IOException{
        int x = 1; // do while loop set to one
        do{
            try{  // customer number, pin number(HashMap)
                data.put(12345, 54321);
                data.put(6789, 9876);


                System.out.println("Thank you for logging back in.\n" +
                        "Please re-enter your account number for verification: \n" +
                        "\n");

                setCustomerNumber(menuInput.nextInt());

                System.out.println("Please enter your pin number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e){
                System.out.println("\n" + "Invalid Character(s). Only numbers are accepted." + "\n");
                x = 2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if (data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            }else{
                System.out.println("\n " + "Wrong Customer Number or Wrong Pin Number" + "\n");
            }
        } while (x == 1);

    }

    public void getAccountType(){

        System.out.println();
        System.out.println("Thank you for logging in what would you like to do?\n" +
                "\n" +
                "1 - View Checking Account\n" +
                "2 - View Savings Account\n" +
                "3 - Exit\n" +
                "  \n" +
                "Enter your choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for banking with us hava a great day");
                break;
            default:
                System.out.println("\n" + "Please enter a number between 1 and 3" + "\n");
                getAccountType();
        }
    }

    public void getChecking(){

        System.out.println();
        System.out.println("Great choice, here are your options for your checking account. How would you like to proceed?\n" +
                "\n" +
                "1 - View Balance\n" +
                "2 - Withdraw Funds\n" +
                "3 - Deposit Funds\n" +
                "4 - Exit\n" +
                "  \n" +
                "Enter your choice: ");

        int selection = menuInput.nextInt();

        System.out.println();

            if(selection != 1 && selection != 2 && selection != 3 && selection != 4){
                System.out.println("Please enter a number between 1 and 4");
                getChecking();
            }


        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getChecking();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("thank you for banking with us have a great day");
                break;
            default:
                System.out.println("\n" + "Please enter a number between 1 and 3" + "\n");
                getChecking();

        }
    }

    public void getSaving(){

        System.out.println();
        System.out.println("Great, here are your options for your Savings account. How would you like to proceed?\n" +
                "\n" +
                "1 - View Balance\n" +
                "2 - Withdraw Funds\n" +
                "3 - Deposit Funds\n" +
                "4 - Exit\n" +
                "  \n" +
                "Enter your choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                break;
            case 2:
                getsavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            default:
                System.out.println("\n" + "Please enter a number between 1 and 3" + "\n");
                getAccountType();
        }
    }
}
