package com.project.back_end.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.lang.annotation.Inherited;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 3, max = 50)
    private String specialty;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8, max =20)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    @ElementCollection
    private List<String> availableTimes;

    // Getters and Setters
    public String getName(){
        return name;
    }
    public String getSpecialty(){
        return specialty;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return phone;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
}