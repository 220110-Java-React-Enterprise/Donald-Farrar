import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String ...args) {
        System.out.println("This is working?");
        try{
            //Test the connection, will print out the stack trace if it fails
            Connection conn = ConnectionManager.getConnection();

            //testing
            UserModel testUser = new UserModel("testUser", "password");
            testUser.setZip(12345);
            UserRepo userRepo = new UserRepo();
            Integer newUserId = userRepo.create(testUser); //use the create method to make a newUSerID here for testing
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
