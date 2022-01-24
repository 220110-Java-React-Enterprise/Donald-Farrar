import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRepo implements DataSourceCRUD<DataStore>{
    private final Connection connection;

    public DataRepo() {
        connection = ConnectionManager.getConnection();
    }

    @Override
    public DataStore create(DataStore model) {
        //JDBC logic here

        try {
            String sql = "INSERT INTO associates (userName, password, first_name, last_name, email, address) VALUES (?,?,?,?,?,?)";//question marks imply that something needs to be here
            PreparedStatement pstmt = connection.prepareStatement(sql);
//            pstmt.setInt(1, model.getId());
            pstmt.setString(1, model.getUserName());
            pstmt.setString(2, model.getPassword());
            pstmt.setString(3, model.getFirstName());
            pstmt.setString(4, model.getLastName());
            pstmt.setString(5, model.getEmail());
            pstmt.setString(6, model.getAddress());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public DataStore read(Integer id) {
        try {
            String sql = "SELECT * FROM associates WHERE associate_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            DataStore model = new DataStore();
            while(rs.next()) {
                model.setId(rs.getInt("associate_id"));
                model.setFirstName(rs.getString("userName"));
                model.setLastName(rs.getString("password"));
                model.setLastName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setLastName(rs.getString("email"));
                model.setLastName(rs.getString("address"));
            }

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DataStore update(DataStore dataStore) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}