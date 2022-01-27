package Views;

import Persistence.BankModel;
import Persistence.BankRepo;
import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.DataStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class Create extends View{

    public Create() {
        viewName = "Create"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws IOException, SQLException {
        System.out.println("Create new user: \n =================");
        System.out.println("Enter new username: ");
        String username = viewManager.getScanner().nextLine();

        System.out.println("Enter new password: ");
        String password = viewManager.getScanner().nextLine();

        System.out.println("Enter first name: ");
        String fName = viewManager.getScanner().nextLine();
        System.out.println();
        System.out.println("Enter last name: ");
        String lName = viewManager.getScanner().nextLine();
        System.out.println("Enter address: ");
        String address = viewManager.getScanner().nextLine();
        System.out.println("Enter zip: ");
        int zip = Integer.parseInt(viewManager.getScanner().nextLine());




        UserModel newUser = new UserModel(username, password, fName, lName, address, zip);
        UserRepo repo = new UserRepo();
        repo.create(newUser);

        //this will have them be logged in when registered instead of reverting to the login screen
        DataStore.setCurrentUser(repo.read(username));

        //after we successfully created the user navigate to the next view
        viewManager.navigate("Accounts");

    }
}
