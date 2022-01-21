import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ViewManager {
    //create variables for that use logic in gaining access to the menuOptions
    private static ViewManager viewManager;
    private boolean running;
    private final Scanner scanner;


    //Adapt Custom Array List here
    //change this when finished with the arrayList assignment
    List<View> viewList;
    View nextView;

    //making the constructor private to make it a singleton design pattern, has starting values and references
    private ViewManager(){
        running = true;
        scanner = new Scanner(System.in);
        viewList = new LinkedList<>();  //change too CustomArray List

    }
    public static ViewManager getViewManager(){
        if(viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public Object navigate(String destination) {
        for(View view : viewList) {
            if(view.userName.equals(destination) && view.userPassword.equals(destination)) {
                nextView = view;
            }
        }
        return null;
    }

    public void registerView(View view) {
        viewList.add(view);
    }


    ///////PROBLEM//////////////
    //i AM IN AN INFINITE LOOP
    public void render() {
        System.out.println("PROBLEMS");
        //nextView.renderView();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void quit() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

}
