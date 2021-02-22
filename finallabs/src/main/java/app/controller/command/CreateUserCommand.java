package app.controller.command;

import app.model.entity.Order;
import app.model.entity.UserAccount;
import app.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.sql.SQLException;

public class CreateUserCommand extends AbstractCommand {
    private UserService service;

    public CreateUserCommand(){
        this.service = new UserService();

    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            UserAccount user = getUser(request);
            service.insertUser(user);
            if(user == null){
                System.out.println("User insert error");
            }
        }catch (SQLException e){
            setErrorRequest(request, response, e.getMessage(), "/userInfo");
        }
        return "/userInfo";
    }

    public UserAccount getUser(HttpServletRequest req){
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String roles = req.getParameter("roles");
        UserAccount user = new UserAccount(userName, password, 0, roles);
        return user;
    }
}
