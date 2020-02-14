package com.ing.springbootapp.Core.Service.Impl;

import com.ing.springbootapp.Core.Employee;
import com.ing.springbootapp.Core.Job;
import com.ing.springbootapp.Core.Service.EmployeeService;
import com.ing.springbootapp.Infrastructure.Entity.EmployeeEntity;
import com.ing.springbootapp.Infrastructure.Entity.JobEntity;
import com.ing.springbootapp.Infrastructure.Repository.EmployeeRepository;
import com.ing.springbootapp.Infrastructure.Repository.JobRepository;
import com.ing.springbootapp.Presentation.DTO.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private JobRepository jobRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
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
                    .job(getJob(employeeEntity))
                    .build();
            employees.add(employee);
        }
        return employees;
    }

    private Job getJob(EmployeeEntity employeeEntity) {
        return Job.builder()
                .id(employeeEntity.getJobEntity().getId())
                .jobDesc(employeeEntity.getJobEntity().getJobDesc())
                .jobPos(employeeEntity.getJobEntity().getJobPos())
                .build();
    }

    @Override
    public String createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name(employeeDTO.getName())
                .address(employeeDTO.getAddress())
                .jobEntity(getJobEntity(employeeDTO))
                .build();
        employeeRepository.save(employeeEntity);
        return "Success";
    }

    private JobEntity getJobEntity(EmployeeDTO employeeDTO) {
        return JobEntity.builder()
                .id(employeeDTO.getJobEntity().getId())
                .jobDesc(employeeDTO.getJobEntity().getJobDesc())
                .jobPos(employeeDTO.getJobEntity().getJobPos())
                .build();
    }

    @Override
    public String updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setJobEntity(employeeDTO.getJobEntity());
        employeeRepository.save(employeeEntity);
        return "Success";
    }

    @Override
    public String deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return "Success";
    }


}
