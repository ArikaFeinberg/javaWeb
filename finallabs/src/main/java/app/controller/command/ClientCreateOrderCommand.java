package app.controller.command;

import app.model.entity.Order;
import app.model.entity.UserAccount;
import app.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ClientCreateOrderCommand extends AbstractCommand {
    private OrderService service;

    public ClientCreateOrderCommand(){
        this.service = new OrderService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            Order order = getOrder(request);
            service.insertOrder(order);
        }catch (SQLException e){
            setErrorRequest(request, response, e.getMessage(), "/userInfo");
        }
        return "/userInfo";
    }

    private Order getOrder(HttpServletRequest req){
        //Order order = null;
        HttpSession session = req.getSession();
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
        String clientName = loginedUser.getUserName();
        String orderName = req.getParameter("orderName");
        int day = Integer.parseInt(req.getParameter("day"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));
        Order order = new Order(0, clientName, orderName, "no data", "no data", "no data", 0, LocalDate.of(year, month, day), "no data");
        return order;
    }
}
