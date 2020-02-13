package com.ing.springbootapp.Infrastructure.Repository;

import com.ing.springbootapp.Infrastructure.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Long> {
    List<EmployeeEntity> findAll();

    EmployeeEntity findById(long id);

    void deleteById(long id);
}
