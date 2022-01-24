public class CreateAccount extends View {

    public CreateAccount() {
        //navigating to the different screens
        viewMenu = "Create Account";
        viewManager = viewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("Display Created Account");
        viewManager.quit();
    }
}
