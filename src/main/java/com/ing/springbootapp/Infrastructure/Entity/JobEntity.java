package com.ing.springbootapp.Infrastructure.Entity;

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
@Table(name = "JOB")
public class JobEntity {

    @Id
    @Column(name = "JOB_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "JOB_DESC")
    private String jobDesc;

    @Column(name = "JOB_POS")
    private String jobPos;
}
