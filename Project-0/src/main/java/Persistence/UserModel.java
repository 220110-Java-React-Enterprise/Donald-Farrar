package Persistence;

public class UserModel {
    private Integer userId;
    private String userName;
    private String password;
    private String fName;
    private String lName;
    private String address;
    private Integer zip;

    //Constructor
    public UserModel() {
    }

    //this constructor is for the authenticate method on the UserRepo for login access
    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserModel(Integer userId, String userName, String password, String fName, String lName, String address, Integer zip) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.zip = zip;
    }

    //Getters & Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

}
