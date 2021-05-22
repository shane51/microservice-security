package com.shane51.employee.repository;

import com.shane51.employee.model.Employee;
import com.shane51.employee.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private DataSource dataSource;

    public List<Employee> filterByUsername(String name) {

        String sql = "select * from employee where name ='" + name + "'";

        try (Connection c = dataSource.getConnection();
             ResultSet rs = c.createStatement().executeQuery(sql)) {
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role"))
                ));
            }
            return employees;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public Employee add(Employee employee) {
        return null;
    }

    public Employee findById(Long id) {
        return null;
    }

    public List<Employee> findAll() {
        return null;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return null;
    }

    public List<Employee> findByOrganization(Long organizationId) {
        return null;
    }
}
