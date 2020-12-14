package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import util.ConnectionSQLite;

public class DAOUser extends ConnectionSQLite {

    public boolean saveUserDAO(User user) {
        connect();
        String sql = "INSERT INTO tbl_user ("
                + "user_name, "
                + "user_login, "
                + "user_password) "
                + "VALUES (?,?,?)";
        PreparedStatement preparedStatement
                = createPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);

        try {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        disconnect();
        return true;
    }

    public List<User> getUserList() {
        List<User> listUsers = new ArrayList();
        User user = new User();
        connect();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_user_id,"
                + "user_name,"
                + "user_login,"
                + "user_password "
                + " FROM tbl_user";

        try {
            preparedStatement = createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                listUsers.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        disconnect();
        return listUsers;
    }

    public boolean deleteUser(int code) {
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM tbl_user WHERE pk_user_id = '" + code + "'";
        preparedStatement = this.createPreparedStatement(sql);

        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
}
