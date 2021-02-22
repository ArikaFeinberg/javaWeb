package app.controller.command;

import app.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PriceAlterCommand extends AbstractCommand{
    OrderService service;

    public PriceAlterCommand(){
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String masterName = request.getParameter("price");
        try {
            service.AlterByUsername(3, id, masterName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/userInfo";
    }
}
