package Utils;

import Persistence.UserModel;

public class DataStore {


    //creating a current user so it stays static
    private static UserModel currentUser;
    public static void setCurrentUser(UserModel user){
        currentUser = user;
    }

    public static UserModel getCurrentUser(){
        return currentUser;
    }

}
