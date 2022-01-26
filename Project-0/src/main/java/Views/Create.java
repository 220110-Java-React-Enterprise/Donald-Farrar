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

        UserModel newUser = new UserModel(username, password);
        UserRepo repo = new UserRepo();
        repo.create(newUser);

        //this will have them be logged in when registered instead of reverting to the login screen
        DataStore.setCurrentUser(newUser);

        //after we successfully created the user navigate to the next view
        viewManager.navigate("list");

    }
}
