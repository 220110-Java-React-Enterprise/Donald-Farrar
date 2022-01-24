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

        DataRepo dr = new DataRepo();

        DataStore model = new DataStore();
//        model.setUserName();
//        model.setPassword();
//        model.setFirstName();
//        model.setLastName();
//        model.setEmail();
//        model.setAddress();

        model.setUserName("doggyman");
        model.setPassword("woof");
        model.setFirstName("Dodger");
        model.setLastName("Baby");
        model.setEmail("1234@gmail.com");
        model.setAddress("586 Cook Rd");
        dr.create(model);
        viewManager.quit();
    }
}
