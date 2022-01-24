public class AccountView extends MenuOptions{

    public AccountView() {
        viewMenu = "Account View";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("Display AccountView");
    }
}
