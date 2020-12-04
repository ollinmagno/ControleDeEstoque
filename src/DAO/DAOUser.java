package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import util.ConnectionSQLite;

public class DAOUser extends ConnectionSQLite {
    
    public boolean saveUserDAO(User user){
        connect();
        String sql = "INSERT INTO tbl_user ("
                + "user_name, " 
                + "user_login, "
                + "user_password) "
                + "VALUES (?,?,?)";
        PreparedStatement preparedStatement = 
                createPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        try {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}   
