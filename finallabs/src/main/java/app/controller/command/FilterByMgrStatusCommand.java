package app.controller.command;

import app.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FilterByMgrStatusCommand extends AbstractCommand{
    private OrderService service;

    public FilterByMgrStatusCommand(){
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            //List<Order> orders = service.getAll();
            String mgrStatus = request.getParameter("mgrStatus");
            request.setAttribute("orderList", OrderService.filterByMgrStatus(mgrStatus));
        }
        catch (SQLException e){
            setErrorRequest(request, response, e.getMessage(), "/userInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/views/showOrders.jsp";
    }
}
