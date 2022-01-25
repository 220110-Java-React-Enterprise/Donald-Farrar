import java.sql.*;

public class DataRepo implements DataSourceCRUD<DataStore>{
    private final Connection connection;

    public DataRepo() {
        connection = ConnectionManager.getConnection();
    }

    @Override
    public Integer create(DataStore model) {
        //JDBC logic here

        try {
            String sql = "INSERT INTO associates (userName, password, first_name, last_name, email, address) VALUES (?,?,?,?,?,?)";//question marks imply that something needs to be here
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // second parameter lets us know what the auto-increment id is
            //next line of code parameterized this create method
            pstmt.setString(1, model.getUserName());
            pstmt.setString(2, model.getPassword());
            pstmt.setString(3, model.getFirstName());
            pstmt.setString(4, model.getLastName());
            pstmt.setString(5, model.getEmail());
            pstmt.setString(6, model.getAddress());

            pstmt.executeUpdate();
            //Create an obj for then below ask for the result set
            ResultSet rs = pstmt.getResultSet();
            rs.next();

            //this is going to set the customer id
            Integer id;
            //return next if there is a new id
            if(rs.next()){
                return rs.getInt(1);
            }
    } catch (SQLException e) {
            e.printStackTrace();
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