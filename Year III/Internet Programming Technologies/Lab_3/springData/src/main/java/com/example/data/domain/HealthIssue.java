package com.example.data.domain;

import jakarta.persistence.*;

@Entity
public class HealthIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public HealthIssue() {}

    public HealthIssue(String type, Patient patient){
       this.type = type;
       this.patient = patient;
   }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
        if(patient != null && !patient.getHealthIssues().contains(this))
            patient.getHealthIssues().add(this);
    }
}