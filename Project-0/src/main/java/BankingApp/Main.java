package BankingApp;
import BankingApp.ViewMenuOptions.LoginMenu;
import BankingApp.ViewMenuOptions.MenuOptions;
import BankingApp.ViewMenuOptions.ViewManager;

public class Main {

    public static void main(String[] args){
        //System.out.println("This is working!");
        ViewManager viewManager = ViewManager.getViewManager();
        //System.out.println("1");
        viewManager.registerView(new LoginMenu());
        viewManager.registerView(new MenuOptions());
        //System.out.println("2");
        viewManager.navigate("MainMenu");
        //System.out.println("3");
        while(viewManager.isRunning()) {
           // System.out.println("4");
            viewManager.render();
        }
        //System.out.println("5");
    //return null;
    }
}
