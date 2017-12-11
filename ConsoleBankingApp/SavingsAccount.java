

public class SavingsAccount extends File_ReadWrite implements AccountInterface {

    float balance; // must retrieve from file io
    float limit = 500;

    SavingsAccount () {
        // balance = get balance from file by using name/account_id into some method
    }

    SavingsAccount (String first, String last, String accId_pin) {

        if (accId_pin.equals("none")) {
            writeFile(first+last+".txt", "50000", "none");
        }
        else {
            readFile(first+last+".txt", accId_pin);
        }

        // first check if all parameters are completed
        // then try to find name and corresponding pin number to match account number
        // get the balance
        // get statuses of the account
        // set the statuses if meeting certain conditions
    }

    @Override
    public void withrawAmount(float amount) {
        if (balance > 0 && (balance -= amount) < 0 ) {
            balance -= amount;
            System.out.println("Withdrew $"+amount);
        }
        else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void depositAmount(float amount) {
        balance += amount;
        System.out.println("Deposited $"+amount);
    }

    @Override
    public void openAccount(String first, String last) {
        
    }

    void testSavingsAccount() {
        writeFile("PeterPan", "30000", "asdfghjkl");
        readFile("PeterPan", "asdfghjkl");
    }
}