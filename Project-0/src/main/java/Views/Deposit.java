package Views;

import Persistence.BankRepo;
import Utils.DataStore;
import Utils.ViewManager;

public class Deposit extends Options {

    String accountType;

    public Deposit() {
        viewName = "Deposit"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        BankRepo bankrepo = new BankRepo();

        System.out.println("How much would you like to deposit: ");
        double input = Double.parseDouble(viewManager.getScanner().nextLine());

        if(input >= 0){
            DataStore.getCurrentAccount().getBalance()
            bankrepo.update();
        }
    }
}
