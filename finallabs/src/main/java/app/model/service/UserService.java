package app.model.service;

import app.model.entity.UserAccount;
import app.model.dao.ConnectionsPool;
import app.model.dao.UserDAO;

import java.sql.SQLException;
import java.util.List;


public class UserService {

    public List<UserAccount> getAll() throws SQLException {
        UserDAO dao = new UserDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<UserAccount> users = dao.showAllUsers();
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return users;
    }

    public static UserAccount findUser(String userName, String password) throws SQLException {
        UserDAO dao = new UserDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        UserAccount user = dao.findUser1(userName, password);
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Success");
            return user;
        }
        return null;
    }

    public UserAccount insertUser(UserAccount newUser) throws SQLException {
        UserDAO dao = new UserDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        UserAccount user = dao.save(newUser);
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return user;
    }

    public static void alterCount(double value, String userName) throws SQLException {
        UserDAO dao = new UserDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        dao.alterCount(value, userName);
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
    }
}

