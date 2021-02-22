package app.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionsPool implements ConnectionPool {
    private static ConnectionsPool connectionsPool;
    private static int INITIAL_POOL_SIZE = 10;
    static {
        try{
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e){
            System.err.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
        }
    }
    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    public static ConnectionsPool getPool() throws SQLException {
        if (connectionsPool == null) {
            String url = "jdbc:postgresql://localhost:5432/Repair";
            String user = "postgres";
            String password = "qaz111";

            List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                pool.add(createConnection(url, user, password));
            }
            connectionsPool = new ConnectionsPool(url, user, password, pool);
        }
        return connectionsPool;
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private ConnectionsPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

}