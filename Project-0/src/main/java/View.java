public abstract class View {

    protected String viewName;
    protected ViewManager viewManager;
    protected String userName;
    protected String userPassword;


    public String getViewName() {
        return viewName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }



    public abstract void renderView();
}

//protected String name; //going to have to change this to where the name is only showing after the user has logged in

//    protected Integer userId;

//    protected String firstName;
//    protected String lastName;
//    protected String email;
//    protected String address;

//    protected Integer pin; //not sure I want to use this yet

//    public String getName() {
//        return name;
//    }

//
//    public Integer getUserPin() {
//        return pin;
//    }
