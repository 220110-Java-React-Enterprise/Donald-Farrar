package Views;

import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.DataStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class Login extends View{

    public Login() {
        viewName = "Login"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("Login: \n =================");
        System.out.println("Enter username: ");
        String username = viewManager.getScanner().nextLine();

        System.out.println("Enter password: ");
        String password = viewManager.getScanner().nextLine();


        UserRepo repo = new UserRepo();
        UserModel user = repo.authenticate(username, password);

        //check to see if it works
        if(user == null){
            System.out.println("\n Incorrect Credentials......\n\n\n\n");
            viewManager.navigate("Welcome");
            return;
        }
        //this will have them be logged in when registered instead of reverting to the login screen
        DataStore.setCurrentUser(user);
        //after we successfully created the user navigate to the next view
        viewManager.navigate("Options");
    }
}
