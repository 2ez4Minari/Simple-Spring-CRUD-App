package com.ing.springbootapp.Core.Service;

import com.ing.springbootapp.Core.Employee;
import com.ing.springbootapp.Presentation.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee();

    String createEmployee(EmployeeDTO employeeDTO);

    String updateEmployee(EmployeeDTO employeeDTO);

    String deleteEmployee(long id);
}
