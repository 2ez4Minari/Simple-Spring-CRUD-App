package com.ing.springbootapp.Infrastructure.Repository;

import com.ing.springbootapp.Infrastructure.Entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository <JobEntity, Long> {
    JobEntity findById(long id);
}
