package Views;

import Utils.ViewManager;

import java.util.Scanner;

public class Welcome extends View{

    public Welcome() {
        viewName = "Welcome"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("Welcome to To Don's Tiny Bank!\n" +
                "=================\n" +
                "1) Create New Account \n" +
                "2) Login \n" +
                "===================\n");

        String input =  viewManager.getScanner().nextLine();


        switch(input) {
            case "1":
                viewManager.navigate("Create");
                break;
            case "2":
                viewManager.navigate("Login");
                break;
            default:
                System.out.println("\nGoodBye........\n");
                break;
        }

    }
}
