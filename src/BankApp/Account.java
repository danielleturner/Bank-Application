package BankApp;

import java.io.IOException;

public class Account {


    String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString(){
        return("Hi " + this.getName() + ", the balance of your account is " + this.getBalance());
    }

    public static void main(String[] args) throws IOException {

        Account Danny = new Account("Danny", 500.00);
        System.out.println(Danny);

    }


}


