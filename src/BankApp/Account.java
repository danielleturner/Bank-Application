package BankApp;

import java.io.IOException;

public class Account {


    private double checkingBalance;
    private double savingsBalance;

    public Account(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double depositToChecking(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    //    @Override
//    public String toString(){
//        return("Hi " + this.getName() + ", the balance of your account is " + this.getBalance());
//    }

    public static void main(String[] args) throws IOException {

//        Account Danny = new Account("Danny", 500.00);
//        System.out.println(Danny);

    }


}


