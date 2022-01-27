package Persistence;

import Utils.CustomListInterface;

import java.io.IOException;
import java.sql.SQLException;

public interface BankCRUD<T>{
    CustomListInterface<T> getAccounts(int user_id) throws SQLException, IOException;
    //CRUD - create, read, update, delete
    public Integer create(T t) throws SQLException, IOException;
    public T read(String userName) throws SQLException, IOException;
    public T update(T t) throws SQLException, IOException;
    public void delete(Integer id) throws SQLException, IOException;
}
