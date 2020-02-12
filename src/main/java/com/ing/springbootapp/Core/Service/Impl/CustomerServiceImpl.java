package com.ing.springbootapp.Core.Service.Impl;

import com.ing.springbootapp.Core.Customer;
import com.ing.springbootapp.Core.Service.CustomerService;
import com.ing.springbootapp.Infrastructure.Entity.CustomerEntity;
import com.ing.springbootapp.Infrastructure.Repository.CustomerRepository;
import com.ing.springbootapp.Presentation.DTO.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @Override
    public List<Customer> getCustomer() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        for (CustomerEntity customerEntity: customerEntities) {
            Customer customer = Customer.builder()
                    .id(customerEntity.getId())
                    .name(customerEntity.getName())
                    .address(customerEntity.getAddress())
                    .job(customerEntity.getJob())
                    .build();
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public String createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customerDTO.getName())
                .address(customerDTO.getAddress())
                .job(customerDTO.getJob())
                .build();
        customerRepository.save(customerEntity);
        return "Success";
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerRepository.findById(customerDTO.getId());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setJob(customerDTO.getJob());
        customerRepository.save(customerEntity);
        return "Success";
    }

    @Override
    public String deleteCustomer(long id) {
        customerRepository.deleteById(id);
        return "Success";
    }


}
