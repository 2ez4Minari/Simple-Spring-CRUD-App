package com.ing.springbootapp.Infrastructure.Repository;

import com.ing.springbootapp.Infrastructure.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository <CustomerEntity, Long> {
    List<CustomerEntity> findAll();

    CustomerEntity findById(long id);

    void deleteById(long id);
}
