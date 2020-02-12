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
@Entity(name = "CUSTOMER")
public class CustomerEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUST_NAME")
    private String name;

    @Column(name = "CUST_ADDRESS")
    private String address;

    @Column(name = "CUST_JOB")
    private String job;
}
