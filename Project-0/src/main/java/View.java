public abstract class View {

    protected String viewMenu;
    protected ViewManager viewManager;
    protected String userName;
    protected String userPassword;


    public String getMenu() {
        return viewMenu;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }



    public abstract void renderView();
}


