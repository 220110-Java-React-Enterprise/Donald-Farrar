package Persistence;

import Utils.ConnectionManager;
import org.mariadb.jdbc.internal.com.read.resultset.SelectResultSet;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepo implements DataSourceCRUD<UserModel>{

    @Override
    public Integer create(UserModel userModel) throws SQLException, IOException {
        String sql = "INSERT INTO users (userName, password, fName, lName, address, zip) VALUES (?, ?, ?, ?, ?, ?)";
        //CALLING THE CONNECTION ON demand INSTEAD OF CREATED THE OBJ
        PreparedStatement  pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //Note that we are not adding the id because it is auto-incremented
        //parameterizing use return type also this is a string below in read it's an int
        //following the order of the sql string
        pstmt.setString(1, userModel.getUserName());
        pstmt.setString(2, userModel.getPassword());
        pstmt.setString(3, userModel.getfName());
        pstmt.setString(4, userModel.getlName());
        pstmt.setString(5, userModel.getAddress());
        pstmt.setInt(6, userModel.getZip());

        pstmt.executeUpdate();
        //Create an obj for then below ask for the result set
        //this one is getGenerateKeys, because of the second argument above
        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public UserModel read(Integer id) throws SQLException, IOException {
        //this can never return more than one thing because the user_id is unique
        String sql = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        //if we have the thing marshal it into a UserModel obj //linkedList
        UserModel user = new UserModel();
        if(rs.next()){
            //if there is one now we read the user_id
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setfName(rs.getString("fName"));
            user.setlName(rs.getString("lName"));
            user.setAddress(rs.getString("address"));
            user.setUserId(rs.getInt("zip"));
            return user;
        } else {
            return null;
        }
    }

    @Override
    public UserModel update(UserModel userModel) throws SQLException, IOException {
        String sql = "UPDATE users SET userName = ?, password = ?, fName = ?, lName = ?, address = ?, zip = ? WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        //we are setting the data by parameterizing it
        //following the order of the sql string they are considered parameters. That's how the below code works
        pstmt.setString(1, userModel.getUserName());
        pstmt.setString(2, userModel.getPassword());
        pstmt.setString(3, userModel.getfName());
        pstmt.setString(4, userModel.getlName());
        pstmt.setString(5, userModel.getAddress());
        pstmt.setInt(6, userModel.getZip());
        pstmt.setInt(7, userModel.getUserId());

        pstmt.executeUpdate();
        //verify the data did get back correctly.
        String verify = "SELECT * FROM users WHERE user_id = ?";
        //second prepared statement
        PreparedStatement verifyStat = ConnectionManager.getConnection().prepareStatement(verify);
        pstmt.setInt(1, userModel.getUserId());
        //compare this with the other times you have used ResultSet in your CRUD code above
        ResultSet rs = verifyStat.executeQuery();

        if(rs.next()){
            UserModel verifiedUserModel = new UserModel();
            //marshal everything into the above instantiation
            //gotta get the name of the column that we are fetching which is user_id and set it with the obj
            verifiedUserModel.setUserId(rs.getInt("user_id"));
            verifiedUserModel.setUserName(rs.getString("userName"));
            verifiedUserModel.setPassword(rs.getString("password"));
            verifiedUserModel.setfName(rs.getString("fName"));
            verifiedUserModel.setlName(rs.getString("lName"));
            verifiedUserModel.setAddress(rs.getString("address"));
            verifiedUserModel.setZip(rs.getInt("zip"));
            return verifiedUserModel;
        }
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {
        String sql = "DELETE * FROM users where user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    //this is not implementing the CRUD interface
    //the code below is how to create a login
    public boolean authenticate(String userName, String password) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, userName);
        ResultSet rs = pstmt.executeQuery();
        //this if/statement implys that if the password that was inputted matching the one in the db && there is a next return true
        if(rs.next() && rs.getString("password").equals(password)){
            return true;
        }
        //if we don't have a next that means username was not found, return false
        return false;
    }
}
