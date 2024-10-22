package com.example.data.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class CareProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String specialty;

    @OneToMany(mappedBy = "careProvider")
    private List<MedicalEncounter> medicalEncounter;

    public CareProvider(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public CareProvider() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() { return specialty; }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<MedicalEncounter> getMedicalEncounter() { return medicalEncounter; }

    public void setMedicalEncounter(List<MedicalEncounter> medicalEncounter){
        this.medicalEncounter = medicalEncounter;
    }

    public void addMedicalEncounter(MedicalEncounter medicalEncounter){
        if(this.medicalEncounter == null)
            this.medicalEncounter = new ArrayList<>();
        this.medicalEncounter.add(medicalEncounter);
        medicalEncounter.setCareProvider(this);
    }
}
