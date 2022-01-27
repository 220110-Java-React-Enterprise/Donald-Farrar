package Views;

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
        System.out.println("===============  Accounts  =================\n");
        System.out.println("1) Create new account: \n =================");
        System.out.println("2) Create new account: \n =================");
    }
}
