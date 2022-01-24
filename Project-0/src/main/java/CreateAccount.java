public class CreateAccount extends View {

    public CreateAccount() {
        //navigating to the different screens
        viewMenu = "Create Account";
        viewManager = viewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("===== Create Account =====");
        System.out.println("Enter your Email Address: ");

        String input = viewManager.getScanner().nextLine();
        viewManager.quit();
    }
}
