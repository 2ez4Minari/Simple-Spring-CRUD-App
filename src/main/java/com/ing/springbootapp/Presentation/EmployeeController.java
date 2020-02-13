package com.ing.springbootapp.Presentation;

import com.ing.springbootapp.Core.Employee;
import com.ing.springbootapp.Core.Service.EmployeeService;
import com.ing.springbootapp.Presentation.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/app/Employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/getall")
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @PostMapping(value = "/createnewEmployee")
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping(value = "/updateEmployee")
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping(value = "/deleteEmployee")
    public String deleteEmployee(@RequestParam long id){
        return employeeService.deleteEmployee(id);
    }

}
