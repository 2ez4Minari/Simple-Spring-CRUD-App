package com.ing.springbootapp.Presentation.DTO;

import com.ing.springbootapp.Infrastructure.Entity.JobEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
    private String name;
    private String address;
    private JobEntity jobEntity;
}
