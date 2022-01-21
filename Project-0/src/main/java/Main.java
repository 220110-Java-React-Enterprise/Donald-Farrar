public class Main {

    public static void main(String[] args){
        System.out.println("This is working!");
        ViewManager viewManager = ViewManager.getViewManager();

        //ViewManager vm = new ViewManager();

        viewManager.registerView(new LoginMenu());
        viewManager.registerView(new MenuOptions());

        viewManager.navigate("Login Menu");


        while(viewManager.isRunning()) {
            viewManager.render();

        }

    }
}
