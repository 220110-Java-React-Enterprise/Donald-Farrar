package Views;

import Persistence.BankRepo;
import Utils.DataStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class Deposit extends Options {

    String accountType;

    public Deposit() {
        viewName = "Deposit"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws SQLException, IOException {
        BankRepo bankrepo = new BankRepo();

        System.out.println("How much would you like to deposit: ");
        double input = Double.parseDouble(viewManager.getScanner().nextLine());

        if(input >= 0){
            DataStore.getCurrentAccount().deposit(input);
            bankrepo.update(DataStore.getCurrentAccount());
        }
        viewManager.navigate("Options");
    }
}
