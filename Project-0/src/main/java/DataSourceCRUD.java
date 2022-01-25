import java.sql.SQLException;

public interface DataSourceCRUD<T> {
    //CRUD - create, read, update, delete
    public DataStore create(T t) throws SQLException;
    public T read(Integer id) throws SQLException;
    public T update(T t) throws SQLException;
    public void delete(Integer id) throws SQLException;
}