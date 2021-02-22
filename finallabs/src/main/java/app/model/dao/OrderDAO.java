package app.model.dao;

import app.model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends GeneralDAO {
    public void save(Order order) {
        Connection connection = getConnection();
        String addOrder = "insert into ordern (client_name, order_name, master_name, master_status, mgr_status, price, order_date, review) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps= connection.prepareStatement(addOrder)){
            //ps.setObject(1, order.getId());
            ps.setString(1, order.getClientName());
            ps.setString(2, order.getOrderName());
            ps.setString(3, order.getMasterName());
            ps.setString(4, order.getMasterStatus());
            ps.setString(5, order.getMgrStatus());
            ps.setDouble(6, order.getPrice());
            ps.setObject(7, order.getDate());
            ps.setString(8, order.getReview());
            ps.execute();
            //System.out.println("Insert into orders success");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Order> showAllOrders(){
        Connection connection = getConnection();
        final String findAllOrders = "select*from ordern";
        List<Order> orders = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(findAllOrders);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                orders.add(new Order(
                        //(UUID) resultSet.getObject("id"),
                        resultSet.getInt("id"),
                        resultSet.getString("client_name"),
                        resultSet.getString("order_name"),
                        resultSet.getString("master_name"),
                        resultSet.getString("master_status"),
                        resultSet.getString("mgr_status"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getString("review")
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    public void alterByName(int columnCommand, String value, int id) {
        Connection connection = getConnection();
        final String alterByName;
        switch (columnCommand){
            case 1:
                alterByName = "update ordern set master_name = ? where id = ?";
                try(PreparedStatement ps = connection.prepareStatement(alterByName)){
                    ps.setString(1, value);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("Insert success");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 2:
                alterByName = "update ordern set mgr_status = ? where id = ?";
                try (PreparedStatement ps = connection.prepareStatement(alterByName)){
                    ps.setString(1, value);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("Insert success");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 3:
                alterByName = "update ordern set price = ? where id = ?";
                try(PreparedStatement ps = connection.prepareStatement(alterByName)){
                    ps.setDouble(1, Double.parseDouble(value));
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("Insert success");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 4:
                alterByName = "update ordern set master_status = ? where id = ?";
                try(PreparedStatement ps = connection.prepareStatement(alterByName)){
                    ps.setString(1, value);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("Insert success");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;

        }
    }

    public void alterReview(String value, String username, String orderName){
        Connection connection = getConnection();
        final String alterReview = "update ordern set review = ? where client_name = ? and order_name = ?";
        try(PreparedStatement ps = connection.prepareStatement(alterReview)){
            ps.setString(1, value);
            ps.setString(2, username);
            ps.setString(3, orderName);
            ps.executeUpdate();
            System.out.println("Review updated!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Order> findOrdersByUsername(String username){
        Connection connection = getConnection();
        final String findOrders = "select*from ordern where client_name = ?";
        List<Order> orders = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(findOrders);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                orders.add(new Order(
                        //(UUID) resultSet.getObject("id"),
                        resultSet.getInt("id"),
                        resultSet.getString("client_name"),
                        resultSet.getString("order_name"),
                        resultSet.getString("master_name"),
                        resultSet.getString("master_status"),
                        resultSet.getString("mgr_status"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getString("review")
                ));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }


}
