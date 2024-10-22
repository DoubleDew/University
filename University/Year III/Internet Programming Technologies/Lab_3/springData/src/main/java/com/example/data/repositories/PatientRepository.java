package com.example.data.repositories;

import com.example.data.domain.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    @Query("SELECT DISTINCT p FROM Patient p JOIN p.medicalEncounter e WHERE e.date = :date")
    List<Patient> findAllWhoHadEncountersOnDate(@Param("date") LocalDate date);
}
