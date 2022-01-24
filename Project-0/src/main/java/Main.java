public class Main {

    public static void main(String[] args){
        //System.out.println("This is working!");
        ViewManager viewManager = ViewManager.getViewManager();


        //This shows what view the user is on to perform their desired task
        viewManager.registerView(new WelcomeScreen());
        viewManager.registerView(new CreateAccount());
        viewManager.registerView(new LoginMenu());
        viewManager.registerView(new MenuOptions());
        viewManager.registerView(new AccountView());
        viewManager.registerView(new Withdraw());
        viewManager.registerView(new Deposit());

        viewManager.navigate("Welcome Screen");

        while(viewManager.isRunning()) {
            viewManager.render();
        }
    }
}