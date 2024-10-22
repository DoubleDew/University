package com.example.data.repositories;

import com.example.data.domain.HealthIssue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HealthIssueRepository extends CrudRepository<HealthIssue, Long> {
    List<HealthIssue> findHealthIssueById(Long id);

    @Query("SELECT h FROM HealthIssue h WHERE h.patient.id = :patientId")
    List<HealthIssue> findAllByPatientId(@Param("patientId") Long patientId);

    @Query("SELECT h FROM HealthIssue h WHERE h.patient.id = :patientId AND EXISTS (SELECT e FROM MedicalEncounter e WHERE e.patient.id = h.patient.id AND e.healthService IS NOT EMPTY)")
    List<HealthIssue> findWithHealthServicesByPatientId(@Param("patientId") Long patientId);
}
