package app.controller.command;

import app.model.service.OrderService;
import app.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ViewAllUsersCommand extends AbstractCommand{
    private UserService service;
    public ViewAllUsersCommand(){
        this.service = new UserService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //List<Order> orders = service.getAll();
            request.setAttribute("userList", service.getAll());
        }
        catch (SQLException e){
            setErrorRequest(request, response, e.getMessage(), "/userInfo");
        }
        return "/viewAllUsers";
    }
}
