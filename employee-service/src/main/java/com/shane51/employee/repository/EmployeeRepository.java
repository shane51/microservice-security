package com.shane51.employee.repository;

import com.shane51.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public Employee add(Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employees.stream().filter(p -> p.getId().equals(id)).findFirst();
        return employee.orElse(null);
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream().filter(p -> p.getDepartmentId().equals(departmentId)).collect(Collectors.toList());

    }

    public List<Employee> findByOrganization(Long organizationId) {
        return employees.stream().filter(p -> p.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }
}