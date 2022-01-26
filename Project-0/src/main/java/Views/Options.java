package Views;

import Utils.ViewManager;

public class Options extends View{
    public Options() {
        viewName = "Options"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() {

        System.out.println("Please select from the following: \n" +
                "=================\n" +
                "1) Withdraw \n" +
                "2) Deposit \n" +
                "===================\n");

        String input =  viewManager.getScanner().nextLine();


        switch(input) {
            case "1":
                viewManager.navigate("Withdraw");
                break;
            case "2":
                viewManager.navigate("Deposit");
                break;
            default:
                if(input == null){
                    System.out.println("\n Incorrect Credentials......\n\n\n\n");
                    viewManager.navigate("Welcome");
                    return;
                }
                break;
        }
    }
}

