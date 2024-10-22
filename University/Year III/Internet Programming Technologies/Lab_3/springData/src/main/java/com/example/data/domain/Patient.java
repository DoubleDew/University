package com.example.data.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HealthIssue> healthIssue;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalEncounter> medicalEncounter;

    public Patient () {}

    public Patient(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<HealthIssue> getHealthIssues() { return healthIssue; }
    public void setHealthIssues(List<HealthIssue> healthIssues) {
        this.healthIssue = healthIssues;
    }

    public void addHealthIssue(HealthIssue healthIssue) {
        if(this.healthIssue == null)
            this.healthIssue = new ArrayList<>();
        this.healthIssue.add(healthIssue);
        healthIssue.setPatient(this);
    }

    public void addMedicalEncounter(MedicalEncounter medicalEncounters) {
        if(this.medicalEncounter == null)
            this.medicalEncounter = new ArrayList<>();
        this.medicalEncounter.add(medicalEncounters);
        medicalEncounters.setPatient(this);
    }
}
