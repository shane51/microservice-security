package com.shane51.employee.controller;

import com.shane51.employee.model.Employee;
import com.shane51.employee.repository.EmployeeRepository;
import com.shane51.employee.repository.jdbc.EmployeeRepositoryJdbcSafe;
import com.shane51.employee.repository.jdbc.EmployeeRepositoryJdbcUnSafe;
import com.shane51.employee.repository.jdbc.GlobalRepositoryJdbc;
import com.shane51.employee.repository.jpa.EmployeeRepositoryJpaSafe;
import com.shane51.employee.repository.jpa.EmployeeRepositoryJpaUnSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeRepositoryJdbcUnSafe repositoryJdbcUnSafe;

    @Autowired
    private EmployeeRepositoryJdbcSafe repositoryJdbcSafe;

    @Autowired
    private EmployeeRepositoryJpaUnSafe repositoryJpaUnSafe;

    @Autowired
    private EmployeeRepositoryJpaSafe repositoryJpaSafe;

    @Autowired
    private GlobalRepositoryJdbc globalRepositoryJdbc;

    @GetMapping("/filterUserUnSafe")
    public List<Employee> filterByUsernameUnSafe(@RequestParam(value = "name") String name) {
        return repository.filterByUsername(name);
    }

    @GetMapping("/filterUserJdbcUnSafe")
    public List<Employee> filterByUsernameJdbcUnSafe(@RequestParam(value = "name") String name) {
        return repositoryJdbcUnSafe.filterByUsername(name);
    }

    @GetMapping("/filterUserJdbcSafe")
    public List<Employee> filterByUsernameJdbcSafe(@RequestParam(value = "name") String name) {
        return repositoryJdbcSafe.filterByUsername(name);
    }

    @GetMapping("/filterUserJpaUnSafe")
    public List<Employee> filterByUsernameJpaUnSafe(@RequestParam(value = "name") String name) {
        return repositoryJpaUnSafe.filterByUsername(name);
    }

    @GetMapping("/filterUserJpaSafe")
    public List<Employee> filterByUsernameJpaSafe(@RequestParam(value = "name") String name) {
        return repositoryJpaSafe.filterByUsername(name);
    }

    @GetMapping("/filterUserJpaStoredProcedureUnSafe")
    public List<Employee> filterByUsernameJpaStoredProcedureUnSafe(@RequestParam(value = "name") String name) {
        return repositoryJpaUnSafe.filterByUsernameStoredProcedure(name);
    }


    @GetMapping("/filterUserJpaStoredProcedureSafe")
    public List<Employee> filterByUsernameJpaStoredProcedureSafe(@RequestParam(value = "name") String name) {
        return repositoryJpaSafe.filterByUsernameStoredProcedure(name);
    }

    @GetMapping("/loginJdbcUnSafe")
    public Employee loginJdbcUnSafe(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        return globalRepositoryJdbc.login(name, password);
    }

    @GetMapping("/filterUserGlobalAccessUnSafe")
    public List<Employee> filterByUsernameGlobalAccessUnSafe(@RequestParam(value = "name") String name) {
        return globalRepositoryJdbc.filterByUsername(name);
    }

    @PostMapping("/")
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.add(employee);
    }


    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }


    @GetMapping("/")
    public List<Employee> findAll() {
        LOGGER.info("Employee find all");
        return repository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        return repository.findByDepartment(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        return repository.findByOrganization(organizationId);
    }

}