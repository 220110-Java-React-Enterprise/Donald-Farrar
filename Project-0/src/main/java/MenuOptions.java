public class MenuOptions extends View {

    public MenuOptions(){
        userName = "MenuOptions";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("========== Sub Menu ==========");
        System.out.println("Welcome, " + DataStore.getName());

        //view account
        //withdraw
        //deposit


        viewManager.quit();
    }
}
