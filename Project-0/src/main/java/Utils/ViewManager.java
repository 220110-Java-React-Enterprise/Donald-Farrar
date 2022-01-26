package Utils;


import Views.View;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ViewManager {
    //singleton design
    //maintain a private reference to itself
    private static ViewManager viewManager;
    private boolean running;
    private final Scanner scanner;
    List<View> viewList;
    View nextView;

    //private constructor so it can't be instantiated more than one at a time
    private ViewManager(){
        //starting values and references
        running = true;
        scanner = new Scanner(System.in);
        viewList = new LinkedList<>();
    }

    //singleton manager
    public static ViewManager getViewManager(){
        if(viewManager == null){
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void navigate(String destination){
        for(View view : viewList){
            if(view.getViewName().equals(destination)){
                nextView = view;
            }
        }
    }

    //registerView adds it to our list
    public void registerView(View view) {
        viewList.add(view);
    }
    //render calls the nextViews render ======> changes screens
    public void render() throws SQLException, IOException {
        nextView.renderView();
    }
    //return this scanner if when we need it
    public Scanner getScanner() {
        return scanner;
    }
    public void quit() {
        running = false; //set to false because that is how you quit
    }
    public boolean isRunning() {
        return running;
    }//check for our loop to see if it is still running

}
