package in.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.kce.bean.Employee;
import in.kce.util.DBUtil;

public class EmployeeDAO {

    // Store Employee
    public boolean saveEmployee(Employee employee) {
        Connection connection = DBUtil.getConnection();
        String query = "INSERT INTO employee VALUES(?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getEmpName());
            ps.setString(3, employee.getDesignation());

            int row = ps.executeUpdate();

            if (row >= 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update Employee
    public boolean updateEmployee(Employee employee) {
        Connection connection = DBUtil.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE employee SET empname=?, designation=? WHERE empid=?");

            ps.setString(1, employee.getEmpName());
            ps.setString(2, employee.getDesignation());
            ps.setInt(3, employee.getEmpId());

            int row = ps.executeUpdate();

            if (row >= 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Employee
    public boolean deleteEmployee(String empId) {
        Connection connection = DBUtil.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM employee WHERE empid=?");

            ps.setString(1, empId);

            int row = ps.executeUpdate();

            if (row >= 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Fetch One Employee
    public Employee getEmployee(String empId) {
        Connection connection = DBUtil.getConnection();
        Employee emp = null;

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM employee WHERE empid=?");

            ps.setString(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employee();

                emp.setEmpId(rs.getInt(1));
                emp.setEmpName(rs.getString(2));
                emp.setDesignation(rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }

    // Fetch All Employees
    public ArrayList<Employee> getAllEmployees() {

        Connection connection = DBUtil.getConnection();
        String query = "SELECT * FROM employee2";

        ArrayList<Employee> al = new ArrayList<Employee>();

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee emp = new Employee();

                emp.setEmpId(rs.getInt(1));
                emp.setEmpName(rs.getString(2));
                emp.setDesignation(rs.getString(3));

                al.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return al;
    }
}