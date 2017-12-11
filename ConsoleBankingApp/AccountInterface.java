
import java.nio.file.ReadOnlyFileSystemException;
import java.util.*;

public interface AccountInterface {

    String firstName = "";
    String lastName = "";
    int accountNum = 0;
    int otherAccounts = 0;

    //void setFirstName(String firstName);
    //String getFirstName();
    //void setLastName(String lastName);
    //String getLastName();
    //void setAccountNum(int accountNum);
    //int getAccountNum();

    // Open account, Deposit to, and Withdraw from
    public void openAccount(String name, String last);
    public void depositAmount(float amount);
    public void withrawAmount(float amount);

    // checks involving opening, withdrawing from, and depositing accounts
    /*
    void getOtherAccounts();
    boolean areOtherAccounts();
    boolean canWithDraw(float amount);
    boolean canDeposit();
    boolean isDelinquent();
    boolean isClosed();
    boolean canOpenAccount();
    boolean negativeBalance();
    String getReasons();
    float getMinimumBalance();
    */
}

