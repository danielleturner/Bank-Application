package AtmProject;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public Account(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Account() {

    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Withdrawal Methods
    public double calcCheckingWihdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    // Deposit Methods
    public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("How much would you like to withdraw from your Checking Account? ");
        double amount = input.nextDouble();

        if((checkingBalance - amount) >= 0){
            calcCheckingWihdraw(amount);
            System.out.println("Your new Checking balance is: " +  moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Balance cannot be a negative number");
        }
    }

    public void getsavingWithdrawInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("How much would you like to withdraw from your Savings Account? ");
        double amount = input.nextDouble();

        if((savingBalance - amount) >= 0){
            calcSavingWithdraw(amount);
            System.out.println("Your new Savings balance is: " +  moneyFormat.format(savingBalance));
        }else{
            System.out.println("Balance cannot be a negative number");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("How much would you like to deposit in your Checking Account? ");
        double amount = input.nextDouble();

        if((checkingBalance + amount) >= 0){
            calcCheckingDeposit(amount);
            System.out.println("Your new Checking account balance is: " +  moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Balance cannot be a negative number");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Savings Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("How much would you like to deposit in your Savings Account? ");
        double amount = input.nextDouble();

        if((savingBalance + amount) >= 0){
            calcSavingDeposit(amount);
            System.out.println("Your new Savings account balance is: " +  moneyFormat.format(savingBalance));
        }else{
            System.out.println("Balance cannot be a negative number");
        }
    }
}
