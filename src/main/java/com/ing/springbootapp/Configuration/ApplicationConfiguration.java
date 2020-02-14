package com.ing.springbootapp.Configuration;

import com.ing.springbootapp.Core.Service.EmployeeService;
import com.ing.springbootapp.Core.Service.Impl.EmployeeServiceImpl;
import com.ing.springbootapp.Infrastructure.Repository.EmployeeRepository;
import com.ing.springbootapp.Infrastructure.Repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    EmployeeService customerService(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        return new EmployeeServiceImpl(employeeRepository, jobRepository);
    }
}
