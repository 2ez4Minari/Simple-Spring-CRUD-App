package com.ing.springbootapp.Configuration;

import com.ing.springbootapp.Core.Service.CustomerService;
import com.ing.springbootapp.Core.Service.Impl.CustomerServiceImpl;
import com.ing.springbootapp.Infrastructure.Repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }
}
