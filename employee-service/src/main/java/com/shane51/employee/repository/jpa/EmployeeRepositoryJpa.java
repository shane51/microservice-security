package com.shane51.employee.repository.jpa;

import com.shane51.employee.Configuration;
import com.shane51.employee.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public abstract class EmployeeRepositoryJpa {

    @PersistenceContext(unitName = Configuration.JPA_EMPDB_PERSITENCE_UNIT)
    @Qualifier("empdbEntityManager")
    protected EntityManager em;

    public abstract List<Employee> filterByUsername(String name);

    public abstract List<Employee> filterByUsernameStoredProcedure(String name);

    @Transactional
    public Employee save(Employee employee) {
        em.persist(employee);
        return employee;
    }

}