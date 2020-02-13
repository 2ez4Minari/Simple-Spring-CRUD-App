package com.ing.springbootapp.Core.Service.Impl;

import com.ing.springbootapp.Core.Employee;
import com.ing.springbootapp.Core.Service.EmployeeService;
import com.ing.springbootapp.Infrastructure.Entity.EmployeeEntity;
import com.ing.springbootapp.Infrastructure.Repository.EmployeeRepository;
import com.ing.springbootapp.Presentation.DTO.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public List<Employee> getEmployee() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEntity> EmployeeEntities = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity : EmployeeEntities) {
            Employee employee = Employee.builder()
                    .id(employeeEntity.getId())
                    .name(employeeEntity.getName())
                    .address(employeeEntity.getAddress())
                    .job(employeeEntity.getJob())
                    .build();
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public String createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name(employeeDTO.getName())
                .address(employeeDTO.getAddress())
                .job(employeeDTO.getJob())
                .build();
        employeeRepository.save(employeeEntity);
        return "Success";
    }

    @Override
    public String updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setJob(employeeDTO.getJob());
        employeeRepository.save(employeeEntity);
        return "Success";
    }

    @Override
    public String deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return "Success";
    }


}
