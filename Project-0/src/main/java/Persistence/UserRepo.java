package Persistence;

import Utils.ConnectionManager;

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
        return null;
    }

    @Override
    public UserModel update(UserModel userModel) throws SQLException, IOException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {

    }
}
