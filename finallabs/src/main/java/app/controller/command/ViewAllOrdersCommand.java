package app.controller.command;

import app.model.entity.Order;
import app.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ViewAllOrdersCommand extends AbstractCommand{

    private OrderService service;
    public ViewAllOrdersCommand(){
        this.service = new OrderService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //List<Order> orders = service.getAll();
            request.setAttribute("orderList", service.getAll());
        }
        catch (SQLException e){
            setErrorRequest(request, response, e.getMessage(), "/userInfo");
        }
        return "/viewAllOrders";
    }
}
