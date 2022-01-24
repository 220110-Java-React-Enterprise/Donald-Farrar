import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRepo implements DataSourceCRUD<DataStore>{
    private final Connection connection;

    public DataRepo() {
        connection = Connection.getConnection();
    }

    @Override
    public DataStore create(DataStore model) {
        //JDBC logic here

        try {
            String sql = "INSERT INTO associates (associate_id, first_name, last_name, age) VALUES (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, model.getId());
            pstmt.setString(2, model.getFirstName());
            pstmt.setString(3, model.getLastName());
            //pstmt.setInt(4, model.getAge());

            pstmt.executeUpdate();


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
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
               // model.setAge(rs.getInt("age"));
            }

            return model;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }