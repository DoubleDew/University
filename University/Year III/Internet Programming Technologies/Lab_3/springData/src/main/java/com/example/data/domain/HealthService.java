package com.example.data.domain;

import jakarta.persistence.*;

@Entity
public class HealthService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;

    @ManyToOne
    @JoinColumn(name = "medicalEncounter_id")
    private MedicalEncounter medicalEncounter;

    public HealthService(String description, String type, MedicalEncounter medicalEncounter){
        this.description = description;
        this.type = type;
        this.medicalEncounter = medicalEncounter;
    }

    public HealthService() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public String getType() {
        return type;
    }
    public void setType(String type) { this.type = type; }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) { this.description = description; }

    public MedicalEncounter getMedicalEncounter() {
        return medicalEncounter;
    }
    public void setMedicalEncounter(MedicalEncounter medicalEncounter) {
        this.medicalEncounter = medicalEncounter;
        if(medicalEncounter != null && !medicalEncounter.getHealthService().contains(this))
            medicalEncounter.getHealthService().add(this);
    }
}
