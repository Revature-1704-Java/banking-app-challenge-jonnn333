

public class CheckingAccount extends File_ReadWrite implements AccountInterface {

    float balance; // must retrieve from file io
    float limit = 500;

    CheckingAccount () {
        // empty constructor
    }

    CheckingAccount (String first, String last, String accId_pin) {
        if (accId_pin.equals("none")) {
            writeFile(first+last+".txt", "50000", "none");
        }
        else {
            readFile(first+last+".txt", accId_pin);
        }
    }

    @Override
    public void withrawAmount(float amount) {
        if (balance > 0 && (balance -= amount) < 0 ) {
            System.out.println("Withdrew $");
            balance -= amount;
        }
        else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void depositAmount(float amount) {
        balance += amount;
        System.out.println("Deposited $");
    }

    @Override
    public void openAccount(String first, String last) {
        
    }

    void testCheckingAccount() {
        writeFile("GriffinPete", "30000", "asdfghjkl");
        readFile("GriffinPete", "asdfghjkl");
    }
}