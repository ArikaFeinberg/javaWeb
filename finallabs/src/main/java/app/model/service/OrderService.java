package app.model.service;

import app.model.entity.Order;
import app.model.dao.ConnectionsPool;
import app.model.dao.OrderDAO;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderService {
    public List<Order> getAll() throws SQLException {
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<Order> orders = dao.showAllOrders();
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return orders;
    }

    public Order insertOrder(Order newOrder) throws SQLException {
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        dao.save(newOrder);
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return newOrder;
    }

    public void AlterByUsername(int command, int id, String value) throws Exception {
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        dao.alterByName(command, value, id);
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
    }
    public List<Order> sortByPrice() throws Exception {
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<Order> orders = dao.showAllOrders();
        if (orders.size() > 0) {
            Collections.sort(orders, new Comparator<Order>() { public int compare(Order one, Order two) {
                return Double.compare(one.getPrice(), two.getPrice());
            }
            });
        }
        //return orders;
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return orders;
    }

    public List<Order> sortByDate() throws Exception {
        OrderDAO dao = new OrderDAO();
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<Order> orders = dao.showAllOrders();
        if (orders.size() > 0) {
            Collections.sort(orders, new Comparator<Order>() {
                @Override
                public int compare(final Order object1, final Order object2) {
                    return object1.getDate().compareTo(object2.getDate());
                }
            } );
        }

        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return orders;
    }

    public List<Order> sortByStatus() throws Exception {
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<Order> orders = dao.showAllOrders();

        if (orders.size() > 0) {
            Collections.sort(orders, new Comparator<Order>() {
                @Override
                public int compare(final Order object1, final Order object2) {
                    return object1.getMgrStatus().compareTo(object2.getMgrStatus());
                }
            } );
        }

        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return orders;
    }

    public static List<Order> filterByMgrStatus(String status) throws Exception {
        OrderDAO dao = new OrderDAO();
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<Order> orders = dao.showAllOrders();
        for(int i =0; i<orders.size(); i++){
            if(!orders.get(i).getMgrStatus().equals(status)){
                orders.remove(i);
                i--;
            }
        }
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return orders;
    }

    public static List<Order> filterByMasterStatus(String status) throws Exception {
        OrderDAO dao = new OrderDAO();
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<Order> orders = dao.showAllOrders();
        for(int i =0; i<orders.size(); i++){
            if(!orders.get(i).getMasterStatus().equals(status)){
                orders.remove(i);
                i--;
            }
        }
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return orders;
    }
    public static int checkStatus(String username, String orderName) throws Exception{
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        //OrderDAO dao = new OrderDAO();
        List<Order> orders = dao.showAllOrders();
        //dao.closeConnection();
        for(int i = 0; i<orders.size(); i++){
            if(orders.get(i).getMasterStatus().equals("done")&& orders.get(i).getClientName().equals(username) && orders.get(i).getOrderName().equals(orderName)){
                //dao.alterReview(value, username);
                return 1;
            }
            else {
                return 2;
            }
        }
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return 0;
    }

    public static void alterReview(String username, String value, String orderName) throws SQLException {
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        dao.alterReview(value, username, orderName);
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        //return null;
    }

    public List<Order> findOrdersByUsername(String username) throws SQLException {
        OrderDAO dao = new OrderDAO();
        dao.setConnection(ConnectionsPool.getPool().getConnection());
        List<Order> orders = dao.findOrdersByUsername(username);
        ConnectionsPool.getPool().releaseConnection(dao.releaseConnection());
        return orders;
    }

}
