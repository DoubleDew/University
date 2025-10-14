package com.example.data.repositories;

import com.example.data.domain.HealthService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthServiceRepository extends CrudRepository<HealthService, Long> {
    List<HealthService> findHealthServiceById(Long id);
}
