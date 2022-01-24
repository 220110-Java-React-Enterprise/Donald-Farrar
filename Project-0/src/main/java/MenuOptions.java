public class MenuOptions extends LoginMenu {

    public MenuOptions(){
        viewMenu = "Menu Options";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("========== Menu Options ==========");
        DataStore.getUser();
        DataStore.getPass();
        System.out.println(DataStore.getName() + " Select from the options below: ");
        System.out.println("1. View Accounts ");
        System.out.println("2. Withdraw ");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");

        String input = viewManager.getScanner().nextLine();

        switch(input){
            case "1":
                viewManager.navigate("View Accounts");
                break;
            case "2":
                viewManager.navigate("Withdraw");
                break;
            case "3":
                viewManager.navigate("Deposit");
                break;
            case "4":
                viewManager.navigate("Welcome Screen");
                break;
        }
        viewManager.quit();
    }
}