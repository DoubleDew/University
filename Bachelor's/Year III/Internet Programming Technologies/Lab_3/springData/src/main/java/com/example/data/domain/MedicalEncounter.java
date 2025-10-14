package com.example.data.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
public class MedicalEncounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "careProvider_id")
    private CareProvider careProvider;

    @OneToMany(mappedBy = "medicalEncounter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HealthService> healthService;

    public MedicalEncounter() {}

    public MedicalEncounter(LocalDate date, Patient patient, CareProvider careProvider){
        this.date = date;
        this.patient = patient;
        this.careProvider = careProvider;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public CareProvider getCareProvider() {
        return careProvider;
    }
    public void setCareProvider(CareProvider careProvider) {
        this.careProvider = careProvider;
    }

    public List<HealthService> getHealthService() {
        return healthService;
    }
    public void setHealthService(List<HealthService> healthServices) {
        this.healthService = healthService;
    }

    public void addHealthService(HealthService healthService){
        if(this.healthService == null)
            this.healthService = new ArrayList<>();
        this.healthService.add(healthService);
        healthService.setMedicalEncounter(this);
    }
}
