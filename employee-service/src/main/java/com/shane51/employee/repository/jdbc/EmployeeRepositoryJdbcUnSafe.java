package com.shane51.employee.repository.jdbc;

import com.shane51.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryJdbcUnSafe extends EmployeeRepositoryJdbc {

    @Override
    public List<Employee> filterByUsername(String name) {
        return jdbcTemplate.query("select * from employee where name ='" + name + "'", new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
    }



}
