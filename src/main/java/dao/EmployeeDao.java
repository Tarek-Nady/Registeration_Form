package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class EmployeeDao {
    public int registerEmployee(Employee employee) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO employees"+"(id,firstname,lastname,username,password,address,contact) VALUES "+"(?,?,?,?,?,?,?);";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/formdatabase?useSSL=false","root","root")){
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setString(4,employee.getUserName());
            preparedStatement.setString(5,employee.getPassword());
            preparedStatement.setString(6,employee.getAddress());
            preparedStatement.setString(7,employee.getAddress());
            System.out.println("prepared statement");
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
