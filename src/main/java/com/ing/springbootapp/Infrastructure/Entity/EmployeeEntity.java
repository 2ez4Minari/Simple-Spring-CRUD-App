package com.ing.springbootapp.Infrastructure.Entity;

import com.ing.springbootapp.Core.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMP_NAME")
    private String name;

    @Column(name = "EMP_ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "EMP_JOB_ID", referencedColumnName = "JOB_ID")
    private JobEntity jobEntity;
}
