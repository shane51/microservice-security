package com.shane51.employee.repository.jdbc;


import com.shane51.employee.model.Employee;
import com.shane51.employee.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("password"),
                Role.valueOf(rs.getString("role"))
        );
    }
}
