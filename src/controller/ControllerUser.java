package controller;

import DAO.DAOUser;
import model.User;

public class ControllerUser {
    DAOUser daoUser = new DAOUser();
    
    public boolean saveUserController(User user){
        return this.daoUser.saveUserDAO(user);
    }
}
