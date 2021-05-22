package com.shane51.employee;


import com.shane51.employee.model.Employee;
import com.shane51.employee.model.Role;
import com.shane51.employee.repository.jpa.EmployeeRepositoryJpaSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    final static Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(EmployeeRepositoryJpaSafe repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo", "secret", Role.MANAGER)));
            log.info("Preloading " + repository.save(new Employee("Frodo", "secret2", Role.STAFF)));
        };
    }
}