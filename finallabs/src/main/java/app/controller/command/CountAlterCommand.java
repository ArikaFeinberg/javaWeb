package app.controller.command;

import app.model.service.OrderService;
import app.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountAlterCommand extends AbstractCommand{
    UserService service;

    public CountAlterCommand(){
        this.service = new UserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String value = request.getParameter("value");
        //int id = Integer.parseInt(request.getParameter("id"));
        //String count = request.getParameter("count");
        try {
            UserService.alterCount(Double.parseDouble(value), userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/userInfo";
    }

}
