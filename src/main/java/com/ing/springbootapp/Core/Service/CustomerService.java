package com.ing.springbootapp.Core.Service;

import com.ing.springbootapp.Core.Customer;
import com.ing.springbootapp.Presentation.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomer();

    String createCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    String deleteCustomer(long id);
}
