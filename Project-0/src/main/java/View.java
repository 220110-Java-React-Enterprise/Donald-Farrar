public abstract class View {

    protected String name; //going to have to change this to where the name is only showing after the user has logged in
    public String getName() {
        return name;
    }


    protected String userName;
    protected String userPassword;
    protected Integer pin;
    protected ViewManager viewManager;

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Integer getUserPin() {
        return pin;
    }
    public abstract void renderView();
}
