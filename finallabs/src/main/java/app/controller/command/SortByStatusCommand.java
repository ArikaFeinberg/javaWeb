package app.controller.command;

import app.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SortByStatusCommand extends AbstractCommand {
    private OrderService service;

    public SortByStatusCommand(){
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //List<Order> orders = service.getAll();
            request.setAttribute("orderList", service.sortByStatus());
        }
        catch (SQLException e){
            setErrorRequest(request, response, e.getMessage(), "/userInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/viewAllOrders";
    }
}
