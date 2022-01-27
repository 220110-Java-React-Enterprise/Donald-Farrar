package Views;

import Utils.ViewManager;

public class Withdraw extends Options{
    String accountType;
    public Withdraw() {
        viewName = "Withdraw"; //this how we navigate
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("Enter amount to withdraw: \n");
        Double input = Double.parseDouble((viewManager.getScanner().nextLine()));

    }
}
