package BankingApp.ViewMenuOptions;

public class LoginMenu extends View {
    public LoginMenu() {
        userName = "LoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("========== Main Menu ==========");
        System.out.println("Enter username to login: ");

        //get input from user
        String input = viewManager.getScanner().nextLine();

        //preform validation?

        //store this for use later
        DataStore.setUser(input);

        System.out.println("Enter password: ");
        DataStore.setPass(input);

        //navigate to next menu
        viewManager.navigate("SubMenu");

    }
}
