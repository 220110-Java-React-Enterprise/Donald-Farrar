package Persistence;

import Utils.ConnectionManager;
import Utils.CustomLinkedList;
import Utils.CustomListInterface;
import Utils.DataStore;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;

public class BankRepo implements BankCRUD<BankModel> {

    @Override
    public CustomListInterface<BankModel> getAccounts(int user_id) throws SQLException, IOException {
        String sql = "SELECT * FROM bank WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, user_id);
        ResultSet rs = pstmt.executeQuery();

        CustomListInterface<BankModel> list = new CustomLinkedList<>();
        while(rs.next()){
            BankModel bm = new BankModel();
            bm.setAccountId(rs.getInt("account_id"));
            bm.setAccountType(rs.getString("accountType"));
            bm.setBalance((rs.getDouble("balance")));
            list.add(bm);
        }
        return list;
    }

    @Override
    public Integer create(BankModel bankModel) throws SQLException, IOException {
        String sql = "INSERT INTO bank (accountType, balance, user_id) VALUES (?,?, ?)";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, bankModel.getAccountType());
        pstmt.setDouble(2, bankModel.getBalance());
        pstmt.setInt(3, DataStore.getCurrentUser().getUserId());

        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }

    @Override
    public BankModel read(String id) throws SQLException, IOException {
        String sql = "SELECT * FROM bank WHERE account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, id);
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
        String sql = "UPDATE bank SET accountType = ?, balance = ? WHERE account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, bankModel.getAccountType() );
        pstmt.setDouble(2, bankModel.getBalance());
        pstmt.setInt(3, bankModel.getAccountId());
        pstmt.executeUpdate();
//        //return bankModel;
//
      return null;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {
        String sql = "DELETE FROM bank WHERE account_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.execute();
    }

    //so we can return all the accounts for the current user
    public CustomListInterface<BankModel> getAllItemsByUserId(Integer id) throws SQLException, IOException {
        String sql = "SELECT * FROM bank WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);

        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        CustomListInterface<BankModel> bankModel = new CustomLinkedList<>();

        while (rs.next()) {

            BankModel bank = new BankModel();
            bank.setAccountId(rs.getInt("account_id"));
            bank.setAccountType(rs.getString("accountType"));
            bank.setBalance(rs.getDouble("balance"));
            bankModel.add(bank);
        }
        return bankModel;
    }
}
