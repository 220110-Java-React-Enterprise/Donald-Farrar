import java.util.Properties;
import java.sql.Connection;
import java.io.FileReader;
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.SQLException;

public class ConnectionManager {
    //referencing to the connection object, this allows us to connect to the database
    //this is private so nobody is able to access it, this is also the use of abstraction
    //we make this static, because it will never be instantiated
    private static Connection connection;

    private ConnectionManager() {

    }
    //getting the connection above
    //if there is no connection we create one
    public static Connection getConnection(){
        if(connection == null){
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
