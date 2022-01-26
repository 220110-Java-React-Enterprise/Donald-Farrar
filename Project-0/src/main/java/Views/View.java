package Views;

import Utils.ViewManager;

import java.sql.SQLException;

public abstract class View {

    protected String viewMenu;
    protected ViewManager viewManager;

    public String getViewName() {
        return viewMenu;
    }

    public void setViewName(String viewMenu) {
        this.viewMenu = viewMenu;
    }

    public abstract void renderView() throws SQLException;
}
