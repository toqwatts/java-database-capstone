package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.sql.Driver;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Doctor doctor;

    @ManyToOne
    @NotNull
    private Patient patient;

    @Future
    @NotNull
    private LocalDateTime appointmentTime;

    @NotNull
    private int status;

    // Getters and Setters
    @Transient
    private LocalDateTime getEndTime(){
        return appointmentTime.plusHours(1);
    };
    @Transient
    private LocalDate getAppointmentDate(){
        return this.appointmentTime.toLocalDate();
    }
    public LocalTime getAppointmentTimeOnly(){
        return appointmentTime.toLocalTime();
    }
    public Long getId() {
        return id;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}