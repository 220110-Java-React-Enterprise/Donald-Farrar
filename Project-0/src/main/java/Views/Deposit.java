package Views;

import Utils.ViewManager;

public class Deposit extends Options {

    String accountType;

    public Deposit() {
        viewName = "Deposit"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println();
        String input = viewManager.getScanner().nextLine();

        //implement currency money here
        switch(input) {
            case "1":
                System.out.println();
                break;
            case "5":
                System.out.println();
                break;
            case "10":
                System.out.println();
                break;

            case "20":
                System.out.println();
                break;
            case "50":
                System.out.println();
                break;
            case "100":
                System.out.println();
                break;
            default:
                System.out.println("Enter valid credentials....");
                break;
        }
    }
}
