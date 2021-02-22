package app.model.dao;

import java.sql.Connection;

public class GeneralDAO {
    private static Connection connection;
    // private Connection connection;

    public void setConnection(Connection connection){ this.connection = connection;
    }

    public Connection releaseConnection(){
        Connection connection = this.connection;
        this.connection = null;
        return connection;
    }
    public static Connection getConnection(){
        return connection;
    }


}

