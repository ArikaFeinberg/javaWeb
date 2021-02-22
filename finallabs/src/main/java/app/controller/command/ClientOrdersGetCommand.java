package app.controller.command;

import app.model.entity.Order;
import app.model.entity.UserAccount;
import app.model.service.OrderService;
import app.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClientOrdersGetCommand extends AbstractCommand{
    private OrderService orderService;
    public ClientOrdersGetCommand(){
        this.orderService = new OrderService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
        String clientName = loginedUser.getUserName();
        List<Order> orders = null;
        try{
            //orders = orderService.findOrdersByUsername(clientName);
            request.setAttribute("orderList", orderService.findOrdersByUsername(clientName));
        } catch (SQLException throwables){
            request.setAttribute("error", "Sorry, some problems on our server");
            request.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp").forward(request, response);
        }
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/WEB-INF/views/showOrders.jsp").forward(request, response);
        return "/userOrders";
    }
}
