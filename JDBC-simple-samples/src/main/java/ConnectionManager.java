import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    //this is for keeping a connection object alive and referenced and it will be used by this class
    private static Connection connection;
    //private because no one else should access this field directly - abstraction
    //static because we will never instantiate an object of this class, we just use the static functionality
    //Connection is an object that stores and keeps alive a connection to a database

    //no args constructor, not really used here
    private ConnectionManager() {
    }

    //this is a method to grab the connection above. Note that it works like a singleton, if there is
    //a connection we return that, otherwise create it and then return it.
    public static Connection getConnection() {
        if(connection == null) {
            connection = connect();
        }
        return connection;
    }

    private static Connection connect() {
        //connection logic here
        /*
        jdbc:mariadb://<hostname>:<port>/<databaseName>?user=<username>&password=<password>
        This is the string we need to use to connect to our database. We will build this string with each of the
        variables filled out and qualified.

         */

        //try catch block because the things in here are likely to throw exceptions. We could throw these up further, but
        //we're going to handle them here.
        try {

            //Properties is an object that holds key/value pairs read from a file
            Properties props = new Properties();
            //the file reader gets the data out of the file, and when we call props.load it loads that data
            //into the properties object
            FileReader fr = new FileReader("src/main/resources/connection.properties");
            props.load(fr);


            //next we concatenate the parts of our string so that it is complete and fully qualified
            String connectionString = "jdbc:mariadb://" +
                    props.getProperty("hostname") + ":" +
                    props.getProperty("port") + "/" +
                    props.getProperty("dbname") + "?user=" +
                    props.getProperty("username") + "&password=" +
                    props.getProperty("password");

            Class.forName("org.mariadb.jdbc.Driver");

            connection = DriverManager.getConnection(connectionString);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return connection;
    }


}