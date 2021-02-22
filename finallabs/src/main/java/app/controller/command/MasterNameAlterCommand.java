package app.controller.command;

import app.model.entity.UserAccount;
import app.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MasterNameAlterCommand extends AbstractCommand{
    OrderService service;

    public MasterNameAlterCommand(){
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String masterName = request.getParameter("masterName");
        try {
            service.AlterByUsername(1, id, masterName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/userInfo";
    }
}
