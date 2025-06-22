package com.example.GestionPatient.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Entity class representing a Patient in the system.
 */
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50, message = "Name must not exceed 50 characters")
    public String nom;

    @NotBlank(message = "First name cannot be empty")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String prenom;

    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    @NotBlank(message = "Address cannot be empty")
    @Size(max = 100, message = "Address must not exceed 100 characters")
    private String adresse;

    @NotBlank(message = "Phone number cannot be empty")
    @Size(max = 15, message = "Phone number must not exceed 15 characters")
    private String numeroTelephone;

    // Default constructor
    public Patient() {}

    // Parameterized constructor
    public Patient(String nom, String prenom, int age, String adresse, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    // toString method for readable object representation
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", adresse='" + adresse + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                '}';
    }

    // equals method for comparing Patient objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.example.GestionPatient.entities.Patient patient = (com.example.GestionPatient.entities.Patient) o;
        return age == patient.age &&
                Objects.equals(id, patient.id) &&
                Objects.equals(nom, patient.nom) &&
                Objects.equals(prenom, patient.prenom) &&
                Objects.equals(adresse, patient.adresse) &&
                Objects.equals(numeroTelephone, patient.numeroTelephone);
    }

    // hashCode method for consistent hashing
    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, age, adresse, numeroTelephone);
    }
}
