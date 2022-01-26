package Persistence;

import Utils.ConnectionManager;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;

public class BankRepo implements DataSourceCRUD<BankModel> {


    @Override
    public Integer create(BankModel bankModel) throws SQLException, IOException {
        String sql = "INSERT INTO bank (accountType, balance) VALUES (?,?)";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, bankModel.getAccountType());
        pstmt.setDouble(2, bankModel.getBalance());


        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }

    @Override
    public BankModel read(Integer id) throws SQLException, IOException {
        String sql = "SELECT * FROM bank WHERE account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        BankModel bm = new BankModel();
        if(rs.next()){
            bm.setAccountId(rs.getInt("account_id"));
            bm.setAccountType(rs.getString("accountType"));
            bm.setBalance((rs.getDouble("balance")));
            return bm;
        }
        return null;
    }

    @Override
    public BankModel update(BankModel bankModel) throws SQLException, IOException {
        String sql = "UPDATE bank SET accountType = ?, balance = ? WHERE account_id";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, bankModel.getAccountType() );
        pstmt.setDouble(2, bankModel.getBalance());
        pstmt.executeUpdate();
        //return bankModel;

        String verify = "SELECT * FROM bank WHERE account_id = ?";
        PreparedStatement verifyStat = ConnectionManager.getConnection().prepareStatement(verify);
        pstmt.setInt(1,bankModel.getAccountId());
        ResultSet rs = verifyStat.executeQuery();
        if(rs.next()){
            BankModel verifiedBankModel = new BankModel();
            //marshal everything into the above instantiation
            //gotta get the name of the column that we are fetching which is user_id and set it with the obj
            verifiedBankModel.setAccountId(rs.getInt("account_id"));
            verifiedBankModel.setAccountType(rs.getString("checking"));
            verifiedBankModel.setBalance(rs.getDouble("balance"));
            return verifiedBankModel;
        }
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {
        String sql = "DELETE FROM user account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
