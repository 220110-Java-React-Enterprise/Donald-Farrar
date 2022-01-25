package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection connection;
    //singleton design factory model there can only be one obj of this class at a time
    private ConnectionManager(){
    }

    public static Connection getConnection() throws SQLException, IOException {
        if(connection == null){
            connection = connect();
        }
        return connection;
    }

    //this is private because we don't want anyone else to connect
    //I am going to throw all exceptions to main and handle them there with a try/catch
    private static Connection connect() throws IOException, SQLException {
        //connection logic here
        //BUILD THIS STRING
        /*
        //STRINGOFY BELOW ADDRESS
        jdbc:mariadb://<hostname>:<port>/<databaseName>?user=<username>&password=<password>
        This is the string we need to use to connect to our database. We will build this string with each of the
        variables filled out and qualified.
         */
        //instantiating the properties file. The information in this file is data that comes in key/value pairs
       Properties props = new Properties();
       FileReader fr = new FileReader("src/main/resources/connection.properties");
       props.load(fr);


       String connectionString =
        "jdbc:mariadb://" +
                props.getProperty("hostname") + ":" +
                props.getProperty("port") + "/" +
                props.getProperty("dbname") + "?user=" +
                props.getProperty("username") + "&password=" +
                props.getProperty("password");

       connection = DriverManager.getConnection(connectionString);
       return connection;
    }
}
