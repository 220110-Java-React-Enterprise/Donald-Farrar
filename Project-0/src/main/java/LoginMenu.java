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
        String input = viewManager.getScanner().nextLine();
        System.out.println("1");
        DataStore.setUser(input);
        System.out.println("2");
        System.out.println("Enter password: ");
        System.out.println("3");
        DataStore.setPass(input);
        System.out.println("4");

        //navigate to next menu

    }
}
