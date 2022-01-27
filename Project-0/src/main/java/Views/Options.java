package Views;

import Persistence.BankModel;
import Persistence.BankRepo;
import Utils.DataStore;
import Utils.ViewManager;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;

public class Options extends View{
    public Options() {
        viewName = "Options"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("====================>");

        System.out.println("Current Balance: " + DataStore.getCurrentAccount().getBalance());
        System.out.println("<=========================");
        System.out.println("Please select from the following: \n" +
                "=================\n" +
                "1) Withdraw \n" +
                "2) Deposit \n" +
                "3) Accounts \n" +
                "4) DeleteAccount\n" +
                "===================\n");

        String input =  viewManager.getScanner().nextLine();

        switch(input) {
            case "1":
                viewManager.navigate("Withdraw");
                break;
            case "2":
                viewManager.navigate("Deposit");
                break;
            case "3":
                viewManager.navigate("Accounts");
                break;
            case "4":
                BankRepo bankrepo = new BankRepo();
                bankrepo.delete(DataStore.getCurrentAccount().getAccountId());
                viewManager.navigate("Accounts");
                break;
            default:
                if(input == null){
                    System.out.println("\n Incorrect Credentials......\n\n\n\n");
                    viewManager.navigate("Welcome");
                    return;
                }
                break;
        }
    }
}

