package com.hwj.banking.Controller;

import com.hwj.banking.Service.UserService;
import com.hwj.banking.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {

    private static String ERROR_PAGE = "/error.jsp";
    private static String HOME_PAGE = "/home.jsp";
    private static String WRONG_COMMAND_PAGE = "/wrong.jsp";
    UserService userService;
    String forward = "";

    public UserController() {
        super();
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserService userService = new UserService();
        int flag = -1;
        if (action.equalsIgnoreCase("delete")) {
            int userId = Integer.parseInt(request.getParameter("id"));
            flag = userService.deleteUser(userId);
        } else if (action.equalsIgnoreCase("queryOne")) {
            int userId = Integer.parseInt(request.getParameter("id"));
            String userInfo = userService.findUser(userId);
            flag = userInfo == ""? -1 : 1;
        } else if (action.equalsIgnoreCase("queryAll")) {
            List<User> users = userService.findUsers();
            flag = 1;
        }

        if (flag == 1) {
            forward = HOME_PAGE;
        } else if (flag == -1){
            forward = ERROR_PAGE;
        } else {
            forward = WRONG_COMMAND_PAGE;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
//        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        UserService userService = new UserService();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String remark = request.getParameter("remark");
        int flag = 0;
        if (action.equalsIgnoreCase("add")) {
            int id = Integer.parseInt(request.getParameter("id"));
            flag = userService.updateUser(id, name, password, email, phone, remark);
        } else if (action.equalsIgnoreCase("update")) {
            flag = userService.addUser(name, password, email, phone, remark);
        }

        if (flag == 1) {
            forward = HOME_PAGE;
        } else if (flag == -1){
            forward = ERROR_PAGE;
        } else {
            forward = WRONG_COMMAND_PAGE;
        }


        RequestDispatcher view = request.getRequestDispatcher(forward);
//        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }

}
