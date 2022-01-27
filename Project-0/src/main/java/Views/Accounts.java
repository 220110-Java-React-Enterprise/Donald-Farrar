package Views;

import Persistence.BankModel;
import Persistence.BankRepo;
import Utils.CustomLinkedList;
import Utils.CustomListInterface;
import Utils.DataStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class Accounts extends View {

    public Accounts() {
        viewName = "Accounts"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("===============  Accounts  =================");
        System.out.println("1) Create new account: ");

        BankRepo bankrepo = new BankRepo();

        CustomListInterface<BankModel> listOfAccounts = bankrepo.getAccounts(DataStore.getCurrentUser().getUserId());
        int count = 0;

       if(listOfAccounts.size() > 0){
           for (count = 0; count < listOfAccounts.size(); count++) {
               System.out.println(count+2 + ") " + listOfAccounts.get(count).getAccountType());
           }
        }

       System.out.println(count+2 + ") log out...." );


        String input = viewManager.getScanner().nextLine();

        if(input.equals("1")){
            BankModel bm = new BankModel();
            System.out.println("Which account would you like? ");
            bm.setAccountType(viewManager.getScanner().nextLine());
            bm.setBalance(0.0);
            bankrepo.create(bm);

        } else if(input.equals(count+2)){
            System.out.println("Good Bye!");
            viewManager.quit();
        } else {
            DataStore.setCurrentAccount(listOfAccounts.get(Integer.parseInt(input) - 2));
            viewManager.navigate("Options");
        }
    }
}
