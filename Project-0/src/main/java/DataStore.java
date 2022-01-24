public class DataStore {

    private Integer id;
    private static String userName;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String address;

    public DataStore() {
    }
    public DataStore(Integer id) {
        this.id = id;
    }

    public DataStore(Integer id, String firstName, String lastName, String email, String user, String pass){
        this.id = id;
        this.userName = user;
        this.password = password;
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
    public static String getUserName() {
        return userName;
    }
    public static void setUserName(String u) {
        userName = u;
    }
    public static String getPassword() {
        return password;
    }
    public static void setPassword(String p) {
        password = p;
    }
}
