import Persistence.BankModel;
import Persistence.BankRepo;
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
//            //testing
            UserModel testUser = new UserModel("TESTING for userID 102", "ONO-ONO");
            testUser.setZip(01234);
            UserRepo userRepo = new UserRepo();
            Integer newUserId = userRepo.create(testUser); //use the create method to make a newUSerID here for testing
                System.out.println("Here =======>" + newUserId);
            BankModel testBank = new BankModel("6K", ".5k");
            BankRepo bankRepo = new BankRepo();
            bankRepo.create(testBank);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
