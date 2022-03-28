package AtmProject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public OptionMenu(int customerNumber) {
        super(customerNumber);
    }

    public OptionMenu() {
        super();
    }

    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{         // customer number, pin number
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("Welcome to the your bank");
                System.out.println("Enter you customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Please enter your pin: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e){
                System.out.println("\n" + "Invalid Character(s). Only numbers are accepted." + "\n");
                x = 2;
            }
            /*
            * for(Map.Entry<Integer, Integer> it : data.entrySet()) {
            * if(it.getkey() == getCustomerNumber() && it.getValue() == getPinNumber}{
            * getAccountType();}}*/

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
        System.out.println("Select the Account you wish to access: ");
        System.out.println(" Type 1 - Checking Account");
        System.out.println(" Type 2 - Savings Account");
        System.out.println(" type 3 - Exit");

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
        System.out.println("Checking Account: ");
        System.out.println("type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit");
        System.out.println("Type 4 Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
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
                getAccountType();

        }
    }

    public void getSaving(){
        System.out.println("Savings Account: ");
        System.out.println("type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit");
        System.out.println("Type 4 Exit");
        System.out.println("Choice: ");

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
