package com.shane51.employee.repository.jdbc;

import com.shane51.employee.model.Employee;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryJdbcSafe extends EmployeeRepositoryJdbc {

    @Override
    public List<Employee> filterByUsername(String name) {
        final String SELECT_SQL = "select * from employee where name = ?";

        PreparedStatementCreator statementCreator = con -> {
            PreparedStatement ps = con.prepareStatement(SELECT_SQL);
            ps.setString(1, name);
            return ps;
        };

        return jdbcTemplate.query(statementCreator, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        final String SELECT_SQL = "select * from employee";

        PreparedStatementCreator statementCreator = con -> con.prepareStatement(SELECT_SQL);
        return jdbcTemplate.query(statementCreator, new EmployeeRowMapper());
    }

}
