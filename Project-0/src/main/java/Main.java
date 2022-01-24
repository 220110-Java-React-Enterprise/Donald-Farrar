public class Main {

    public static void main(String[] args){
        //System.out.println("This is working!");
        ViewManager viewManager = ViewManager.getViewManager();


        viewManager.registerView(new WelcomeScreen());
        viewManager.registerView(new CreateAccount());
        viewManager.registerView(new LoginMenu());
        viewManager.registerView(new MenuOptions());
        viewManager.registerView(new AccountView());
        viewManager.registerView(new Withdraw());
        viewManager.registerView(new Deposit());

        viewManager.navigate("Welcome Screen");
        //viewManager.navigate("Login Menu");
        //viewManager.navigate("Menu Options");



        while(viewManager.isRunning()) {
            viewManager.render();
        }
    }
}