public class Deposit extends View{

    public Deposit() {
        //navigating to the different screens
        viewMenu = "Withdraw";
        viewManager = viewManager.getViewManager();
    }


    @Override
    public void renderView() {
        System.out.println("Inside the deposit screen");
    }

}
