import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ViewManager {
    private static ViewManager viewRenderer;
    private boolean running;
    private final Scanner scanner;

    List<View> viewList;
//    View nextView;



    private ViewManager(){
        running = true;
        scanner = new Scanner(System.in);
        viewList = new LinkedList<>();
    }

    public  static ViewManager getViewRenderer(){
        if (viewRenderer == null){
            viewRenderer = new ViewManager();
        }
        return viewRenderer;
    }

    public void navigate(String destination){

    }
}
