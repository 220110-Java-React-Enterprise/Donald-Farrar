package BankingApp.ViewMenuOptions;

public class DataStore {
    private static String user;
    private static String pass;

    public static String getName() {
        return user;
    }

    public static void setUser(String u) {
        user = u;
    }
    public static String getPass() {
        return pass;
    }

    public static void setPass(String p) {
        pass = p;
    }
}
