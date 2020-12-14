package controller;

import DAO.DAOUser;
import java.util.List;
import model.User;

public class ControllerUser {
    DAOUser daoUser = new DAOUser();
    
    public boolean saveUserController(User user){
        return this.daoUser.saveUserDAO(user);
    }

    public List<User> getListUsersController() {
       return this.daoUser.getUserList();
    }
}
