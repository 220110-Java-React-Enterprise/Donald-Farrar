package Utils;

import Persistence.BankModel;
import Persistence.UserModel;

public class DataStore {


    //creating a current user so it stays static
    private static UserModel currentUser;
    private static BankModel currentAccount;

    public static BankModel getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(BankModel currentAccount) {
        DataStore.currentAccount = currentAccount;
    }


    public static void setCurrentUser(UserModel user){
        currentUser = user;
    }

    public static UserModel getCurrentUser(){
        return currentUser;
    }

}
