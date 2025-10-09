package com.project.back_end.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    private String prescription;

    @NotNull
    private Long appointmentId;

    @NotNull
    @Size(min = 3, max = 100)
    private String medication;

    @Size(max = 200)
    private String doctorNotes;

    // Constructor
    public Prescription(String prescription, Long appointmentId, String medication) {
        this.prescription = prescription;
        this.appointmentId = appointmentId;
        this.medication = medication;
    }

    // Getters and Setters

    public String getPrescription() {
        return prescription;
    }
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public Long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
    public String getMedication() {
        return medication;
    }
    public void setMedication(String medication) {
        this.medication = medication;
    }
    public String getDoctorNotes() {
        return doctorNotes;
    }
    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }
}