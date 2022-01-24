public class DataStore {

    private Integer id;
    private static String user;
    private static String pass;
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String address;

    public DataStore() {
    }
    public DataStore(Integer id) {
        this.id = id;
    }

    public DataStore(Integer id, String firstName, String lastName, String email, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    //BELOW IS THE GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public static String getFirstName() {
        return firstName;
    }
    public static void setFirstName(String firstName) {
        DataStore.firstName = firstName;
    }
    public static String getLastName() {
        return lastName;
    }
    public static void setLastName(String lastName) {
        DataStore.lastName = lastName;
    }
    public static String getEmail() {
        return email;
    }
    public static void setEmail(String email) {
        DataStore.email = email;
    }
    public static String getAddress() {
        return address;
    }
    public static void setAddress(String address) {
        DataStore.address = address;
    }
    public static String getUser() {
        return user;
    }
    public static void setUser(String u) {
        user = u;
    }
    public static String getPass() {
        return pass;
    }
    public static void setPass(String p) {
        pass = p;
    }
}
