package app.model.dao;

import app.model.entity.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends GeneralDAO {
    //private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

    // Find a User by userName and password.
    public static UserAccount findUser1(String userName, String password) throws SQLException {
        // UserAccount u = mapUsers.get(userName);
        //  UserAccount user = DataDAO.findUserByName(userName, password);
        final String findByUserName = "select*from users where username = ? and password = ?";
        Connection connection = getConnection();
        UserAccount user = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(findByUserName);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()){
                user = new UserAccount(
                        //res.getInt("id"),
                        res.getString("username"),
                        res.getString("password"),
                        //UserAccount.GENDER_MALE,
                        res.getDouble("count"),
                        res.getString("role")
                        //String.valueOf(res.getDouble("count"))
                );
            }
            System.out.println("Success");
            //mapUsers.put(userName, user);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return user;

    }


    public List<UserAccount> showAllUsers(){
        final String findAllUsers = "select*from users";
        List<UserAccount> users = new ArrayList<>();
        Connection connection = getConnection();
        try(ResultSet resultSet = connection.createStatement().executeQuery(findAllUsers)){
            while(resultSet.next()){
                users.add(new UserAccount(
                        //resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        //UserAccount.GENDER_MALE,
                        resultSet.getDouble("count"),
                        resultSet.getString("role")

                ));
            }

        }
        catch (Exception e){
            e.printStackTrace();

        }
        for(int i = 0; i< users.size(); i++){
            System.out.println(users.get(i).getUserName()+" ");
        }
        return users;
    }

    public UserAccount save (UserAccount user){
        String errorDisplay = user.getRoles().toString();
        errorDisplay = errorDisplay.substring(1, errorDisplay.length()-1);
        final String addNewUser = "INSERT INTO users(username, password, role) VALUES (?, ?, ?);";
        //final String updateUser = "update users set username = ?, password = ?, role = ? where id = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(addNewUser);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            //preparedStatement.setInt(1, user.getId());
            assert preparedStatement != null;
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, errorDisplay);
            //preparedStatement.setDouble(4, user.getCount());
            preparedStatement.execute();
            System.out.println("Insert success"+user);

        } catch (Exception e){
            System.out.println("Something wrong");
            e.printStackTrace();
        }
        return user;
    }


    public void alterCount(double value, String username){
        Connection connection = getConnection();
        final String alterReview = "update users set count = ? where username = ?";
        try(PreparedStatement ps = connection.prepareStatement(alterReview)){
            ps.setDouble(1, value);
            ps.setString(2, username);
            //ps.setString(3, orderName);
            ps.executeUpdate();
            //System.out.println("Review updated!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}

