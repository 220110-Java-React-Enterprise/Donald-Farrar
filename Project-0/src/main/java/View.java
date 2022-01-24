public abstract class View {

    protected String viewMenu;
    protected ViewManager viewManager;

    public String getViewMenu() {
        return viewMenu;
    }

    public void setViewMenu(String viewMenu) {
        this.viewMenu = viewMenu;
    }

    public abstract void renderView();
}
