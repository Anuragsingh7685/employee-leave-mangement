package com.example.employeeleavemanagement.config;

import com.example.employeeleavemanagement.model.Employee;
import com.example.employeeleavemanagement.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository) {
        return args -> {
            if(employeeRepository.count() == 0) {
                employeeRepository.save(Employee.builder().name("Alice HR").email("alice@example.com").role("ADMIN").password("pass").build());
                employeeRepository.save(Employee.builder().name("Bob Manager").email("bob@example.com").role("MANAGER").password("pass").build());
                employeeRepository.save(Employee.builder().name("Charlie Employee").email("charlie@example.com").role("EMPLOYEE").password("pass").build());
            }
        };
    }
}
