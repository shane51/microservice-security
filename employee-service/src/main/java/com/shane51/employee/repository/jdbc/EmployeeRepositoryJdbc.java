package com.shane51.employee.repository.jdbc;

import com.shane51.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class EmployeeRepositoryJdbc {

    @Autowired
    @Qualifier("empdbJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    public abstract List<Employee> filterByUsername(String name);
    public abstract List<Employee> findAll();

}
