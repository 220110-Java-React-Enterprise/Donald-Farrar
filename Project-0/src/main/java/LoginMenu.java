public class LoginMenu extends View {

    public LoginMenu() {
        viewMenu = "Login Menu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("========== Login Menu ==========");
        System.out.println("Enter username: ");
        System.out.println("UN>"+DataStore.getUser()+"\n");
        System.out.println("Enter password: ");
        System.out.println("PW>"+DataStore.getPass()+"\n");
        String input = viewManager.getScanner().nextLine();

        if(DataStore.getUser()!=null && DataStore.getPass()==null) {
            DataStore.setPass(input);
            //navigate to next menu
            viewManager.navigate("Menu Options");
        }

        if(DataStore.getUser()==null)
            DataStore.setUser(input);




       // viewManager.quit();

        //NEEDS TO GET OUT OF THIS LOOP THAT KEEPS ASKING FOR USER AND PASS AGAIN AND BE ABLE TO NAVIGATE TO THE MENU OPTIONS PAGE FROM HERE
    }
}