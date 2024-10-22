package com.example.data.bootstrap;

import com.example.data.domain.*;
import com.example.data.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final CareProviderRepository careProviderRepository;
    private final MedicalEncounterRepository medicalEncounterRepository;
    private final HealthIssueRepository healthIssueRepository;
    private final HealthServiceRepository healthServiceRepository;

    public DataLoader(
            PatientRepository patientRepository,
            CareProviderRepository careProviderRepository,
            MedicalEncounterRepository medicalEncounterRepository,
            HealthIssueRepository healthIssueRepository,
            HealthServiceRepository healthServiceRepository) {
        this.patientRepository = patientRepository;
        this.careProviderRepository = careProviderRepository;
        this.medicalEncounterRepository = medicalEncounterRepository;
        this.healthIssueRepository = healthIssueRepository;
        this.healthServiceRepository = healthServiceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient1 = new Patient("Dan Deaconu");
        patientRepository.save(patient1);

        CareProvider careProvider1 = new CareProvider("Dr. John Doe", "Dermatology");
        careProviderRepository.save(careProvider1);

        MedicalEncounter medicalEncounter1 = new MedicalEncounter(LocalDate.now(), patient1, careProvider1);
        medicalEncounterRepository.save(medicalEncounter1);

        HealthIssue healthIssue1 = new HealthIssue("Acne", patient1);
        healthIssueRepository.save(healthIssue1);

        HealthService healthService1 = new HealthService("Skin Condition", "Routine Check", medicalEncounter1);
        healthServiceRepository.save(healthService1);

        patient1.addHealthIssue(healthIssue1);
        patient1.addMedicalEncounter(medicalEncounter1);
        medicalEncounter1.addHealthService(healthService1);
        careProvider1.addMedicalEncounter(medicalEncounter1);

        patientRepository.save(patient1);
        medicalEncounterRepository.save(medicalEncounter1);
        careProviderRepository.save(careProvider1);
    }
}
