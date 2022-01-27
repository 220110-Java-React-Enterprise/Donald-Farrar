import Persistence.BankModel;
import Persistence.BankRepo;
import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ConnectionManager;
import Utils.ViewManager;
import Views.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String... args) {
        System.out.println("This is working?");
        try {
            //Test the connection, will print out the stack trace if it fails
            Connection conn = ConnectionManager.getConnection();
            ViewManager viewManager = ViewManager.getViewManager();
            viewManager.registerView(new Welcome());
            viewManager.registerView(new Create());
            viewManager.registerView(new Login());
            viewManager.registerView(new Options());
            viewManager.registerView(new Accounts());
            //Welcome screen should be the first menu the user comes to
            ViewManager.getViewManager().navigate("Welcome");
            while(ViewManager.getViewManager().isRunning()) {
                ViewManager.getViewManager().render();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}



//            //testing
//            UserModel testUser = new UserModel("TESTING for userID 105", "Cinco-Cinco");
//            testUser.setZip(01234);
//            UserRepo userRepo = new UserRepo();
//            Integer newUserId = userRepo.create(testUser); //use the create method to make a newUSerID here for testing
//                System.out.println("Here =======>" + newUserId);
//            BankModel testBank = new BankModel("checking", 10.5);
//            BankRepo bankRepo = new BankRepo();
//            bankRepo.create(testBank);
