package com.example.data.repositories;

import com.example.data.domain.MedicalEncounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalEncounterRepository extends CrudRepository<MedicalEncounter, Long> {
    List<MedicalEncounter> findMedicalEncounterById(Long id);
}
