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
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
