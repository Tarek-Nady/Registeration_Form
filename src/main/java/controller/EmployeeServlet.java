package controller;

import dao.EmployeeDao;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    EmployeeDao employeeDao = new EmployeeDao();
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/employeeregister.jsp");
        dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Employee employee = new Employee();
        employee.setFirstName(firstname);
        employee.setLastName(lastname);
        employee.setUserName(username);
        employee.setPassword(password);
        employee.setAddress(address);
        employee.setContact(contact);
        try {
            employeeDao.registerEmployee(employee);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/views/employeeDetails.jsp");
    }
}
