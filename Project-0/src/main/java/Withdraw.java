public class Withdraw extends View{

    public Withdraw() {
        //navigating to the different screens
        viewMenu = "Withdraw";
        viewManager = viewManager.getViewManager();
    }


    @Override
    public void renderView() {
        System.out.println("Inside the withdraw screen");
        viewManager.quit();
    }
}
