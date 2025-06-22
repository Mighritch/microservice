package com.example.GestionPatient.repositories;

import com.example.GestionPatient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Patient entity.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    /**
     * Find patients by first name (prenom).
     * @param prenom The first name to search for.
     * @return List of patients with the given first name.
     */
    List<Patient> findByPrenomContainingIgnoreCase(String prenom);
}