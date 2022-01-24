public class Deposit extends View{

    public Deposit() {
        //navigating to the different screens
        viewMenu = "Deposit";
        viewManager = viewManager.getViewManager();
    }


    @Override
    public void renderView() {
        System.out.println("Inside the deposit screen");
        viewManager.quit();
    }

}
