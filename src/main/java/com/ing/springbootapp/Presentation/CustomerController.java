package com.ing.springbootapp.Presentation;

import com.ing.springbootapp.Core.Customer;
import com.ing.springbootapp.Core.Service.CustomerService;
import com.ing.springbootapp.Presentation.DTO.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/app/Customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/getall")
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @PostMapping(value = "/createnewcustomer")
    public String createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping(value = "/updatecustomer")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping(value = "/deletecustomer")
    public String deleteCustomer(@RequestParam long id){
        return customerService.deleteCustomer(id);
    }

}
