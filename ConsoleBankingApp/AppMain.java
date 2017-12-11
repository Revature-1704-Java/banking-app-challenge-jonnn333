
import java.util.*;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class AppMain {
    
    /*
    Console Banking App
    Assigned: 12/11/17
    DUE: by 6pm, SAME DAY
    ALSO: Text Game Project DUE MIDNIGHT (need Maven/JUnit Tests)

    Requirements: 
        - proper OOP, abstract/interface
        - JUnit
        - File I/O, stores account info
        - Maven
        - Able to open accounts, deposits, withdraw
    */

    static SavingsAccount savings;
    static CheckingAccount checking;
    static int status;

    public static void main(String[] args) {
        // run Banking App from here!

        // test
        if (checking instanceof CheckingAccount) {
            System.out.println("checking works!");
        }

        // test an Account and file read and write
        SavingsAccount testSave = new SavingsAccount();
        testSave.testSavingsAccount();
        CheckingAccount testCheck = new CheckingAccount();
        testCheck.testCheckingAccount();

        // user input
        System.out.println("Welcome to THE Bank");
        System.out.println("Please tell us if you're an 'existing' memnber");
        System.out.println("Alternatively, if you'd like to open an account, type 'open' and 'Checking' or 'Savings' ");

        //String[] vars = new String[3];
        //String[] newVars = new String[2];
        String typeAccount = "";
        String first;
        String last;
        String id;
        Scanner scan = null;

        try {
            scan = new Scanner(System.in);
            String initial_input; 
            initial_input = scan.nextLine();

            if (initial_input.equals("open Checking")) {
                System.out.println("Please input your first name");
                first = scan.nextLine();
                System.out.println("Please input your last name");
                last = scan.nextLine();

                checking = new CheckingAccount(first, last, "none");
                status = 1;
            }

            else if (initial_input.equals("open Savings")) {
                System.out.println("Please input your first name");
                first = scan.nextLine();
                System.out.println("Please input your last name");
                last = scan.nextLine();

                savings = new SavingsAccount(first, last, "none");
                status = 0;
            }

            else if (initial_input.equals("existing")) { 
                System.out.println("Please input your first name");
                first = scan.nextLine();
                System.out.println("Please input your last name");
                last = scan.nextLine();
                System.out.println("Please input your account id");
                id = scan.nextLine();

                System.out.println("And what kind of account is this? [Checking | Savings]");
                typeAccount = scan.nextLine();

                if (typeAccount.equals("Savings")) {
                    savings = new SavingsAccount(first, last, id);
                    status = 0;
                }
                else if (typeAccount.equals("Checking")) {
                    checking = new CheckingAccount(first, last, id);
                    status = 1;
                }
                else {
                    System.out.println("Invalid account info.");
                }
            }
            else {
                System.out.println("An error occurred");
            }
            //scan.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } 

        System.out.println("Choose what to do with your account: deposit | withdraw");
        String action = scan.nextLine();
        System.out.println("Please choose an amount");
        String actAmount = scan.nextLine();

        if (action.equals("deposit") && status == 0) {
            savings.depositAmount(Float.parseFloat(actAmount));
        }
        else if (action.equals("deposit") && status == 1) {
            checking.depositAmount(Float.parseFloat(actAmount));
        }
        else if (action.equals("withdraw") && status == 0) {
            savings.withrawAmount(Float.parseFloat(actAmount));
        }
        else if (action.equals("withdraw") && status ==1) {
            checking.withrawAmount(Float.parseFloat(actAmount));
        }

        System.out.println("Thank you for banking with us. Have a nice day!");
        scan.close();
    }

}
