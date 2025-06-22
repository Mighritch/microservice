package com.example.GestionPatient.services;

import com.example.GestionPatient.entities.Patient;
import com.example.GestionPatient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for managing Patient entities.
 */
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    /**
     * Create a new patient.
     * @param patient The patient to create.
     * @return The created patient.
     */
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     * Get all patients.
     * @return List of all patients.
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * Get a patient by ID.
     * @param id The ID of the patient.
     * @return The patient if found.
     * @throws RuntimeException if patient not found.
     */
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    /**
     * Update an existing patient.
     * @param id The ID of the patient to update.
     * @param patientDetails The updated patient details.
     * @return The updated patient.
     * @throws RuntimeException if patient not found.
     */
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient patient = getPatientById(id);
        patient.setNom(patientDetails.getNom());
        patient.setPrenom(patientDetails.getPrenom());
        patient.setAge(patientDetails.getAge());
        patient.setAdresse(patientDetails.getAdresse());
        patient.setNumeroTelephone(patientDetails.getNumeroTelephone());
        return patientRepository.save(patient);
    }

    /**
     * Delete a patient by ID.
     * @param id The ID of the patient to delete.
     * @throws RuntimeException if patient not found.
     */
    public void deletePatient(Long id) {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }

    /**
     * Search patients by first name (prenom).
     * @param prenom The first name to search for.
     * @return List of patients matching the first name.
     */
    public List<Patient> searchPatientsByPrenom(String prenom) {
        return patientRepository.findByPrenomContainingIgnoreCase(prenom);
    }

    /**
     * Get all patients sorted by age.
     * @return List of patients sorted by age in ascending order.
     */
    public List<Patient> getPatientsSortedByAge() {
        return patientRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Patient::getAge))
                .collect(Collectors.toList());
    }
}