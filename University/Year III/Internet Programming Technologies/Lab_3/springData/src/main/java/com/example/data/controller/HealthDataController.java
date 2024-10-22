package com.example.data.controller;

import com.example.data.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/healthData")
public class HealthDataController {

    private final HealthIssueRepository healthIssueRepository;
    private final PatientRepository patientRepository;
    private final CareProviderRepository careProviderRepository;
    private final MedicalEncounterRepository medicalEncounterRepository;
    private final HealthServiceRepository healthServiceRepository;

    @Autowired
    public HealthDataController(HealthIssueRepository healthIssueRepository, PatientRepository patientRepository, CareProviderRepository careProviderRepository, MedicalEncounterRepository medicalEncounterRepository, HealthServiceRepository healthServiceRepository) {
        this.healthIssueRepository = healthIssueRepository;
        this.patientRepository = patientRepository;
        this.careProviderRepository = careProviderRepository;
        this.medicalEncounterRepository = medicalEncounterRepository;
        this.healthServiceRepository = healthServiceRepository;
    }

    @GetMapping("/patient/{id}/healthIssues")
    public String getAllHealthIssues(@PathVariable Long id, Model model) {
        model.addAttribute("healthIssues", healthIssueRepository.findAllByPatientId(id));
        model.addAttribute("healthIssuesWithService", healthIssueRepository.findWithHealthServicesByPatientId(id));
        return "health_issues";
    }

    @GetMapping("/encounters/date/{date}")
    public String getAllPatientsByDate(@PathVariable String date, Model model) {
        model.addAttribute("patients", patientRepository.findAllWhoHadEncountersOnDate(LocalDate.parse(date)));
        return "patients_by_date";
    }

    @GetMapping("/careProvider/{name}/patients")
    public String getAllPatientsOfCareProvider(@PathVariable String name, Model model) {
        model.addAttribute("patients", careProviderRepository.findAllPatientsByCareProviderName(name));
        return "careprovider_patients";
    }

    @GetMapping("/healthIssue/{type}/careProviders")
    public String getAllCareProvidersByIssueType(@PathVariable String type, Model model) {
        model.addAttribute("careProviders", careProviderRepository.findAllByHealthIssueType(type));
        return "issue_careproviders";
    }
}