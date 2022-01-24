public class WelcomeScreen extends View {



    public WelcomeScreen() {
        //navigating to the different screens
        viewMenu = "Welcome Screen";
        viewManager = viewManager.getViewManager();
    }

    @Override
    public void renderView(){
        System.out.println("Welcome, ");
        System.out.println("1. Login: ");
        System.out.println("2. Create new account: ");

        //receive input
        String input = viewManager.getScanner().nextLine();

        //Use the navigation method to move through bank-app
        switch(input){
            case "1":
                viewManager.navigate("Login Menu");
                break;
            case "2":
                viewManager.navigate("Create Account");
                break;
            default: System.out.println("Good Bye");
                //quit the input
                viewManager.quit();
        }
    }
}
