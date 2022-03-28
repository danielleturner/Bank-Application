package AtmProject;

import java.io.IOException;

public class ATM extends OptionMenu{

    public ATM(int customerNumber) {
        super(customerNumber);
    }

    public static void main(String[] args) throws IOException{
        OptionMenu optionMenu = new OptionMenu();

        optionMenu.getLogin();
    }
}
