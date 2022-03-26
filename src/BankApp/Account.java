package BankApp;

public class Account {

    private int balance;
    private int previousTransaction;


    // Constructor
    public Account(String name, String id) {
        System.out.println("Welcom" + name + " " + id + '\n');
    }

    void deposit(int a){

    }

    void withdraw(int a){

    }

    void getPreviousTransactioin(){

    }

    public double getBalance(double x, double y){
        return x + y;
    }
}


