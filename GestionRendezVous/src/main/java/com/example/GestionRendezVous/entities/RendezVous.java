package com.example.GestionRendezVous.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rendez_vous")
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_rendez_vous", nullable = false)
    private LocalDateTime dateRendezVous;

    @Column(name = "id_patient", nullable = false)
    private Long idPatient;

    @Column(name = "nom_medecin", nullable = false)
    private String nomMedecin;

    @Column(name = "motif", length = 500)
    private String motif;

    // Constructeurs
    public RendezVous() {
    }

    public RendezVous(LocalDateTime dateRendezVous, Long idPatient, String nomMedecin, String motif) {
        this.dateRendezVous = dateRendezVous;
        this.idPatient = idPatient;
        this.nomMedecin = nomMedecin;
        this.motif = motif;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(LocalDateTime dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}