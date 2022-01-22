public class LoginMenu extends View {
    public LoginMenu() {
        viewMenu = "LoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("========== Login Menu ==========");
        System.out.println("Enter username to login: ");

        //get input from user
        String input = viewManager.getScanner().nextLine();


        DataStore.setUser(input);

        System.out.println("Enter password: ");
        DataStore.setPass(input);

        //navigate to next menu

    }
}
