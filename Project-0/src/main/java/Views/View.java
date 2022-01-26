package Views;

import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public abstract class View {

    protected String viewName;
    protected ViewManager viewManager;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewMenu) {
        this.viewName = viewMenu;
    }

    public abstract void renderView() throws SQLException, IOException;


}
