package Views;

import Persistence.BankRepo;
import Utils.DataStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class Withdraw extends Options{
    String accountType;
    public Withdraw() {
        viewName = "Withdraw"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws SQLException, IOException {
        BankRepo bankrepo = new BankRepo();

        System.out.println("How much would you like to withdraw: ");
        double input = Double.parseDouble(viewManager.getScanner().nextLine());

        if(input >= 0){
            DataStore.getCurrentAccount().withdraw(input);
            bankrepo.update(DataStore.getCurrentAccount());
        }
        viewManager.navigate("Options");
    }
}
